
-Xms512m
-Xmx2048m
-XX:MaxMetaspaceSize=256m
-XX:+UseG1GC
-XX:+UseStringDeduplication
-XX:+ScavengeBeforeFullGC
-XX:ParallelGCThreads=2
-XX:ConcGCThreads=1
-XX:+ExitOnOutOfMemoryError
-Djava.net.preferIPv4Stack=true


java -Djava.rmi.server.hostname=10.xx.xx.xx 
-Djava.security.policy=jstatd.all.policy 
-Dcom.sun.management.jmxremote.authenticate=false 
-Dcom.sun.management.jmxremote.ssl=false 
-Dcom.sun.management.jmxremote.port=8888  
-Xms4g -Xmx4g  -jar bug-0.0.1-SNAPSHOT.jar

-Xms64m 最小堆内存 64m.
-Xmx128m 最大堆内存 128m.
-XX:NewSize=30m 新生代初始化大小为30m.
-XX:MaxNewSize=40m 新生代最大大小为40m.
-Xss=256k 线程栈大小。
-XX:+PrintHeapAtGC 当发生 GC 时打印内存布局。
-XX:+HeapDumpOnOutOfMemoryError 发送内存溢出时 dump 内存。
新生代和老年代的默认比例为 1:2，也就是说新生代占用 1/3的堆内存，而老年代占用 2/3 的堆内存。

可以通过参数 -XX:NewRatio=2 来设置老年代/新生代的比例。