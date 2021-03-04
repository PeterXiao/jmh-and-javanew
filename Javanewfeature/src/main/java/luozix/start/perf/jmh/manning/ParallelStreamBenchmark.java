/**
 * Project Name:java11_in_action File Name:ParallelStreamBenchmark.java Package
 * Name:luozix.start.perf.jmh.manning Date:2021年3月4日下午4:47:59 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ParallelStreamBenchmark.java @Package luozix.start.perf.jmh.manning @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:47:59
 * @version V1.0
 */
package luozix.start.perf.jmh.manning;
/**
 * ClassName:ParallelStreamBenchmark <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午4:47:59 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @ClassName: ParallelStreamBenchmark @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:47:59
 * @version
 * @since JDK 1.8
 */
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

// From Java 8 and 9 in Action (now called Modern Java in Action)

// Recent results:
//  Benchmark                                        Mode  Cnt   Score   Error  Units
//  ParallelStreamBenchmark.iterativeSum             avgt   40   6.441 ± 0.019  ms/op
//  ParallelStreamBenchmark.sequentialStreamSum      avgt   40  90.468 ± 0.613  ms/op
//  ParallelStreamBenchmark.parallelStreamSum        avgt   40  99.148 ± 3.065  ms/op
//  ParallelStreamBenchmark.sequentialLongStreamSum  avgt   40   6.191 ± 0.248  ms/op
//  ParallelStreamBenchmark.parallelLongStreamSum    avgt   40   6.571 ± 2.756  ms/op

// Benchmark                                        Mode  Cnt    Score   Error  Units
//        ParallelStreamBenchmark.iterativeSum             avgt   40    6.240 ± 0.210  ms/op
//        ParallelStreamBenchmark.parallelLongStreamSum    avgt   40    6.688 ± 2.355  ms/op
//        ParallelStreamBenchmark.parallelStreamSum        avgt   40  118.228 ± 2.560  ms/op
//        ParallelStreamBenchmark.sequentialLongStreamSum  avgt   40    8.626 ± 0.537  ms/op
//        ParallelStreamBenchmark.sequentialStreamSum      avgt   40   95.371 ± 2.182  ms/op

@SuppressWarnings("ALL")
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(
    value = 2,
    jvmArgs = {"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmark {
  private static final long N = 10_000_000L;

  @Benchmark
  public long iterativeSum() {
    long result = 0;
    for (long i = 1L; i <= N; i++) {
      result += i;
    }
    return result;
  }

  @Benchmark // Slowest possible stream
  public long sequentialStreamSum() {
    return Stream.iterate(1L, i -> i + 1) // Stream<Long>
        .limit(N)
        .reduce(0L, Long::sum);
  }

  @Benchmark
  public long parallelStreamSum() {
    return Stream.iterate(1L, i -> i + 1).limit(N).parallel().reduce(0L, Long::sum);
  }

  @Benchmark // Fastest possible stream
  public long sequentialLongStreamSum() {
    return LongStream.rangeClosed(1, N).sum();
  }

  @Benchmark
  public long parallelLongStreamSum() {
    return LongStream.rangeClosed(1, N).parallel().sum();
  }

  @TearDown(Level.Invocation)
  public void tearDown() {
    System.gc();
  }
}
