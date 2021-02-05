#  算法
 
 评价指标：
 
	  1.正确性  注意近似最优化算法
	  2.资源利用 eg: 时间 空间
	      时间度量关注增长量级。
 
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
