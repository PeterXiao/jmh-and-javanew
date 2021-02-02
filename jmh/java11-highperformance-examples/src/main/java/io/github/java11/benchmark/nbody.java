 package io.github.java11.benchmark;

 /*
  * The Computer Language Benchmarks Game https://salsa.debian.org/benchmarksgame-team/benchmarksgame/
  * 
  * contributed by Mark C. Lewis modified slightly by Chad Whipkey modified slightly by Stefan Feldbinder modified
  * slightly by Tagir Valeev
  */

 public final class nbody {
     public static void main(String[] args) {
         int n = Integer.parseInt(args[0]);

         NBodySystem bodies = new NBodySystem();
         System.out.printf("%.9f\n", bodies.energy());
         for (int i = 0; i < n; ++i)
             bodies.advance(0.01);
         System.out.printf("%.9f\n", bodies.energy());
     }
}
