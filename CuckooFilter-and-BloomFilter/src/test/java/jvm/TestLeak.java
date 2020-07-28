 package jvm;

 import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

 /**
  * @author xiaoy
  * @date 2020/07/15
  */
 /* import org.eclipse.jetty.util.ConcurrentHashSet;
 
  public class TestLeak 
  {
      public static void main(String[] args) 
      {
          ConcurrentHashSet<Object> queue=new ConcurrentHashSet<Object>();
          queue.add(new Object()); //Required for the leak to appear.
          Object object=new Object();
          int loops=0;
          Runtime rt=Runtime.getRuntime();
          long last=System.currentTimeMillis();
          while(true)
          {
              if(loops%10000==0)
              {
                  long now=System.currentTimeMillis();
                  long duration=now-last;
                  last=now;
                  System.err.printf("duration=%d q.size=%d memory max=%d free=%d total=%d%n",duration,queue.size(),rt.maxMemory(),rt.freeMemory(),rt.totalMemory());                            
              }
              queue.add(object);
              queue.remove(object);
              ++loops;
          }
      }
  }*/

 public class TestLeak {
    // TODO Auto-generated constructor stub
    public static void main(String[] args) throws InterruptedException {
     
        TimeUnit.SECONDS.sleep(10);
        ConcurrentLinkedDeque<Object> queueConcurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        queueConcurrentLinkedDeque.add(new Object());
        Object object = new Object();
        int loop = 0;
        Runtime rtRuntime = Runtime.getRuntime();
        long last = System.currentTimeMillis();
        while (true) {
            if (loop % 1000 == 0) {
                long now = System.currentTimeMillis();
                long duration = now - last;
                last = now;
                System.err.printf("duration=%d, q.size=%d, memory max =%d , free= %d, total=%d%n", duration,
                    queueConcurrentLinkedDeque.size(), rtRuntime.maxMemory(), rtRuntime.freeMemory(),
                    rtRuntime.totalMemory());

            }

            queueConcurrentLinkedDeque.add(object);
            queueConcurrentLinkedDeque.remove(object);
            ++loop;

        }
    }
}