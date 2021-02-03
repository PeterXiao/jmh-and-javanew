/**
 * 
 */
package luozix.start.action.concurrent;

/**
 * @author xiaoy
 *
 */
public class VolatileInc implements Runnable {

	private static volatile int count = 0; // 使用 volatile 修饰基本数据内存不能保证原子性

	// private static AtomicInteger count = new AtomicInteger() ;

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			count++;
			// count.incrementAndGet() ;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileInc volatileInc = new VolatileInc();
		Thread t1 = new Thread(volatileInc, "t1");
		Thread t2 = new Thread(volatileInc, "t2");
		t1.start();
		// t1.join();

		t2.start();
		// t2.join();
		for (int i = 0; i < 10000; i++) {
			count++;
			// count.incrementAndGet();
		}

		System.out.println("最终Count=" + count);
	}
}

//private static Map<String,String> value ;
//private static volatile boolean flag = fasle ;
//
////以下方法发生在线程 A 中 初始化 Map
//public void initMap(){
//	//耗时操作
//	value = getMapValue() ;//1
//	flag = true ;//2
//}
//
//
////发生在线程 B中 等到 Map 初始化成功进行其他操作
//public void doSomeThing(){
//	while(!flag){
//		sleep() ;
//	}
//	//dosomething
//	doSomeThing(value);
//}