#  算法
 
 评价指标：
 
	  1.正确性  注意近似最优化算法
	  2.资源利用 eg: 时间 空间
	      时间度量关注增长量级。
在计算机的世界里，算法则是指某项操作的过程。 
算法是由单步操作组合而来。
估算执行时间的时候，仅虚拟算法考虑大数情况下。

循环不变式证明。


归并排序分为：原址归并，复制归并。

快排： 快排原地排序，最坏时间n^2,平均 nlgn


 
 
	 Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
	        while (entryIterator.hasNext()) {
	            Map.Entry<String, Integer> next = entryIterator.next();
	            System.out.println("key=" + next.getKey() + " value=" + next.getValue());
	        }
        
        
	Iterator<String> iterator = map.keySet().iterator();
	        while (iterator.hasNext()){
	            String key = iterator.next();
	            System.out.println("key=" + key + " value=" +       map.get(key));
	
	        }
        
        
	map.forEach((key,value)->{
	    System.out.println("key=" + key + " value=" + value);
	});
	
推荐第一种

总的来说 LinkedHashMap 其实就是对 HashMap 进行了拓展，使用了双向链表来保证了顺序性。

因为是继承于 HashMap 的，所以一些 HashMap 存在的问题 LinkedHashMap 也会存在，比如不支持并发等。


# TCP/IP 协议

`TCP/IP` 总结起来就三个要点
- 三次握手的意义。
- 超时重发。
- 滑动窗口。

## 三次握手
![](https://ws4.sinaimg.cn/large/006tNc79gy1fms9a563c3j30o309ogmc.jpg)

如图类似：
1. 发送者问接收者我发消息了，你收到了嘛？
2. 接收者回复发送者我收到了，你发消息没问题，我收消息也没问题。但我不知道我的发消息有没有问题，你收到了回复我下。
3. 发送者告诉接收者，我收到你的消息了，你发消息没问题。通信成功我们开始工作吧！


## 超时重发

当发送者向接收者发包后，如果过了一段时间(超时时间)依然没有收到消息，就当做本次包丢失，需要重新补发。

并且如果一次性发了三个包，只要最后一个包确认收到之后就默认前面两个也收到了。

## 滑动窗口
假设一次性发送包的大小为3，那么每次可以发3个包，而且可以边发边接收，这样就会增强效率。这里的 3 就是滑动窗口的大小，这样的发送方式也叫滑动窗口协议。


常见的如下：

-Xms64m 最小堆内存 64m.
-Xmx128m 最大堆内存 128m.
-XX:NewSize=30m 新生代初始化大小为30m.
-XX:MaxNewSize=40m 新生代最大大小为40m.
-Xss=256k 线程栈大小。
-XX:+PrintHeapAtGC 当发生 GC 时打印内存布局。
-XX:+HeapDumpOnOutOfMemoryError 发送内存溢出时 dump 内存。
新生代和老年代的默认比例为 1:2，也就是说新生代占用 1/3的堆内存，而老年代占用 2/3 的堆内存。

可以通过参数 -XX:NewRatio=2 来设置老年代/新生代的比例。	


long count = Stream.of(1, 2, 3, 4, 5)
        .map(i -> i + 1)
        .peek(System.out::println)
        .count();
System.out.println(count);

// java 8
// ReferencePipeline
@Override
public final long count() {
    return mapToLong(e -> 1L).sum();
}

// LongPipeline
@Override
public final long sum() {
    return reduce(0, Long::sum);
}

// java 11
// ReferencePipeline
@Override
public final long count() {
    return evaluate(ReduceOps.makeRefCounting());
}

// TerminalOp.makeRefCounting()
@Override
public  Long evaluateSequential(PipelineHelper helper,
                                      Spliterator spliterator) {
    if (StreamOpFlag.SIZED.isKnown(helper.getStreamAndOpFlags()))
        return spliterator.getExactSizeIfKnown();
    return super.evaluateSequential(helper, spliterator);
}

建议不要在使用Stream.count()终端操作时在流中添加有副作用的操作。


# 常见的数据结构
	栈（Stack）：栈是一种特殊的线性表，它只能在一个表的一个固定端进行数据结点的插入和删除操作。
	队列（Queue）：队列和栈类似，也是一种特殊的线性表。和栈不同的是，队列只允许在表的一端进行插入操作，而在另一端进行删除操作。
	数组（Array）：数组是一种聚合数据类型，它是将具有相同类型的若干变量有序地组织在一起的集合。
	链表（Linked List）：链表是一种数据元素按照链式存储结构进行存储的数据结构，这种存储结构具有在物理上存在非连续的特点。
	树（Tree）：树是典型的非线性结构，它是包括，2 个结点的有穷集合 K。
	图（Graph）：图是另一种非线性数据结构。在图结构中，数据结点一般称为顶点，而边是顶点的有序偶对。
	堆（Heap）：堆是一种特殊的树形数据结构，一般讨论的堆都是二叉堆。
	散列表（Hash table）：散列表源自于散列函数(Hash function)，其思想是如果在结构中存在关键字和T相等的记录，那么必定在F(T)的存储位置可以找到该记录，这样就可以不用进行比较操作而直接取得所查记录。
	
#常用算法

数据结构研究的内容：就是如何按一定的逻辑结构，把数据组织起来，并选择适当的存储表示方法把逻辑结构组织好的数据存储到计算机的存储器里。算法研究的目的是为了更有效的处理数据，提高数据运算效率。数据的运算是定义在数据的逻辑结构上，但运算的具体实现要在存储结构上进行。一般有以下几种常用运算：

	检索：检索就是在数据结构里查找满足一定条件的节点。一般是给定一个某字段的值，找具有该字段值的节点。
	插入：往数据结构中增加新的节点。
	删除：把指定的结点从数据结构中去掉。
	更新：改变指定节点的一个或多个字段的值。
	排序：把节点按某种指定的顺序重新排列。例如递增或递减。	