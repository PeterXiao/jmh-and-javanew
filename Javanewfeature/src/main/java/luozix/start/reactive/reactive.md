# 适合Reactive programming

第一种情况是业务逻辑本身就使用事件来描述。Twitter 就是一个经典例子。Twitter 是一种订 阅文字流信息的服务，用户彼此之间推送信息。使用事件驱动架构编写应用，能准确地为业 务建模。图形化展示股票价格可能是另一个例子，每一次价格的变动都可认为是一个事件。

另一种显然的用例是应用需要同时处理大量 I/O 操作。阻塞式 I/O 需要同时使用大量线程， 这会导致大量锁之间的竞争和太多的上下文切换。如果想要处理成千上万的连接，非阻塞 式 I/O 通常是更好的选择。


提高编程的基本任务方面还有很长的路要走：

	如何把程序写得易读？
	何明确 地表明程序的意图？
	如何让高性能程序易于编写？
	
	
选择一个熟悉的代码库，分析它的设计和架构。

从宏观上看，有没有更好的实现方法？  
 能否简化设计？  
 能否减少实现某功能所需的代码量？  
 怎样让代码更易读	