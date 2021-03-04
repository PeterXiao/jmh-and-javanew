/**
 * Project Name:java11_in_action File Name:CustomPoolBenchmark.java Package
 * Name:luozix.start.perf.jmh.parallel Date:2021年3月4日下午4:48:34 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: CustomPoolBenchmark.java @Package luozix.start.perf.jmh.parallel @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:48:34
 * @version V1.0
 */
package luozix.start.perf.jmh.parallel;
/**
 * ClassName:CustomPoolBenchmark <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午4:48:34 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

/**
 * @ClassName: CustomPoolBenchmark @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:48:34
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

// Benchmark                                    Mode  Cnt  Score   Error  Units
// CustomPoolBenchmark.addNumsBiggerCommonPool  avgt   40  2.787 ± 0.095  ms/op
// CustomPoolBenchmark.addNumsCommonPool        avgt   40  1.665 ± 0.647  ms/op
// CustomPoolBenchmark.addNumsCustomFJPool      avgt   40  4.663 ± 0.140  ms/op

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(
    value = 2,
    jvmArgs = {"-Xms4G", "-Xmx4G"})
public class CustomPoolBenchmark {
  private static final int SIZE = 3_000_000;

  @Benchmark
  public long addNumsCommonPool() {
    return LongStream.rangeClosed(1, SIZE).parallel().sum();
  }

  @Benchmark
  @Fork(jvmArgsAppend = "-Djava.util.concurrent.ForkJoinPool.common.parallelism=32")
  public long addNumsBiggerCommonPool() {
    return LongStream.rangeClosed(1, SIZE).parallel().sum();
  }

  @Benchmark
  public long addNumsCustomFJPool() {
    long total = 0;
    ForkJoinPool pool = new ForkJoinPool(16);
    ForkJoinTask<Long> task = pool.submit(() -> LongStream.rangeClosed(1, SIZE).parallel().sum());
    try {
      total = task.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } finally {
      pool.shutdown();
    }
    return total;
  }

  @TearDown(Level.Invocation)
  public void tearDown() {
    System.gc();
  }
}
