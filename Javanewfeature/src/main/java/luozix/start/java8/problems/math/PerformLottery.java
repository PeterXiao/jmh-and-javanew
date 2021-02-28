    /** 
	 * Project Name:java11_in_action 
	 * File Name:PerformLottery.java 
	 * Package Name:luozix.start.java8.problems.math 
	 * Date:2021年2月28日下午7:37:06 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: PerformLottery.java
* @Package luozix.start.java8.problems.math
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:37:06
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.math;

	import java.util.ArrayList;
	import java.util.Collections;

	/** 
		 * ClassName:PerformLottery <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午7:37:06 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: PerformLottery
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:37:06
* @version  
*@since JDK 1.8
*/
public class PerformLottery {

	/**
	 * Generate random lottery numbers.
	 *
	 * @param numNumbers    how many performLottery numbers are available (e.g. 49)
	 * @param numbersToPick how many numbers the player needs to pick (e.g. 6)
	 * @return array with the random numbers
	 */
	public static Integer[] performLottery(int numNumbers, int numbersToPick) {
		var numbers = new ArrayList<Integer>();
		for (var i = 0; i < numNumbers; i++) {
			numbers.add(i + 1);
		}
		Collections.shuffle(numbers);
		return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
	}

	/**
	 * Checks if given number is a prime number. Prime number is a number that is
	 * greater than 1 and divided by 1 or itself only Credits:
	 * https://en.wikipedia.org/wiki/Prime_number
	 *
	 * @param number number to check prime
	 * @return true if prime
	 */
	public static boolean isPrime(int number) {
		if (number < 3) {
			return true;
		}
		// check if n is a multiple of 2
		if (number % 2 == 0) {
			return false;
		}
		// if not, then just check the odds
		for (var i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
