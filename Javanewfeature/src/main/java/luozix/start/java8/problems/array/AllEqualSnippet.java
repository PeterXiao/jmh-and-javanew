    /** 
	 * Project Name:java11_in_action 
	 * File Name:AllEqualSnippet.java 
	 * Package Name:luozix.start.java8.problems.array 
	 * Date:2021年2月28日下午6:10:05 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: AllEqualSnippet.java
* @Package luozix.start.java8.problems.array
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:10:05
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.array;

import java.util.Arrays;

/** 
	 * ClassName:AllEqualSnippet <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午6:10:05 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

/**
* @ClassName: AllEqualSnippet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:10:05
* @version  
*@since JDK 1.8
*/
public class AllEqualSnippet {

	/**
	 * Returns true if all elements in array are equal.
	 *
	 * @param arr the array to check (not null)
	 * @param <T> the element type
	 * @return true if all elements in the array are equal
	 */
	public static <T> boolean allEqual(T[] arr) {
		return Arrays.stream(arr).distinct().count() == 1;
	}

	/**
	 * Generic 2 array concatenation Credits: Joachim Sauer
	 * https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
	 *
	 * @param first  is the first array (not null)
	 * @param second is the second array (not null)
	 * @param <T>    the element type
	 * @return concatenated array
	 */
	public static <T> T[] arrayConcat(T[] first, T[] second) {
		var result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	/**
	 * Returns the maximum integer from the array using reduction.
	 * 
	 * @param arr the array of integers (not null)
	 * @return the maximum element from the array
	 */
	public static int findMax(int[] arr) {
		return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
	}

	/**
	 * Generic N array concatenation Credits: Joachim Sauer
	 * https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
	 *
	 * @param first is the first array (not null)
	 * @param rest  the rest of the arrays (optional)
	 * @param <T>   the element type
	 * @return concatenated array
	 */
	public static <T> T[] multiArrayConcat(T[] first, T[]... rest) {
		var totalLength = first.length;
		for (var array : rest) {
			totalLength += array.length;
		}
		var result = Arrays.copyOf(first, totalLength);
		var offset = first.length;
		for (var array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

}
