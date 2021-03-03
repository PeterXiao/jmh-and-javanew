/**
 * Project Name:java11_in_action File Name:Concurrent.java Package Name:luozix.start.javabefore7.j5
 * Date:2021年3月3日上午10:25:06 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Concurrent.java @Package luozix.start.javabefore7.j5 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:25:06
 * @version V1.0
 */
package luozix.start.javabefore7.j5;
/**
 * ClassName:Concurrent <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:25:06 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @ClassName: Concurrent @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:25:06
 * @version
 * @since JDK 1.8
 */
public class Concurrent {
  public void lock() {
    Lock lock = new ReentrantLock();
    lock.lock();
    try {
      System.out.println("hello world");
    } finally {
      lock.unlock();
    }
  }

  public void condition() throws InterruptedException {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    // do something
    condition.await(10, TimeUnit.SECONDS);
    System.out.println("Get result.");
  }

  public void executorService() {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    executorService.submit(
        new Runnable() {
          @Override
          public void run() {
            System.out.println("Task is running.");
          }
        });
  }

  public void blockingDeque() {
    Queue<Integer> blockingDeque = new ArrayBlockingQueue<>(20);
    blockingDeque.add(1);
    blockingDeque.add(2);
    blockingDeque.add(3);

    blockingDeque.peek();
  }

  public void concurrentHashMap() {
    Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    concurrentHashMap.put("Hello", 1);
    concurrentHashMap.put("World", 2);

    System.out.println(concurrentHashMap.get("Hello"));
  }

  public void copyOnWriteList() {
    List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
    copyOnWriteList.add("a");
    copyOnWriteList.add("b");
    copyOnWriteList.add("c");

    System.out.println(copyOnWriteList.size());
  }

  public void semaphore() {
    Semaphore semaphore = new Semaphore(3);
    try {
      semaphore.acquire();
      System.out.println(Thread.currentThread().getName() + " is working");
      Thread.sleep(1000);
      semaphore.release();
      System.out.println(Thread.currentThread().getName() + " is over");
    } catch (InterruptedException e) {
    }
  }
}
