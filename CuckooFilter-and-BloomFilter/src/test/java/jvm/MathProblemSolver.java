 package jvm;

 /**
 * @author xiaoy
 * @date 2020/08/05
 */


 import java.math.BigInteger;

 public class MathProblemSolver {

     // 开启两个线程
     public static void main(String arg[]) {
         // 第一个线程计算 100!
         FactorialCalculatingThread thread1 = new FactorialCalculatingThread(100);
         // 第二个线程计算 100000!
         FactorialCalculatingThread thread2 = new FactorialCalculatingThread(100000);

         thread1.setName("Thread 1");
         thread2.setName("Thread 2");

         thread1.start();
         thread2.start();

         try {
             thread1.join(); // 线程Jion，以使主线程在“线程1”和“线程2”都返回结果之前不会进一步执行
             thread2.join();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         BigInteger result = thread1.getResult().add(thread2.getResult());
         System.out.println("将两个线程的计算结果相加等于：" + result);
     }

     // 用于阶乘计算的线程类
     private static class FactorialCalculatingThread extends Thread {
         private BigInteger result = BigInteger.ONE;
         private long num;

         public FactorialCalculatingThread(long num) {
             this.num = num;
         }

         @Override
         public void run() {
             System.out.println(Thread.currentThread().getName() + " 开始阶乘的计算：" + num);
             factorialCalc(num);
             System.out.println(Thread.currentThread().getName() + "执行完成");
         }

         // 数的阶乘计算方法
         public void factorialCalc(long num) {
             BigInteger f = new BigInteger("1");
             for (int i = 2; i <= num; i++)
                 f = f.multiply(BigInteger.valueOf(i));
             result = f;
         }

         public BigInteger getResult() {
             return result;
         }
     }
 }
