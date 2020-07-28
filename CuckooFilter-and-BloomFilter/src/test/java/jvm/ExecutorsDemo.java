 package jvm;

 import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

 /**
  * @author xiaoy
  * @date 2020/07/16
  */
 public class ExecutorsDemo {
     private static ExecutorService executor = Executors.newFixedThreadPool(100); // 15

     private static ExecutorService executor_pool = new ThreadPoolExecutor(
         // 5条核心线程
         5,
         // max 30,机器资源有限,不要太奔放,容易嗝屁
         30, // 30
         // 30秒空闲回收
         30, TimeUnit.SECONDS,
         // 1000的队列
         new LinkedBlockingDeque<>(5), // EXECUTOR_COUNTER EXECUTOR_COUNTER.getAndIncrement() + System.nanoTime() 2000
         r -> new Thread(r, "ApplicationThreadPool-" + Thread.currentThread().getName() + System.nanoTime()));

     public static void main(String[] args) {

         // for (int i = 0; i < Integer.MAX_VALUE; i++) {
         // executor.execute(new SubThread());
         // executor.submit(() -> System.out.println(Thread.currentThread().getName() + " " +System.nanoTime()));
         // }

         // for (int i = 0; i < Integer.MAX_VALUE; i++) {
         // // executor_pool.execute(new SubThread());
         // executor_pool.submit(() -> System.out.println(Thread.currentThread().getName()));
         // }

           for (int i = 0; i < Integer.MAX_VALUE; i++) {
               executor_pool.execute(new SubThread());
               executor_pool.submit(() -> System.out.println(Thread.currentThread().getName()));
              }
         /*         for (int i = 0; i < 15; i++) {
              executor.submit(() -> System.out.println(Thread.currentThread().getName() + " " +System.nanoTime()));
          }*/
         // -Xmx8m -Xms8m
     }

     /*     public static void push2Kafka(Object msg) {
          executor.execute(new WriteTask(msg,  false));    
      }*/
 }

 // private static ExecutorService executor2 = Executors.newFixedThreadPool(15);

 class SubThread implements Runnable {
     @Override
     public void run() {
         try {

             Thread.sleep(30); // 100
         } catch (InterruptedException e) {
             // do nothing
         }
     }
 }