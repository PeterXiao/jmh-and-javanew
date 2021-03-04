/**
 * Project Name:java11_in_action File Name:LongStreamBenchmark.java Package
 * Name:luozix.start.perf.jmh.benchmarks Date:2021年3月4日下午4:47:27 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: LongStreamBenchmark.java @Package luozix.start.perf.jmh.benchmarks @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:47:27
 * @version V1.0
 */
package luozix.start.perf.jmh.benchmarks;
/**
 * ClassName:LongStreamBenchmark <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午4:47:27 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @ClassName: LongStreamBenchmark @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:47:27
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

//  Benchmark                      Mode  Cnt  Score   Error  Units
//  LongStreamBenchmark.longValue  avgt   40  2.055 ± 0.032  ms/op
//  LongStreamBenchmark.valueOf    avgt   40  7.372 ± 0.542  ms/op

@SuppressWarnings("ALL")
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(
    value = 2,
    jvmArgs = {"-Xms4G", "-Xmx4G"})
public class LongStreamBenchmark {
  private static final long N = 1_000_000L;
  private List<Long> nums;

  private Logger logger = Logger.getLogger(this.getClass().getName());

  public LongStreamBenchmark() {
    logger.info("Creating list of " + N + " longs");
    nums = LongStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
  }

  @Benchmark
  public long valueOf() {
    return nums.stream().mapToLong(Long::valueOf).sum();
  }

  @Benchmark
  public long longValue() {
    return nums.stream().mapToLong(Long::longValue).sum();
  }

  @TearDown(Level.Invocation)
  public void tearDown() {
    System.gc();
  }
}
