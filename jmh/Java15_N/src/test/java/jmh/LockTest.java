package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static Object lock = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static long cnt = 0;

    @Benchmark
    @Measurement(iterations = 2)
    @Threads(10)
    @Fork(0)
    @Warmup(iterations = 5, time = 10)
    public void testWithoutLock() {
        doSomething();
    }

    @Benchmark
    @Measurement(iterations = 2)
    @Threads(10)
    @Fork(0)
    @Warmup(iterations = 5, time = 10)
    public void testReentrantLock() {
        reentrantLock.lock();
        doSomething();
        reentrantLock.unlock();
    }

    @Benchmark
    @Measurement(iterations = 2)
    @Threads(10)
    @Fork(0)
    @Warmup(iterations = 5, time = 10)
    public void testSynchronized() {
        synchronized (lock) {
            doSomething();
        }
    }

    private void doSomething() {
        cnt += 1;
        if (cnt >= (Long.MAX_VALUE >> 1)) {
            cnt = 0;
        }
    }

    public static void main(String[] args) {
        Options options = new OptionsBuilder().include(LockTest.class.getSimpleName()).build();
        try {
            new Runner(options).run();
        } catch (Exception e) {

        } finally {
        }
    }
}
