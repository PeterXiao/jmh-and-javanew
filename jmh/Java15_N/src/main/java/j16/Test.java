package j16;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashSet;

public class Test {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Test.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    public void init() {
        HashSet<String> s = new HashSet<>();
        for (int i = 0; i < 1000000; i++) {
            s.add(Math.random() + "");
        }
        s.size();
    }
}
