package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertEquals;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import io.github.ljwlgl.util.BigDecimalUtil;

@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 1)
@State(Scope.Thread)
public class BigDecimalUtilTest {
    private int v;
    private int mask = 0x238751;

    @Benchmark
    public void testSubtract() {
        assertEquals(1.72, BigDecimalUtil.subtract(5.65, 3.93), 0.01);
    }

    @Benchmark
    public void testSubtractUp() {
        assertEquals(2, BigDecimalUtil.subtractUp(5.65, 3.93), 1);
    }

    @Benchmark
    public void testSubtractDown() {
        assertEquals(1, BigDecimalUtil.subtractDown(5.65, 3.93), 1);
    }

    @Benchmark
    public void testAdd() {
        assertEquals(20.8, BigDecimalUtil.add(19.9, 0.9), 0.0001);
    }

    @Benchmark
    public void testMultiply() {
        assertEquals(13.68, BigDecimalUtil.multiply(4.5, 3.04), 0.0001);
    }

    @Benchmark
    public void testDivide() {
        assertEquals(3.04, BigDecimalUtil.divide(13.68, 4.5, 0), 0.0001);
    }

    @Benchmark
    public void testRoundUp() {
        assertEquals(7, BigDecimalUtil.roundUp(6.3), 1);
    }

    @Benchmark
    public void testRoundUp1() {
        assertEquals(1.33, BigDecimalUtil.roundUp(1.324, 2), 0.01);
    }

    @Benchmark
    public void testRoundDown() {
        assertEquals(1, BigDecimalUtil.roundDown(1.6), 1);
    }

    @Benchmark
    public void testRoundDown1() {
        assertEquals(1.74, BigDecimalUtil.roundDown(1.746, 2), 0.01);
    }

    @Benchmark
    public void testRoundHalfUp() {
        assertEquals(2, BigDecimalUtil.roundHalfUp(1.746), 1);
    }

    @Benchmark
    public void testRoundHalfUp1() {
        assertEquals(1.75, BigDecimalUtil.roundHalfUp(1.746, 2), 0.01);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(BigDecimalUtilTest.class.getSimpleName()).build();

        new Runner(opt).run();
    }
}
