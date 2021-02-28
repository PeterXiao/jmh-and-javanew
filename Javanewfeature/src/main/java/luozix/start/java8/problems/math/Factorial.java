    /** 
	 * Project Name:java11_in_action 
	 * File Name:Factorial.java 
	 * Package Name:luozix.start.java8.problems.math 
	 * Date:2021年2月28日下午7:33:23 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Factorial.java
* @Package luozix.start.java8.problems.math
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:33:23
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.math;  
	/** 
	 * ClassName:Factorial <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午7:33:23 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

/**
* @ClassName: Factorial
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:33:23
* @version  
*@since JDK 1.8
*/
public class Factorial {

	/**
	 * Factorial. Works only for small numbers
	 *
	 * @param number for which factorial is to be calculated for
	 * @return factorial
	 */
	public static int factorial(int number) {
		var result = 1;
		for (var factor = 2; factor <= number; factor++) {
			result *= factor;
		}
		return result;
	}

	/**
	 * Recursive Fibonacci series. Works only for small n and is spectacularly
	 * inefficient
	 *
	 * @param n given number
	 * @return fibonacci number for given n
	 */
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/**
	 * Greatest common divisor calculation.
	 *
	 * @param a one of the numbers whose gcd is to be computed
	 * @param b other number whose gcd is to be computed
	 * @return gcd of the two numbers
	 */
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	// Radius of sphere on which the points are, in this case Earth.
	private static final double SPHERE_RADIUS_IN_KM = 6372.8;

	/**
	 * Haversine formula for calculating distance between two latitude, longitude
	 * points.
	 *
	 * @param latA  Latitude of point A
	 * @param longA Longitude of point A
	 * @param latB  Latitude of point B
	 * @param longB Longitude of point B
	 * @return the distance between the two points.
	 */
	public static double findHaversineDistance(double latA, double longA, double latB, double longB) {
		if (!isValidLatitude(latA) || !isValidLatitude(latB) || !isValidLongitude(longA) || !isValidLongitude(longB)) {
			throw new IllegalArgumentException();
		}

		// Calculate the latitude and longitude differences
		var latitudeDiff = Math.toRadians(latB - latA);
		var longitudeDiff = Math.toRadians(longB - longA);

		var latitudeA = Math.toRadians(latA);
		var latitudeB = Math.toRadians(latB);

		// Calculating the distance as per haversine formula
		var a = Math.pow(Math.sin(latitudeDiff / 2), 2)
				+ Math.pow(Math.sin(longitudeDiff / 2), 2) * Math.cos(latitudeA) * Math.cos(latitudeB);
		var c = 2 * Math.asin(Math.sqrt(a));
		return SPHERE_RADIUS_IN_KM * c;
	}

	// Check for valid latitude value
	private static boolean isValidLatitude(double latitude) {
		return latitude >= -90 && latitude <= 90;
	}

	// Check for valid longitude value
	private static boolean isValidLongitude(double longitude) {
		return longitude >= -180 && longitude <= 180;
	}

}
