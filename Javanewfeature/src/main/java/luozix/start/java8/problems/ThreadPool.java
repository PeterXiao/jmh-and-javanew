    /** 
	 * Project Name:java11_in_action 
	 * File Name:ThreadPool.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午6:23:49 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ThreadPool.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:23:49
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;

	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;

	/** 
		 * ClassName:ThreadPool <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午6:23:49 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: ThreadPool
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:23:49
* @version  
*@since JDK 1.8
*/
public class ThreadPool {

	/**
	 * <p>
	 * Creates pool of threads. Where the pool is the size of the number of
	 * processors available to the Java virtual machine.
	 * </p>
	 * 
	 * @return the newly created thread pool
	 */
	public static ExecutorService createFixedThreadPool() {
		return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
}
