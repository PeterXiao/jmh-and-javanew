package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class AverageSingleShot {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(AverageSingleShot.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

    @Fork(100)
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public int test() {
        return ThreadLocalRandom.current().nextInt() + ThreadLocalRandom.current().nextInt();
    }

}
