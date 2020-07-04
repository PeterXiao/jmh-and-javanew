package me.josephzhu.javaconcurrenttest.concurrent.queues;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Producer extends Worker {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public Producer(String name, BlockingQueue<Integer> queue) {
        super(name, queue);
    }

    @Override
    public void run() {
        while (enable) {
            try {
                int value = atomicInteger.incrementAndGet();
                queue.put(value);
                log.info("size:{}, put:{}, enable:{}", queue.size(), value, enable);
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        log.info("{} quit", name);
    }
}
