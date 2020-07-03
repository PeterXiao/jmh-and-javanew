/**
 *
 */
/**
 * @author Office
 *
 */
package basics.concurrent;

/*
 * A concurrent program has multiple logical threads of control. These
 * threadsmay or may not run in parallel.A parallel program potentially runs
 * more quickly than a sequential programby executing different parts of the
 * computation simultaneously (in parallel).It may or may not have more than one
 * logical thread of control.Concurrency is about dealing with lots of things at
 * once.Parallelism is about doing lots of things at
 * once.摘自<<七周七并发模型>>并发是指同时有很多事要做，你可以串行处理也可以并行处理。并行是指同时做多件事。因此并发和并行是相关的，
 * 但是是不同的两个概念。
 *
 *
 *
 * public static void main(String[] args) throws InterruptedException {
 * CountDownLatch countDownLatch = new CountDownLatch(2); ExecutorService
 * executorService = Executors.newFixedThreadPool(2);
 *
 * executorService.submit(()->{ try { Thread.sleep(10);
 * System.out.println("child threadOne over"); } catch (InterruptedException e)
 * { e.printStackTrace(); }finally { countDownLatch.countDown(); }
 *
 * });
 *
 * executorService.submit(()-> { try { Thread.sleep(10);
 * System.out.println("child threadTwo over"); } catch (InterruptedException e)
 * { e.printStackTrace(); }finally {
 * countDownLatch.countDown();//原子操作，同时只能有一个线程操作计数器 }
 *
 * });
 *
 * Thread.sleep(1000); System.out.println("wait all child thread over");
 *
 * try { countDownLatch.await(2,
 * TimeUnit.SECONDS);//调用await()会一直阻塞，直到countDown计数器为0 （大门一直关闭，直到计数器为0打开），并发继续执行
 * System.out.println("all child thread over"); //调用await(2, TimeUnit.SECONDS)
 * ,超过这个时间，（大门打开）线程不阻塞，并发继续执行 } catch (InterruptedException e) {
 * e.printStackTrace(); } executorService.shutdown(); }
 *
 *
 *
 * 假设一个任务分三步，每一步让两个线程并发执行，下一步执行的条件是上一步必须执行完。
 */
/*
 * public class CyclicBarrierDemo2 { private static CyclicBarrier cyclicBarrier
 * = new CyclicBarrier(2);
 *
 * public static void main(String[] args) { ExecutorService executorService =
 * Executors.newFixedThreadPool(2);
 *
 * executorService.execute(() -> { try {
 * System.out.println(Thread.currentThread() + "step1"); cyclicBarrier.await();
 *
 * System.out.println(Thread.currentThread() + "step2"); cyclicBarrier.await();
 *
 * System.out.println(Thread.currentThread() + "step3"); }catch (Exception e) {
 *
 * } });
 *
 * executorService.execute(() -> { try {
 * System.out.println(Thread.currentThread() + "step1"); cyclicBarrier.await();
 *
 * System.out.println(Thread.currentThread() + "step2"); cyclicBarrier.await();
 *
 * System.out.println(Thread.currentThread() + "step3"); }catch (Exception e) {
 *
 * } });
 *
 * executorService.shutdown(); } }
 *
 *
 * 同时只能有10个线程保存数据
 *
 * public class SemaphoreDemo3 { private static final int THREAD_COUNT = 30;
 * private static ExecutorService threadPool =
 * Executors.newFixedThreadPool(THREAD_COUNT); private static Semaphore s = new
 * Semaphore(10);
 * 
 * public static void main(String[] args) {
 * 
 * for (int i = 0; i < THREAD_COUNT; i++) {
 * 
 * threadPool.execute(() -> { try { s.acquire();
 * System.out.println("save data"); s.release(); } catch (InterruptedException
 * e) {
 * 
 * } }); } threadPool.shutdown();
 * 
 * } }
 */
