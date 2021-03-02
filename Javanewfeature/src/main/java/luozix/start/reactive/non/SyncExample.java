    /** 
	 * Project Name:java11_in_action 
	 * File Name:SyncExample.java 
	 * Package Name:luozix.start.reactive.non 
	 * Date:2021年3月1日下午9:22:45 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: SyncExample.java
* @Package luozix.start.reactive.non
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月1日 下午9:22:45
* @version V1.0  
*/  
	  
	package luozix.start.reactive.non;

	import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

	/** 
		 * ClassName:SyncExample <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年3月1日 下午9:22:45 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: SyncExample
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月1日 下午9:22:45
* @version  
*@since JDK 1.8
*/
public class SyncExample {

	public static void doSomethingA() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("--- doSomethingA---");
	}

	public static void doSomethingB() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("--- doSomethingB---");

	}

//	public static void main(String[] args) {
//
//		long start = System.currentTimeMillis();
//		// 1.执行任务A
//		doSomethingA();
//
//		// 2.执行任务B
//		doSomethingB();
//
//		System.out.println(System.currentTimeMillis() - start + "ms");
//
//	}
	
//	public static void main(String[] args) throws InterruptedException {
//	        long start = System.currentTimeMillis();
//	        // 1.开启异步单元执行任务A
//	        Thread thread = new Thread(() -> {
//	            try {
//	                doSomethingA();
//
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        }, "threadA");
//	        thread.start();
//
//	        // 2.执行任务B
//	        doSomethingB();
//
//	        // 3.同步等待线程A运行结束
//	        thread.join();
//	        System.out.println(System.currentTimeMillis() - start);
//	    }
//	
//	// 0自定义线程池
//	private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
//	private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
//			AVALIABLE_PROCESSORS * 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5),
//			new ThreadPoolExecutor.CallerRunsPolicy());
//
//	public static void main(String[] args) throws InterruptedException, ExecutionException {
//
//		long start = System.currentTimeMillis();
//
//		// 1.开启异步单元执行任务A
//		POOL_EXECUTOR.execute(() -> {
//			try {
//				doSomethingA();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
//		// 2.执行任务B
//		doSomethingB();
//
//		// 3.同步等待线程A运行结束
//		System.out.println(System.currentTimeMillis() - start);
//
//		// 4.挂起当前线程
//		Thread.currentThread().join();
//	}

	// 0自定义线程池
	private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
	private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
			AVALIABLE_PROCESSORS * 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5),
			new ThreadPoolExecutor.CallerRunsPolicy());

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		long start = System.currentTimeMillis();

		// 1.开启异步单元执行任务A
		POOL_EXECUTOR.execute(() -> {
			try {
				doSomethingA();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// 2.执行任务B
		POOL_EXECUTOR.execute(() -> {
			try {
				doSomethingB();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// 3.同步等待线程A运行结束
		System.out.println(System.currentTimeMillis() - start);

		// 4.挂起当前线程
		Thread.currentThread().join();
	}

}
