    /** 
	 * Project Name:java11_in_action 
	 * File Name:ThreadPoolTest.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午7:45:21 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ThreadPoolTest.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:45:21
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;  
	/** 
	 * ClassName:ThreadPoolTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午7:45:21 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.ThreadPoolExecutor;

import org.junit.jupiter.api.Test;

/**
* @ClassName: ThreadPoolTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:45:21
* @version  
*@since JDK 1.8
*/
class ThreadPoolTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	/**
	 * Tests for {@link ThreadPool#createFixedThreadPool()}.
	 */
	@Test
	public void testCreateFixedThreadPool() {
		var numProcessors = Runtime.getRuntime().availableProcessors();
		var executorService = (ThreadPoolExecutor) ThreadPool.createFixedThreadPool();
		assertEquals(numProcessors, executorService.getCorePoolSize());
		assertNotEquals(0, executorService.getCorePoolSize());
	}
}
