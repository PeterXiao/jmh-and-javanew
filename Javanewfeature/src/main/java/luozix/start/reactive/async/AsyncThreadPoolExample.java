    /** 
	 * Project Name:java11_in_action 
	 * File Name:AsyncThreadPoolExample.java 
	 * Package Name:luozix.start.reactive.async 
	 * Date:2021年3月2日上午9:40:50 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: AsyncThreadPoolExample.java
* @Package luozix.start.reactive.async
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 上午9:40:50
* @version V1.0  
*/  
	  
	package luozix.start.reactive.async;

	/** 
		 * ClassName:AsyncThreadPoolExample <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年3月2日 上午9:40:50 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: AsyncThreadPoolExample
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月2日 上午9:40:50
* @version  
*@since JDK 1.8
*/
public class AsyncThreadPoolExample {

//	    public static String doSomethingA() {
//
//	        try {
//	            Thread.sleep(2000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//	        System.out.println("--- doSomethingA---");
//	        return "A Task Done";
//	    }
//
//	    // 0自定义线程池
//	    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
//	    private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
//	            AVALIABLE_PROCESSORS * 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5),
//	            new NamedThreadFactory("ASYNC-POOL"), new ThreadPoolExecutor.CallerRunsPolicy());
//
//	    public static void main(String[] args) throws InterruptedException, ExecutionException {
//
//	        // 1.开启异步单元执行任务A
//	        Future<?> resultA = POOL_EXECUTOR.submit(() -> doSomethingA());
//
//	        // 2.同步等待执行结果
//	        System.out.println(resultA.get());
//	    }
}
