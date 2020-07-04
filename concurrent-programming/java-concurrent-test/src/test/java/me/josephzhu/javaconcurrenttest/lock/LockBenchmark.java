package me.josephzhu.javaconcurrenttest.lock;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

@Slf4j
public class LockBenchmark {

    final static int LOOP_COUNT = 1000000;

    @Test
    public void test() throws Exception {
        List<TestCase> testCases = new ArrayList<>();

        Arrays.asList(SyncTask.class,
                ReentrantLockTask.class,
                FairReentrantLockTask.class,
                ReentrantReadWriteLockTask.class,
                FairReentrantReadWriteLockTask.class,
                StampedLockTask.class
        ).forEach(syncTaskClass -> {
            testCases.add(new TestCase(syncTaskClass, 1, 0));
            testCases.add(new TestCase(syncTaskClass, 10, 0));
            testCases.add(new TestCase(syncTaskClass, 0, 1));
            testCases.add(new TestCase(syncTaskClass, 0, 10));

            testCases.add(new TestCase(syncTaskClass, 1, 1));
            testCases.add(new TestCase(syncTaskClass, 10, 10));
            testCases.add(new TestCase(syncTaskClass, 50, 50));
            testCases.add(new TestCase(syncTaskClass, 100, 100));
            testCases.add(new TestCase(syncTaskClass, 500, 500));
            testCases.add(new TestCase(syncTaskClass, 1000, 1000));

            testCases.add(new TestCase(syncTaskClass, 1, 10));
            testCases.add(new TestCase(syncTaskClass, 10, 100));
            testCases.add(new TestCase(syncTaskClass, 10, 200));
            testCases.add(new TestCase(syncTaskClass, 10, 500));
            testCases.add(new TestCase(syncTaskClass, 10, 1000));

            testCases.add(new TestCase(syncTaskClass, 10, 1));
            testCases.add(new TestCase(syncTaskClass, 100, 10));
            testCases.add(new TestCase(syncTaskClass, 200, 10));
            testCases.add(new TestCase(syncTaskClass, 500, 10));
            testCases.add(new TestCase(syncTaskClass, 1000, 10));

        });

        testCases.forEach(testCase -> {
            System.gc();
            try {
                benchmark(testCase);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (TestCase testCase : testCases) {
            if (index % 20 == 0)
                stringBuilder.append("\r\n");
            stringBuilder.append(testCase.duration);
            stringBuilder.append(",");
            index++;
        }
        System.out.println(stringBuilder.toString());
    }


    private void benchmark(TestCase testCase) throws Exception {
        LockTask.counter = 0;
        log.info("Start benchmark:{}", testCase);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(testCase.readerThreadCount + testCase.writerThreadCount);
        if (testCase.readerThreadCount > 0) {
            LockTask readerTask = (LockTask) testCase.lockTaskClass.getDeclaredConstructor(Boolean.class).newInstance(false);
            readerTask.start = start;
            readerTask.finish = finish;
            readerTask.loopCount = LOOP_COUNT / testCase.readerThreadCount;
            IntStream.rangeClosed(1, testCase.readerThreadCount)
                    .mapToObj(__ -> new Thread(readerTask))
                    .forEach(Thread::start);
        }
        if (testCase.writerThreadCount > 0) {
            LockTask writerTask = (LockTask) testCase.lockTaskClass.getDeclaredConstructor(Boolean.class).newInstance(true);
            writerTask.start = start;
            writerTask.finish = finish;
            writerTask.loopCount = LOOP_COUNT / testCase.writerThreadCount;
            IntStream.rangeClosed(1, testCase.writerThreadCount)
                    .mapToObj(__ -> new Thread(writerTask))
                    .forEach(Thread::start);
        }

        start.countDown();
        long begin = System.currentTimeMillis();
        finish.await();
        if (testCase.writerThreadCount > 0)
            Assert.assertEquals(LOOP_COUNT, LockTask.counter);
        testCase.duration = System.currentTimeMillis() - begin;
        log.info("Finish benchmark:{}", testCase);

    }
}

@Slf4j
abstract class LockTask implements Runnable {
    protected static volatile long counter;
    protected boolean write;
    int loopCount;
    CountDownLatch start;
    CountDownLatch finish;

    public LockTask(Boolean write) {
        this.write = write;
    }

    @Override
    public void run() {
        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < loopCount; i++) {
            doTask();
        }
        finish.countDown();
    }

    abstract protected void doTask();
}

@Slf4j
class SyncTask extends LockTask {
    private static Object locker = new Object();

    public SyncTask(Boolean write) {
        super(write);
    }

    @Override
    protected void doTask() {
        synchronized (locker) {
            if (write) {
                counter++;
            } else {
                long value = counter + 1;
                //log.debug("{}, {}", this.getClass().getSimpleName(), value);
            }
        }
    }
}

@Slf4j
class ReentrantLockTask extends LockTask {
    private static ReentrantLock locker = new ReentrantLock();

    public ReentrantLockTask(Boolean write) {
        super(write);
    }

    @Override
    protected void doTask() {
        locker.lock();
        try {
            if (write) {
                counter++;
            } else {
                long value = counter + 1;
                //log.debug("{}, {}", this.getClass().getSimpleName(), value);
            }
        } finally {
            locker.unlock();
        }
    }
}

@Slf4j
class FairReentrantLockTask extends LockTask {
    private static ReentrantLock locker = new ReentrantLock(true);

    public FairReentrantLockTask(Boolean write) {
        super(write);
    }

    @Override
    protected void doTask() {
        locker.lock();

        try {

            if (write) {
                counter++;
            } else {
                long value = counter + 1;
                //log.debug("{}, {}", this.getClass().getSimpleName(), value);
            }
        } finally {
            locker.unlock();
        }
    }
}

@Slf4j
class ReentrantReadWriteLockTask extends LockTask {
    private static ReentrantReadWriteLock locker = new ReentrantReadWriteLock();

    public ReentrantReadWriteLockTask(Boolean write) {
        super(write);
    }

    @Override
    protected void doTask() {
        locker.writeLock().lock();

        if (write) {
            try {

                counter++;
            } finally {
                locker.writeLock().unlock();
            }
        } else {
            locker.readLock().lock();

            try {
                long value = counter + 1;
                //log.debug("{}, {}", this.getClass().getSimpleName(), value);
            } finally {
                locker.readLock().unlock();
            }
        }
    }
}

@Slf4j
class FairReentrantReadWriteLockTask extends LockTask {
    private static ReentrantReadWriteLock locker = new ReentrantReadWriteLock(true);

    public FairReentrantReadWriteLockTask(Boolean write) {
        super(write);
    }

    @Override
    protected void doTask() {
        if (write) {
            locker.writeLock().lock();
            try {
                counter++;
            } finally {
                locker.writeLock().unlock();
            }
        } else {
            locker.readLock().lock();
            try {
                long value = counter + 1;
                //log.debug("{}, {}", this.getClass().getSimpleName(), value);
            } finally {
                locker.readLock().unlock();
            }
        }
    }
}

@Slf4j
class StampedLockTask extends LockTask {
    private static StampedLock locker = new StampedLock();

    public StampedLockTask(Boolean write) {
        super(write);
    }

    @Override
    protected void doTask() {
        if (write) {
            long stamp = locker.writeLock();
            counter++;
            locker.unlockWrite(stamp);
        } else {
            long stamp = locker.tryOptimisticRead();
            long value = counter + 1;

            if (!locker.validate(stamp)) {
                stamp = locker.readLock();
                try {
                    value = counter + 1;
                } finally {
                    locker.unlockRead(stamp);
                }
            }
            //log.debug("{}, {}", this.getClass().getSimpleName(), value);
        }
    }
}

@ToString
@RequiredArgsConstructor
class TestCase {
    final Class lockTaskClass;
    final int writerThreadCount;
    final int readerThreadCount;
    long duration;
}
