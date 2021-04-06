 package jvm;

 /**
 * @author xiaoy
 * @date 2020/08/05
 */

 import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

 public class Streamer {
     private static final int LOOP_COUNT = 20; //2000

     public static void main(String[] args) {
         try {
             for (int i = 0; i < LOOP_COUNT; ++i) {
                 poolRunner();
                 System.out.println("done loop " + i);
                 try {
                     Thread.sleep(50L);
                 } catch (Exception e) {
                     System.out.println(e);
                 }
             }
         } catch (ExecutionException | InterruptedException e) {
             System.out.println(e);
         }

         // Add a delay outside the loop to make sure all daemon threads are cleared before main exits.
         try {
             Thread.sleep(10 * 60 * 1000L);
         } catch (Exception e) {
             System.out.println(e);
         }
     }

     /**
      * poolRunner method. Assume I don't have any control over this method e.g. done by some library.
      * 
      * @throws InterruptedException
      * @throws ExecutionException
      */
     private static void poolRunner() throws InterruptedException, ExecutionException {
         ForkJoinPool pool = new ForkJoinPool();
         pool.submit(() -> {
             List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16);
             List<Integer> collect = numbers.stream().parallel().filter(xx -> xx > 5).collect(Collectors.toList());
             // System.out.println(collect);
         }).get();
     }
 }
