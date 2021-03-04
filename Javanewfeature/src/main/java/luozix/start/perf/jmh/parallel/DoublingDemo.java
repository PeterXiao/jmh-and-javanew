/**
 * Project Name:java11_in_action File Name:DoublingDemo.java Package
 * Name:luozix.start.perf.jmh.parallel Date:2021年3月4日下午4:49:18 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: DoublingDemo.java @Package luozix.start.perf.jmh.parallel @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:49:18
 * @version V1.0
 */
package luozix.start.perf.jmh.parallel;
/**
 * ClassName:DoublingDemo <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午4:49:18 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName: DoublingDemo @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:49:18
 * @version
 * @since JDK 1.8
 */
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

// latest results:
// Benchmark                            Mode  Cnt    Score   Error  Units
// DoublingDemo.doubleAndSumParallel    avgt   10  104.450 ± 0.118  ms/op
// DoublingDemo.doubleAndSumSequential  avgt   10  625.347 ± 0.800  ms/op

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(
    value = 2,
    jvmArgs = {"-Xms4G", "-Xmx4G"})
public class DoublingDemo {
  public int doubleIt(int n) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException ignored) {
    }
    return n * 2;
  }

  @Benchmark
  public int doubleAndSumSequential() {
    return IntStream.of(3, 1, 4, 1, 5, 9).map(this::doubleIt).sum();
  }

  @Benchmark
  public int doubleAndSumParallel() {
    return IntStream.of(3, 1, 4, 1, 5, 9).parallel().map(this::doubleIt).sum();
  }
}
