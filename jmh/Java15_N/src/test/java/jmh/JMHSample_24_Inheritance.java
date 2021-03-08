package jmh;


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

import java.util.concurrent.TimeUnit;

public class JMHSample_24_Inheritance {

    /*
     * In very special circumstances, you might want to provide the benchmark
     * body in the (abstract) superclass, and specialize it with the concrete
     * pieces in the subclasses.
     *
     * The rule of thumb is: if some class has @Benchmark method, then all the subclasses
     * are also having the "synthetic" @Benchmark method. The caveat is, because we only
     * know the type hierarchy during the compilation, it is only possible during
     * the same compilation session. That is, mixing in the subclass extending your
     * benchmark class *after* the JMH compilation would have no effect.
     *
     * Note how annotations now have two possible places. The closest annotation
     * in the hierarchy wins.
     */

    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @State(Scope.Thread)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static abstract class AbstractBenchmark {
        int x;

        @Setup
        public void setup() {
            x = 42;
        }

        @Benchmark
        @Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
        @Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
        public double bench() {
            return doWork() * doWork();
        }

        protected abstract double doWork();
    }

    public static class BenchmarkLog extends AbstractBenchmark {
        @Override
        protected double doWork() {
            return Math.log(x);
        }
    }

    public static class BenchmarkSin extends AbstractBenchmark {
        @Override
        protected double doWork() {
            return Math.sin(x);
        }
    }

    public static class BenchmarkCos extends AbstractBenchmark {
        @Override
        protected double doWork() {
            return Math.cos(x);
        }
    }

    /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     * You can run this test, and observe the three distinct benchmarks running the squares
     * of Math.log, Math.sin, and Math.cos, accordingly.
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar JMHSample_24
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_24_Inheritance.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

}
