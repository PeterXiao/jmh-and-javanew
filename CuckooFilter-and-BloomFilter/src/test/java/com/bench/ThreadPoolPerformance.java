 package com.bench;

 /**
 * @author xiaoy
 * @date 2020/08/01
 */
 import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

 /**
  * 线程池 vs 线程 性能对比
  */
@BenchmarkMode(Mode.AverageTime) // 测试完成时间
@OutputTimeUnit(TimeUnit.MILLISECONDS) // TimeUnit.NANOSECONDS
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS) // 预热 2 轮，每次 1s
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS) // 测试 5 轮，每次 3s
@Fork(1) // fork 1 个线程
@State(Scope.Thread) // 每个测试线程一个实例
 public class ThreadPoolPerformance {
     // 最大执行次数 100000次数
     public static final int maxCount = 100_000;

     public static void main(String[] args) throws InterruptedException, RunnerException {
         // 线程测试代码
         // ThreadPerformanceTest();

         // 线程池测试代码
         // ThreadPoolPerformanceTest();

         // 启动基准测试
         Options opt = new OptionsBuilder().include(ThreadPoolPerformance.class.getSimpleName()) // 要导入的测试类
             .build();
         new Runner(opt).run(); // 执行测试
     }

     /**
      * 线程池性能测试 private
      */
     @Benchmark
     public static void ThreadPoolPerformanceTest() throws InterruptedException {
         // 开始时间
         // long stime = System.currentTimeMillis();
         // 业务代码
         ThreadPoolExecutor tp = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
         for (int i = 0; i < maxCount; i++) {
             tp.execute(new PerformanceRunnable());
         }
         tp.shutdown();
         tp.awaitTermination(1, TimeUnit.SECONDS); // 等待线程池执行完成
         // 结束时间
         // long etime = System.currentTimeMillis();
         // 计算执行时间
         // System.out.printf("线程池执行时长：%d 毫秒.", (etime - stime));
         // System.out.println();
     }

     /**
      * 线程性能测试
      */
     @Benchmark
     public static void ThreadPerformanceTest() {
         // 开始时间
         // long stime = System.currentTimeMillis();
         // 执行业务代码
         for (int i = 0; i < maxCount; i++) {
             Thread td = new Thread(new PerformanceRunnable());
             td.start();
             try {
                 td.join(); // 确保线程执行完成
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         // 结束时间
         // long etime = System.currentTimeMillis();
         // 计算执行时间
         // System.out.printf("线程执行时长：%d 毫秒.", (etime - stime));
         // System.out.println();
     }

     // 业务执行类
     static class PerformanceRunnable implements Runnable {
         @Override
         public void run() {
             for (int i = 0; i < maxCount; i++) {
                 long num = i * i + i;
             }
         }
     }
 }

