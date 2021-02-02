package jmh;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@State(Scope.Benchmark)
@Fork(value = 2)
@Warmup(iterations = 2, time = 3)
@Measurement(iterations = 2, time = 3)
public class ArrayJmhTest {

    public List<Object> list;

    @Setup
    public void setup() {
        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) list.add(i);
    }

    @Benchmark
    public void collectionForEach(Blackhole hole) {
        list.forEach(hole::consume);
    }

    @Benchmark
    public void iteratorFor(Blackhole hole) {
        for (Iterator<Object> iterator = list.iterator(); iterator.hasNext(); ) {
            hole.consume(iterator.next());
        }
    }

    @Benchmark
    public void enhancedFor(Blackhole hole) {
        for (Object e : list) {
            hole.consume(e);
        }
    }

    @Benchmark
    public void iteratorForEach(Blackhole hole) {
        list.iterator().forEachRemaining(hole::consume);
    }

    @Benchmark
    public void indexedFor(Blackhole hole) {
        for (int i = 0, size = list.size(); i < size; i++) {
            hole.consume(list.get(i));
        }
    }

    @Benchmark
    public void streamForEach(Blackhole hole) {
        list.stream().forEach(hole::consume);
    }

    @Benchmark
    public void spliteratorForEach(Blackhole hole) {
        list.spliterator().forEachRemaining(hole::consume);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ArrayJmhTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
