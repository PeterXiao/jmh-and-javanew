

java -cp "D:\Dev\Books Spaces\Java-11-and-12-New-Features-master\Chapter09" -XX:StartFlightRecording,filename=Epsilon.jfr -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC exploring_further/TestFlightRecorder

for((i=1;i<=20000000;i++)); do echo "set k$i v$i" >> /tmp/redisTest.txt ;done;

-XX：+PrintGC：输出GC日志
-XX：+PrintGCDetails：输出GC的详细日志
-XX：+PrintGCTimeStamps：输出GC的时间戳（以基准的时间的形式）
-XX：+PrintGCDateStamps：输出GC的时间戳（以日期的形式，如： 2020-05-04T21:25.234+0800）
-XX：+PrintHeapAtGC：在进行GC的前后打印出堆的信息
-Xloggc：…/logs/gc.log 日志文件的输出路径



<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.6</version>
</dependency>