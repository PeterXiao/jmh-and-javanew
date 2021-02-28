    /** 
	 * Project Name:java11_in_action 
	 * File Name:PerformLotteryTest.java 
	 * Package Name:luozix.start.java8.problems.math 
	 * Date:2021年2月28日下午8:34:52 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: PerformLotteryTest.java
* @Package luozix.start.java8.problems.math
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:34:52
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.math;  
	/** 
	 * ClassName:PerformLotteryTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:34:52 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
/**
* @ClassName: PerformLotteryTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:34:52
* @version  
*@since JDK 1.8
*/
class PerformLotteryTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.math.PerformLottery#performLottery(int, int)}.
	 */
	@Test
	void testPerformLottery() {
		var numbers0 = PerformLottery.performLottery(0, 0);
		assertArrayEquals(new Integer[] {}, numbers0);
		var numbers1 = PerformLottery.performLottery(1, 1);
		assertArrayEquals(new Integer[] { 1 }, numbers1);
		var numbers2 = PerformLottery.performLottery(2, 2);
		assertEquals(2, numbers2.length);
		assertTrue(numbers2[0] == 1 || numbers2[0] == 2);
		assertTrue(numbers2[1] == 1 || numbers2[1] == 2);
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.math.PerformLottery#isPrime(int)}.
	 */
	@Test
	void testIsPrime() {
		assertTrue(PerformLottery.isPrime(2));
		assertTrue(PerformLottery.isPrime(3));
		assertTrue(PerformLottery.isPrime(17));
		assertTrue(PerformLottery.isPrime(97));
		assertFalse(PerformLottery.isPrime(4));
		assertFalse(PerformLottery.isPrime(100));
	}

}
