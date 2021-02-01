 package jvm;

 import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
 /**
  * @author xiaoy
  * @date 2020/08/07
  */
 @BenchmarkMode(Mode.AverageTime)
 @OutputTimeUnit(TimeUnit.MICROSECONDS)
 @State(Scope.Thread)
 @Fork(3)
 @Warmup(iterations = 1)
 @Measurement(iterations = 3)
 public class BranchPredictionTest {
     private static Random random = new Random();
     private static int MAX_LENGTH = 10_000_000;
     private static int[] arr;
     private static int[] arrSotred;
     private static int THRESHLOD = MAX_LENGTH >> 1;

     @Setup
     public static void init() {
         arr = new int[MAX_LENGTH];
         for (int i = 0; i < MAX_LENGTH; i++) {
             arr[i] = random.nextInt(MAX_LENGTH);
         }
         arrSotred = Arrays.copyOf(arr, arr.length);
         Arrays.sort(arrSotred);
     }

     @Benchmark
     public static void countUnsortedArr() {
         int cnt = 0;
         for (int i = 0; i < MAX_LENGTH; i++) {
             if (arr[i] < THRESHLOD) {
                 cnt++;
             }
         }
     }

     @Benchmark
     public static void countSortedArr() {
         int cnt = 0;
         for (int i = 0; i < MAX_LENGTH; i++) {
             if (arrSotred[i] < THRESHLOD) {
                 cnt++;
             }
         }
     }

     public static void main(String[] args) throws RunnerException {
         Options opt = new OptionsBuilder().include(BranchPredictionTest.class.getSimpleName()).forks(1).build();
         new Runner(opt).run();
     }
 }