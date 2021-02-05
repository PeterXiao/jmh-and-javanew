# Service provider interface

spi












共享内存状态加锁的机制会引出三个非常主要的问题：

	1.竞态条件，
	
	2.死锁，
	
	3.不能获得锁的进程将被挂起阻塞，

Actor Model 主要有幾個特點：

	輕量物件: Actor 是系統內的一個基礎單位，每個 Actor 只負責自己的工作，所以可以很輕量。
	
	沒有 shared state：每個 Actor 各自管理自己的 state，跑在各自的 thread 上，不共享 memory 與 state。
	
	透過 message 溝通：每個 Actor 會有一個 message queue，或稱作 mailbox，接收到的訊息會在此排隊等著依序執行。
	
	