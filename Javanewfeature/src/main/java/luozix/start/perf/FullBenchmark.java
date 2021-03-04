/**
 * Project Name:java11_in_action File Name:FullBenchmark.java Package Name:luozix.start.perf
 * Date:2021年3月4日下午4:17:10 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: FullBenchmark.java @Package luozix.start.perf @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:17:10
 * @version V1.0
 */
package luozix.start.perf;
/**
 * ClassName:FullBenchmark <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午4:17:10 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @ClassName: FullBenchmark @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:17:10
 * @version
 * @since JDK 1.8
 */
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;

public class FullBenchmark {
  @State(Scope.Benchmark)
  public static class BenchmarkState {
    @Param({"1", "100", "100000"})
    int size;

    Map<Integer, String> hashMap;
    Map<Integer, String> int2ObjectArrayMap;

    @Setup
    public void setup() {
      hashMap = buildHashMap(size);
      int2ObjectArrayMap = buildInt2ObjectArrayMap(size);
    }

    private static Map<Integer, String> buildInt2ObjectArrayMap(Integer size) {
      Int2ObjectArrayMap<String> map = new Int2ObjectArrayMap<>();
      for (int i = 0; i < size; i++) {
        map.put(i, "");
      }
      return map;
    }

    private static Map<Integer, String> buildHashMap(Integer size) {
      Map<Integer, String> map = new HashMap<>();
      for (int i = 0; i < size; i++) {
        map.put(i, "");
      }
      return map;
    }
  }

  @Benchmark
  public void getHashMap(BenchmarkState state) {
    int n = ThreadLocalRandom.current().nextInt(0, state.size);
    state.hashMap.get(n);
  }

  @Benchmark
  public void getInt2ObjectArrayMap(BenchmarkState state) {
    int n = ThreadLocalRandom.current().nextInt(0, state.size);
    state.int2ObjectArrayMap.get(n);
  }

  @Benchmark
  public void putHashMap(BenchmarkState state) {
    int n = ThreadLocalRandom.current().nextInt(0, state.size);
    state.hashMap.put(n, "Hello");
  }

  @Benchmark
  public void putInt2ObjectArrayMap(BenchmarkState state) {
    int n = ThreadLocalRandom.current().nextInt(0, state.size);
    state.int2ObjectArrayMap.put(n, "Hello");
  }

  public static void main(String[] args) throws RunnerException {
    Options opt =
        new OptionsBuilder()
            .include(FullBenchmark.class.getSimpleName())
            .warmupIterations(5)
            .measurementIterations(5)
            .forks(1)
            .build();

    new Runner(opt).run();
  }
}
