package jvm;

import java.util.HashSet;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


@Measurement(iterations = 5)
// @State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 1)
public class B001_HashSet {


	@Benchmark
    public void init() {
        HashSet<String> s = new HashSet<>();
        for (int i = 0; i < 10_000; i++) { // 1000,000
            s.add(Math.random() + "");
        }
        s.size();
	}

	public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(B001_HashSet.class.getSimpleName()).build();

		new Runner(opt).run();
	}
}
