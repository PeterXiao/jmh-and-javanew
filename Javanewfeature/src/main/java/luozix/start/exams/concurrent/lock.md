偏向锁-->轻量级锁-->自旋锁-->重量级锁

# ReentrantLock 实现原理  copy

使用 `synchronized` 来做同步处理时，锁的获取和释放都是隐式的，实现的原理是通过编译后加上不同的机器指令来实现。

而 `ReentrantLock` 就是一个普通的类，它是基于 `AQS(AbstractQueuedSynchronizer)`来实现的。

是一个**重入锁**：一个线程获得了锁之后仍然可以**反复**的加锁，不会出现自己阻塞自己的情况。

> `AQS` 是 `Java` 并发包里实现锁、同步的一个重要的基础框架。


## 锁类型

ReentrantLock 分为**公平锁**和**非公平锁**，可以通过构造方法来指定具体类型：

```java
    //默认非公平锁
    public ReentrantLock() {
        sync = new NonfairSync();
    }
    
    //公平锁
    public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }
```

默认一般使用**非公平锁**，它的效率和吞吐量都比公平锁高的多(后面会分析具体原因)。

## 获取锁

通常的使用方式如下:

```java
    private ReentrantLock lock = new ReentrantLock();
    public void run() {
        lock.lock();
        try {
            //do bussiness
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
```

### 公平锁获取锁
首先看下获取锁的过程：

```java
    public void lock() {
        sync.lock();
    }
```

可以看到是使用 `sync`的方法，而这个方法是一个抽象方法，具体是由其子类(`FairSync`)来实现的，以下是公平锁的实现:

```java
        final void lock() {
            acquire(1);
        }
        
        //AbstractQueuedSynchronizer 中的 acquire()
        public final void acquire(int arg) {
        if (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt();
    	}
```

第一步是尝试获取锁(`tryAcquire(arg)`),这个也是由其子类实现：

```java
        protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
    }
```

首先会判断 `AQS` 中的 `state` 是否等于 0，0 表示目前没有其他线程获得锁，当前线程就可以尝试获取锁。

**注意**:尝试之前会利用 `hasQueuedPredecessors()` 方法来判断 AQS 的队列中中是否有其他线程，如果有则不会尝试获取锁(**这是公平锁特有的情况**)。

如果队列中没有线程就利用 CAS 来将 AQS 中的 state 修改为1，也就是获取锁，获取成功则将当前线程置为获得锁的独占线程(`setExclusiveOwnerThread(current)`)。

如果 `state` 大于 0 时，说明锁已经被获取了，则需要判断获取锁的线程是否为当前线程(`ReentrantLock` 支持重入)，是则需要将 `state + 1`，并将值更新。


#### 写入队列
如果 `tryAcquire(arg)` 获取锁失败，则需要用 `addWaiter(Node.EXCLUSIVE)` 将当前线程写入队列中。

写入之前需要将当前线程包装为一个 `Node` 对象(`addWaiter(Node.EXCLUSIVE)`)。

> AQS 中的队列是由 Node 节点组成的双向链表实现的。


包装代码:

```java
    private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);
        // Try the fast path of enq; backup to full enq on failure
        Node pred = tail;
        if (pred != null) {
            node.prev = pred;
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }
        enq(node);
        return node;
    }

```

首先判断队列是否为空，不为空时则将封装好的 `Node` 利用 `CAS` 写入队尾，如果出现并发写入失败就需要调用 `enq(node);` 来写入了。

```java
    private Node enq(final Node node) {
        for (;;) {
            Node t = tail;
            if (t == null) { // Must initialize
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }
```

这个处理逻辑就相当于`自旋`加上 `CAS` 保证一定能写入队列。

#### 挂起等待线程

写入队列之后需要将当前线程挂起(利用`acquireQueued(addWaiter(Node.EXCLUSIVE), arg)`)：

```java
    final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                final Node p = node.predecessor();
                if (p == head && tryAcquire(arg)) {
                    setHead(node);
                    p.next = null; // help GC
                    failed = false;
                    return interrupted;
                }
                if (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {
            if (failed)
                cancelAcquire(node);
        }
    }
```

首先会根据 `node.predecessor()` 获取到上一个节点是否为头节点，如果是则尝试获取一次锁，获取成功就万事大吉了。

如果不是头节点，或者获取锁失败，则会根据上一个节点的 `waitStatus` 状态来处理(`shouldParkAfterFailedAcquire(p, node)`)。

`waitStatus` 用于记录当前节点的状态，如节点取消、节点等待等。

`shouldParkAfterFailedAcquire(p, node)` 返回当前线程是否需要挂起，如果需要则调用 `parkAndCheckInterrupt()`：

```java
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        return Thread.interrupted();
    }
```

他是利用 `LockSupport` 的 `part` 方法来挂起当前线程的，直到被唤醒。


### 非公平锁获取锁
公平锁与非公平锁的差异主要在获取锁：

公平锁就相当于买票，后来的人需要排到队尾依次买票，**不能插队**。

而非公平锁则没有这些规则，是**抢占模式**，每来一个人不会去管队列如何，直接尝试获取锁。

非公平锁:
```java
        final void lock() {
            //直接尝试获取锁
            if (compareAndSetState(0, 1))
                setExclusiveOwnerThread(Thread.currentThread());
            else
                acquire(1);
        }
```

公平锁:
```java
        final void lock() {
            acquire(1);
        }
```

还要一个重要的区别是在尝试获取锁时`tryAcquire(arg)`，非公平锁是不需要判断队列中是否还有其他线程，也是直接尝试获取锁：

```java
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                //没有 !hasQueuedPredecessors() 判断
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
```

## 释放锁

公平锁和非公平锁的释放流程都是一样的：

```java
    public void unlock() {
        sync.release(1);
    }
    
    public final boolean release(int arg) {
        if (tryRelease(arg)) {
            Node h = head;
            if (h != null && h.waitStatus != 0)
            	   //唤醒被挂起的线程
                unparkSuccessor(h);
            return true;
        }
        return false;
    }
    
    //尝试释放锁
    protected final boolean tryRelease(int releases) {
        int c = getState() - releases;
        if (Thread.currentThread() != getExclusiveOwnerThread())
            throw new IllegalMonitorStateException();
        boolean free = false;
        if (c == 0) {
            free = true;
            setExclusiveOwnerThread(null);
        }
        setState(c);
        return free;
    }        
```

首先会判断当前线程是否为获得锁的线程，由于是重入锁所以需要将 `state` 减到 0 才认为完全释放锁。

释放之后需要调用 `unparkSuccessor(h)` 来唤醒被挂起的线程。


## 总结

由于公平锁需要关心队列的情况，得按照队列里的先后顺序来获取锁(会造成大量的线程上下文切换)，而非公平锁则没有这个限制。

所以也就能解释非公平锁的效率会被公平锁更高。


Lock&Condition

Lock用于控制多线程对同一状态的顺序访问，保证该状态的连续性。
Condition用于控制多线程之间的、基于该状态的条件等待。

重量级锁降级发生于STW阶段，降级对象为仅仅能被VMThread访问而没有其他JavaThread访问的对象。

1，HotSpot JVM/JRockit JVM是支持锁降级的

2，HotSpot JVM/JRockit JVM是偏向锁是可以重偏向的（STW期间不能，补充前面留的小坑）

3，要好好学英文，要有一颗好奇的心



所谓死锁： 是指两个或两个以上的进程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，若无外力作用，它们都将无法推进下去。此时称系统处于死锁状态或系统产生了死锁，这些永远在互相等待的进程称为死锁进程。

产生条件
虽然进程在运行过程中，可能发生死锁，但死锁的发生也必须具备一定的条件，死锁的发生必须具备以下四个必要条件。
1）互斥条件：指进程对所分配到的资源进行排它性使用，即在一段时间内某资源只由一个进程占用。如果此时还有其它进程请求资源，则请求者只能等待，直至占有资源的进程用毕释放。
2）请求和保持条件：指进程已经保持至少一个资源，但又提出了新的资源请求，而该资源已被其它进程占有，此时请求进程阻塞，但又对自己已获得的其它资源保持不放。
3）不剥夺条件：指进程已获得的资源，在未使用完之前，不能被剥夺，只能在使用完时由自己释放。
4）环路等待条件：指在发生死锁时，必然存在一个进程——资源的环形链，即进程集合{P0，P1，P2，···，Pn}中的P0正在等待一个P1占用的资源；P1正在等待P2占用的资源，……，Pn正在等待已被P0占用的资源。

产生原因

1）竞争资源引起进程死锁
当系统中供多个进程共享的资源如打印机、公用队列的等，其数目不足以满足诸进程的需要时，会引起诸进程对资源的竞争而产生死锁。
2）可剥夺资源和不可剥夺资源
系统中的资源可以分为两类，一类是可剥夺资源，是指某进程在获得这类资源后，该资源可以再被其他进程或系统剥夺。例如，优先权高的进程可以剥夺优先权低的进程的处理机。又如，内存区可由存储器管理程序，把一个进程从一个存储区移到另一个存储区，此即剥夺了该进程原来占有的存储区，甚至可将一进程从内存调到外存上，可见，CPU和主存均属于可剥夺性资源。另一类资源是不可剥夺资源，当系统把这类资源分配给某进程后，再不能强行收回，只能在进程用完后自行释放，如磁带机、打印机等。
3）竞争不可剥夺资源
在系统中所配置的不可剥夺资源，由于它们的数量不能满足诸进程运行的需要，会使进程在运行过程中，因争夺这些资源而陷于僵局。例如，系统中只有一台打印机R1和一台磁带机R2，可供进程P1和P2共享。假定PI已占用了打印机R1，P2已占用了磁带机R2，若P2继续要求打印机R1，P2将阻塞；P1若又要求磁带机，P1也将阻塞。于是，在P1和P2之间就形成了僵局，两个进程都在等待对方释放自己所需要的资源，但是它们又都因不能继续获得自己所需要的资源而不能继续推进，从而也不能释放自己所占有的资源，以致进入死锁状态。
4）竞争临时资源
上面所说的打印机资源属于可顺序重复使用型资源，称为永久资源。还有一种所谓的临时资源，这是指由一个进程产生，被另一个进程使用，短时间后便无用的资源，故也称为消耗性资源，如硬件中断、信号、消息、缓冲区内的消息等，它也可能引起死锁。例如，SI，S2，S3是临时性资源，进程P1产生消息S1，又要求从P3接收消息S3；进程P3产生消息S3，又要求从进程P2处接收消息S2；进程P2产生消息S2，又要求从P1处接收产生的消息S1。如果消息通信按如下顺序进行：
P1: ···Relese（S1）；Request（S3）； ···
P2: ···Relese（S2）；Request（S1）； ···
P3: ···Relese（S3）；Request（S2）； ···
并不可能发生死锁。但若改成下述的运行顺序：
P1: ···Request（S3）；Relese（S1）；···
P2: ···Request（S1）；Relese（S2）； ···
P3: ···Request（S2）；Relese（S3）； ···
则可能发生死锁。
2.进程推进顺序不当引起死锁
由于进程在运行中具有异步性特征，这可能使P1和P2两个进程按下述两种顺序向前推进。
1） 进程推进顺序合法
当进程P1和P2并发执行时，如果按照下述顺序推进：P1：Request（R1）； P1：Request（R2）； P1: Relese（R1）；P1: Relese（R2）； P2：Request（R2）； P2：Request（R1）； P2: Relese（R2）；P2: Relese（R1）；这两个进程便可顺利完成，这种不会引起进程死锁的推进顺序是合法的。
2） 进程推进顺序非法
若P1保持了资源R1,P2保持了资源R2，系统处于不安全状态，因为这两个进程再向前推进，便可能发生死锁。例如，当P1运行到P1：Request（R2）时，将因R2已被P2占用而阻塞；当P2运行到P2：Request（R1）时，也将因R1已被P1占用而阻塞，于是发生进程死锁。
预防编辑
理解了死锁的原因，尤其是产生死锁的四个必要条件，就可以最大可能地避免、预防和解除死锁。只要打破四个必要条件之一就能有效预防死锁的发生：打破互斥条件：改造独占性资源为虚拟资源，大部分资源已无法改造。打破不可抢占条件：当一进程占有一独占性资源后又申请一独占性资源而无法满足，则退出原占有的资源。打破占有且申请条件：采用资源预先分配策略，即进程运行前申请全部资源，满足则运行，不然就等待，这样就不会占有且申请。打破循环等待条件：实现资源有序分配策略，对所有设备实现分类编号，所有进程只能采用按序号递增的形式申请资源。[2]
所以，在系统设计、进程调度等方面注意如何不让这四个必要条件成立，如何确定资源的合理分配算法，避免进程永久占据系统资源。此外，也要防止进程在处于等待状态的情况下占用资源,在系统运行过程中，对进程发出的每一个系统能够满足的资源申请进行动态检查，并根据检查结果决定是否分配资源，若分配后系统可能发生死锁，则不予分配，否则予以分配。因此，对资源的分配要给予合理的规划。
下面几种方法可用以避免重装死锁的发生：
①允许目的节点将不完整的报文递交给目的端系统；
②一个不能完整重装的报文能被检测出来，并要求发送该报文的源端系统重新传送；
③为每个节点配备一个后备缓冲空间，用以暂存不完整的报文。
①、②两种方法不能很满意地解决重装死锁，因为它们使端系统中的协议复杂化了。一般的设计中，网络层应该对端系统透明，也即端系统不该考虑诸如报文拆、装之类的事。③方法虽然不涉及端系统,但使每个节点增加了开销。
有序资源分配法
这种算法资源按某种规则系统中的所有资源统一编号（例如打印机为1、磁带机为2、磁盘为3、等等），申请时必须以上升的次序。系统要求申请进程：
1、对它所必须使用的而且属于同一类的所有资源，必须一次申请完；
2、在申请不同类资源时，必须按各类设备的编号依次申请。例如：进程PA，使用资源的顺序是R1，R2； 进程PB，使用资源的顺序是R2，R1；若采用动态分配有可能形成环路条件，造成死锁。
采用有序资源分配法：R1的编号为1，R2的编号为2；
PA：申请次序应是：R1，R2
PB：申请次序应是：R1，R2
这样就破坏了环路条件，避免了死锁的发生
银行家算法
避免死锁算法中最有代表性的算法是Dijkstra E.W 于1968年提出的银行家算法：
银行家算法是避免死锁的一种重要方法，防止死锁的机构只能确保上述四个条件之一不出现，则系统就不会发生死锁。通过这个算法可以用来解决生活中的实际问题，如银行贷款等。[3]
程序实现思路银行家算法顾名思义是来源于银行的借贷业务，一定数量的本金要应多个客户的借贷周转，为了防止银行家资金无法周转而倒闭，对每一笔贷款，必须考察其是否能限期归还。在操作系统中研究资源分配策略时也有类似问题，系统中有限的资源要供多个进程使用，必须保证得到的资源的进程能在有限的时间内归还资源，以供其他进程使用资源。如果资源分配不得到就会发生进程循环等待资源，则进程都无法继续执行下去的死锁现象。[3]
把一个进程需要和已占有资源的情况记录在进程控制中，假定进程控制块PCB其中“状态”有就绪态、等待态和完成态。当进程在处于等待态时，表示系统不能满足该进程当前的资源申请。“资源需求总量”表示进程在整个执行过程中总共要申请的资源量。显然，每个进程的资源需求总量不能超过系统拥有的资源总数， 银行算法进行资源分配可以避免死锁。[3]
处理方法编辑
在系统中已经出现死锁后，应该及时检测到死锁的发生，并采取适当的措施来解除死锁。[4]

预防死锁。
这是一种较简单和直观的事先预防的方法。方法是通过设置某些限制条件，去破坏产生死锁的四个必要条件中的一个或者几个，来预防发生死锁。预防死锁是一种较易实现的方法，已被广泛使用。但是由于所施加的限制条件往往太严格，可能会导致系统资源利用率和系统吞吐量降低。
避免死锁。
该方法同样是属于事先预防的策略，但它并不须事先采取各种限制措施去破坏产生死锁的的四个必要条件，而是在资源的动态分配过程中，用某种方法去防止系统进入不安全状态，从而避免发生死锁。
3)检测和解除死锁。
先检测：这种方法并不须事先采取任何限制性措施，也不必检查系统是否已经进入不安全区，此方法允许系统在运行过程中发生死锁。但可通过系统所设置的检测机构，及时地检测出死锁的发生，并精确地确定与死锁有关的进程和资源。检测方法包括定时检测、效率低时检测、进程等待时检测等。
然后解除死锁：采取适当措施，从系统中将已发生的死锁清除掉。
这是与检测死锁相配套的一种措施。当检测到系统中已发生死锁时，须将进程从死锁状态中解脱出来。常用的实施方法是撤销或挂起一些进程，以便回收一些资源，再将这些资源分配给已处于阻塞状态的进程，使之转为就绪状态，以继续运行。死锁的检测和解除措施，有可能使系统获得较好的资源利用率和吞吐量，但在实现上难度也最大。
排除方法编辑
1、撤消陷于死锁的全部进程；
2、逐个撤消陷于死锁的进程，直到死锁不存在；
3、从陷于死锁的进程中逐个强迫放弃所占用的资源，直至死锁消失。
4、从另外一些进程那里强行剥夺足够数量的资源分配给死锁进程，以解除死锁状态
计算机网络的死锁
死锁是网络中最容易发生的故障之一，即使在网络负荷不很重时也会发生。死锁发生时，一组节点由于没有空闲缓冲区而无法接收和转发分组，节点之间相互等待，既不能接收分组也不能转发分组，并一直保持这一僵局，严重时甚至导致整个网络的瘫痪。此时，只能靠人工干预来重新启动网络，解除死锁。但重新启动后并未消除引起死锁的隐患，所以可能再次发生死锁。死锁是由于控制技术方面的某些缺陷所引起的，起因通常难以捉摸、难以发现，即使发现，也常常不能立即修复。因此，在各层协议中都必须考虑如何避免死锁的问题。
存储转发死锁及其防止
最常见的死锁是发生在两个节点之间的直接存储转发死锁。例如，A节点的所有缓冲区装满了等待输出到B节点的分组，而B节点的所有缓冲区也全部装满了等待输出到A节点的分组；此时，A节点不能从B节点接收分组，B节点也不能从A节点接收分组，从而造成两节点间的死锁。这种情况也可能发生在一组节点之间，例如，A节点企图向B节点发送分组、B节点企图向C节点发送分组、而C节点又企图向A节点发送分组，但此时每个节点都无空闲缓冲区用于接收分组，这种情形称做间接存储转发死锁。当一个节点处于死锁状态时，所有与之相连的链路将被完全拥塞。
一种防止存储转发死锁的方法是，每个节点设置M+1个缓冲区，并以0到M编号。M为通信子网的直径，即从任一源节点到任一目的节点间的最大链路段数。每个源节点仅当其0号缓冲区空时才能接收源端系统来的分组，而此分组仅能转发给1号缓冲区空闲的相邻节点，再由该节点将分组转发给它的2号缓冲区空闲的相邻节点……最后，该分组或者顺利到达目的节点并被递交给目的端系统，或者到了某个节点编号为M的缓冲区中再也转发不下去，此时一定发生了循环,应该将该分组丢弃。由于每个分组都是按照编号递增规则分配缓冲区，所以节点之间不会相互等待空闲缓冲区而发生死锁现象。这种方法的不足之处在于，当某节点虽然有空闲缓冲区，但正巧没有所需要的特定编号的缓冲区时，分组仍要等待，从而造成了缓冲区和链路的浪费。
另一种防止存储转发死锁的方法是，使每个分组上都携带一个全局性的惟一的"时间戳",每个节点要为每条输入链路保留一个特殊的接收缓冲区，而其它缓冲区均可用于存放中转分组。在每条输出链路的队列上分组按时间戳顺序排队。例如，节点A要将分组送到节点B，若B节点没有空闲缓冲区，但正巧有要送到A节点的分组，此时A、B节点可通过特殊的接收缓冲区交换分组；若B节点既没有空闲缓冲区，也没有要送往A节点的分组，B节点只好强行将一个出路方向大致与A节点方向相同的分组与A节点互相交换分组，但此时A节点中的分组必须比B节点中的分组具有更早的时间戳，这样才能保证子网中某个最早的分组不受阻挡地转发到目的地。由此可见，每个分组最终总会成为最早的分组，并总能被一步一步地发送到目的节点，从而避免了死锁现象的发生。
重装死锁及其防止
死锁中比较严重的情况是重装死锁。假设发给一个端系统的报文很长，被源节点拆成若干个分组发送，目的节点要将所有具有相同编号的分组重新装配成报文递交给目的端系统，若目的节点用于重装报文的缓冲区空间有限，而且它无法知道正在接收的报文究竟被拆成多少个分组，此时，就可能发生严重的问题：为了接收更多的分组，该目的节点用完了它的缓冲空间，但它又不能将尚未拼装完整的报文递送给目的端系统，而邻节点仍在不断地向它传送分组，但它却无法接收。这样，经过多次尝试后，邻节点就会绕道从其它途径再向该目的节点传送分组，但该目的节点已被死锁，其周边区域也由此发生了拥塞。
表级锁定编辑
HOLDLOCK 持有共享锁，直到整个事务完成，应该在被锁对象不需要时立即释放，等于SERIALIZABLE事务隔离级别
NOLOCK 语句执行时不发出共享锁，允许脏读 ，等于 READ UNCOMMITTED事务隔离级别
PAGLOCK 在使用一个表锁的地方用多个页锁
READPAST 让sql server跳过任何锁定行，执行事务，适用于READ UNCOMMITTED事务隔离级别只跳过RID锁，不跳过页，区域和表锁
ROWLOCK 强制使用行锁
TABLOCKX 强制使用独占表级锁，这个锁在事务期间阻止任何其他事务使用这个表
UPLOCK 强制在读表时使用更新而不用共享锁
