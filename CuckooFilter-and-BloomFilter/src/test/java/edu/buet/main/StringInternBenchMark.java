 package edu.buet.main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
 @BenchmarkMode(Mode.AverageTime)
 @OutputTimeUnit(TimeUnit.NANOSECONDS)
 @Fork(value = 1, jvmArgsPrepend = "-XX:+PrintStringTableStatistics")
 @Warmup(iterations = 5)
 @Measurement(iterations = 5)
 public class StringInternBenchMark {

     @Param({"1", "100", "10000", "1000000"})
     private int size;

     private StringInterner str;
     private ConcurrentHashMapInterner chm;
     private HashMapInterner hm;

     @Setup
     public void setup() {
         str = new StringInterner();
         chm = new ConcurrentHashMapInterner();
         hm = new HashMapInterner();
     }

     public static class StringInterner {
         public String intern(String s) {
             return s.intern();
         }
     }

     @Benchmark
     public void useIntern(Blackhole bh) {
         for (int c = 0; c < size; c++) {
             bh.consume(str.intern("doit" + c));
         }
     }

     public static class ConcurrentHashMapInterner {
         private final Map<String, String> map;

         public ConcurrentHashMapInterner() {
             map = new ConcurrentHashMap<>();
         }

         public String intern(String s) {
             String exist = map.putIfAbsent(s, s);
             return (exist == null) ? s : exist;
         }
     }

     @Benchmark
     public void useCurrentHashMap(Blackhole bh) {
         for (int c = 0; c < size; c++) {
             bh.consume(chm.intern("doit" + c));
         }
     }

     public static class HashMapInterner {
         private final Map<String, String> map;

         public HashMapInterner() {
             map = new HashMap<>();
         }

         public String intern(String s) {
             String exist = map.putIfAbsent(s, s);
             return (exist == null) ? s : exist;
         }
     }

     @Benchmark
     public void useHashMap(Blackhole bh) {
         for (int c = 0; c < size; c++) {
             bh.consume(hm.intern("doit" + c));
         }
     }

     public static void main(String[] args) throws RunnerException {
         Options opt = new OptionsBuilder().include(StringInternBenchMark.class.getSimpleName()).build();
         new Runner(opt).run();
     }
 }
