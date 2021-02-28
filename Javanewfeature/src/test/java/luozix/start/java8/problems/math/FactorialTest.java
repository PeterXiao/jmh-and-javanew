    /** 
	 * Project Name:java11_in_action 
	 * File Name:FactorialTest.java 
	 * Package Name:luozix.start.java8.problems.math 
	 * Date:2021年2月28日下午8:34:38 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: FactorialTest.java
* @Package luozix.start.java8.problems.math
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:34:38
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.math;  
	import static org.junit.jupiter.api.Assertions.assertEquals;

/** 
	 * ClassName:FactorialTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:34:38 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */
	import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* @ClassName: FactorialTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:34:38
* @version  
*@since JDK 1.8
*/
class FactorialTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.math.Factorial#factorial(int)}.
	 */
	@Test
	void testFactorial() {
		assertEquals(1, Factorial.factorial(0));
		assertEquals(1, Factorial.factorial(1));
		assertEquals(2, Factorial.factorial(2));
		assertEquals(6, Factorial.factorial(3));
		assertEquals(24, Factorial.factorial(4));
		assertEquals(120, Factorial.factorial(5));
		assertEquals(720, Factorial.factorial(6));
		assertEquals(5040, Factorial.factorial(7));
		assertEquals(40320, Factorial.factorial(8));
		assertEquals(362880, Factorial.factorial(9));
		assertEquals(3628800, Factorial.factorial(10));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.math.Factorial#fibonacci(int)}.
	 */
	@Test
	void testFibonacci() {
		assertEquals(0, Factorial.fibonacci(0));
		assertEquals(1, Factorial.fibonacci(1));
		assertEquals(1, Factorial.fibonacci(2));
		assertEquals(2, Factorial.fibonacci(3));
		assertEquals(3, Factorial.fibonacci(4));
		assertEquals(5, Factorial.fibonacci(5));
		assertEquals(8, Factorial.fibonacci(6));
		assertEquals(13, Factorial.fibonacci(7));
		assertEquals(21, Factorial.fibonacci(8));
		assertEquals(34, Factorial.fibonacci(9));
		assertEquals(55, Factorial.fibonacci(10));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.math.Factorial#gcd(int, int)}.
	 */
	@Test
	void testGcd() {
		assertEquals(2, Factorial.gcd(2, 4));
		assertEquals(1, Factorial.gcd(2, 5));
		assertEquals(6, Factorial.gcd(18, 24));
		assertEquals(7, Factorial.gcd(7, 7));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.math.Factorial#findHaversineDistance(double, double, double, double)}.
	 */
	@Test
	void testFindHaversineDistance() {
		var distance1 = Factorial.findHaversineDistance(28.7041, 77.1025, 30.9661, 76.5231);
		assertEquals(257.7, distance1, 0.1);

		var distance2 = Factorial.findHaversineDistance(-17.947826, 177.221232, -16.603513, -179.779055);
		assertEquals(351.9, distance2, 0.1);
	}

	// Test for out of range inputs, as latitudes should be in range [-90,90] and
	// longitudes in
	// [-180,180]
	@Test
	void testFindHaversineDistanceInvalidRange() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Factorial.findHaversineDistance(666, 0, 0, 0);
		});
	}
}
