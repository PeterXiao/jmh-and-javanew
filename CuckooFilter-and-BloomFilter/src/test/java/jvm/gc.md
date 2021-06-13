

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


class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x() { return x; }
    int y() { return y; }

    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point other = (Point) o;
        return other.x == x && other.y = y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString() {
        return String.format("Point[x=%d, y=%d]", x, y);
    }
}


-XX:+UseG1GC // 开启G1
-XX:MaxGCPauseMillis=200 // 预期停顿时间200毫秒，默认也是200
-XX:G1HeapRegionSize=2 // 设置每个区域大小2M，其必须是2的幂，范围允许为1Mb到32Mb
-XX:G1NewSizePercent // 新生代最小值，默认值 5%
-XX:G1MaxNewSizePercent // 新生代最大值，默认值 60%
-XX:ParallelGCThreads // STW 期间，并行 GC 线程数
-XX:ConcGCThreads=n // 并发标记阶段，并行执行的线程数