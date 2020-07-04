package me.josephzhu.javaconcurrenttest.concurrent.concurrentcollections;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class CopyOnWriteArrayListTest {

    @Test
    public void testWrite() {
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        StopWatch stopWatch = new StopWatch();
        int loopCount = 100000;
        stopWatch.start("copyOnWriteArrayList");
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> copyOnWriteArrayList.add(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        stopWatch.start("arrayList");
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> {
            synchronized (arrayList) {
                arrayList.add(ThreadLocalRandom.current().nextInt(loopCount));
            }
        });
        stopWatch.stop();
        stopWatch.start("synchronizedList");
        IntStream.range(0, loopCount).parallel().forEach(__ -> synchronizedList.add(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }

    private void addAll(List<Integer> list) {
        list.addAll(IntStream.rangeClosed(1, 10000000).boxed().collect(Collectors.toList()));
    }

    @Test
    public void testRead() {
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        addAll(copyOnWriteArrayList);
        addAll(arrayList);
        addAll(synchronizedList);
        StopWatch stopWatch = new StopWatch();
        int loopCount = 100000000;
        int count = arrayList.size();
        stopWatch.start("copyOnWriteArrayList");
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> copyOnWriteArrayList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();
        stopWatch.start("arrayList");
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> {
            synchronized (arrayList) {
                arrayList.get(ThreadLocalRandom.current().nextInt(count));
            }
        });
        stopWatch.stop();
        stopWatch.start("synchronizedList");
        IntStream.range(0, loopCount).parallel().forEach(__ -> synchronizedList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }
}
