 package jvm;

 /**
 * @author xiaoy
 * @date 2020/07/22
 */
 public class StackOverflowErrorDemo {

     public static void main(String[] args) {
         javaKeeper();
     }

     private static void javaKeeper() {
         javaKeeper();
     }
 }


