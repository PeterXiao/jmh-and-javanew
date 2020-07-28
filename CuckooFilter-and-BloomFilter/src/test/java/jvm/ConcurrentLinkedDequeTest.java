 package jvm;

 /**
 * @author xiaoy
 * @date 2020/07/16
 */
 import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

 public class ConcurrentLinkedDequeTest {
     public static void main(String[] args) throws InterruptedException {
         ThreadLocalRandom rnd = ThreadLocalRandom.current();
         LongAdder nulls = new LongAdder(), zeros = new LongAdder();
         for (;;) {
             ConcurrentLinkedDeque<Integer> d = new ConcurrentLinkedDeque<>();

             Runnable poller = () -> {
                 Integer x = d.pollFirst();
                 if (x == null)
                     nulls.increment();
                 else if (x == 0)
                     zeros.increment();
                 else
                     throw new AssertionError(
                         String.format("unexpected value %d after %d nulls and %d zeros", x, nulls.sum(), zeros.sum()));
             };

             Runnable adder = () -> {
                 d.addFirst(0);
                 d.addLast(42);
             };

             boolean b = rnd.nextBoolean();
             Runnable r1 = b ? poller : adder;
             Runnable r2 = b ? adder : poller;
             CompletableFuture<Void> f1 = CompletableFuture.runAsync(r1);
             CompletableFuture<Void> f2 = CompletableFuture.runAsync(r2);
             f1.join();
             f2.join();
         }
     }
 }
