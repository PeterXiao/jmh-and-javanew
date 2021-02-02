package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Fork(5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class StackOverflowQ {

    List<Integer> intList;

    int size = 100;

    @Setup
    public void setup() {
        intList = new ArrayList<>(size);
        for(int i = 0; i<size;i++){
            intList.add(i);
        }
    }

    /**
     Work done to each item in the loop.
     */
    public double doWork(int item) {
        return item + 47;
    }

    @Benchmark
    public void standardFor(Blackhole bh){
        for (int i = 0; i<intList.size(); i++){
            bh.consume(doWork(intList.get(i)));
        }
    }

    @Benchmark
    public void streamForEach(Blackhole bh){
        intList.stream().forEach(i -> bh.consume(doWork(i)));
    }

}
