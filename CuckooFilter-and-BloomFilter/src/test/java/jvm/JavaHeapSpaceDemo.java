 package jvm;

 /**
 * @author xiaoy
 * @date 2020/07/22
 */
 /**
  * JVM参数：-Xmx12m
  */
 public class JavaHeapSpaceDemo {

     static final int SIZE = 2 * 1024 * 1024;

     public static void main(String[] a) {
         int[] i = new int[SIZE];
     }
 }

