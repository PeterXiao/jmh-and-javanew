    /** 
	 * Project Name:java11_in_action 
	 * File Name:LambdasTemplate.java 
	 * Package Name:luozix.start.lambdas.exams.answers.chapter4 
	 * Date:2021年2月15日上午11:33:18 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: LambdasTemplate.java
* @Package luozix.start.lambdas.exams.answers.chapter4
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 上午11:33:18
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.answers.chapter4;

import java.util.IntSummaryStatistics;

import luozix.start.lambdas.exams.examples.chapter1.Album;

/** 
	 * ClassName:LambdasTemplate <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月15日 上午11:33:18 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

/**
* @ClassName: LambdasTemplate
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 上午11:33:18
* @version  
*@since JDK 1.8
*/
public class LambdasTemplate {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月15日 上午11:33:18.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Logger logger = new Logger();
		// logger.debug(() -> "Look at this: " + expensiveOperation());

	}

	public static void printTrackLengthStatistics(Album album) {
		IntSummaryStatistics trackLengthStats = album.getTracks().mapToInt(track -> track.getLength())
				.summaryStatistics();
		System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d", trackLengthStats.getMax(), trackLengthStats.getMin(),
				trackLengthStats.getAverage(), trackLengthStats.getSum());
	}

	private void overloadedMethod(Object o) {
		System.out.print("Object");
	}

	private void overloadedMethod(String s) {
		System.out.print("String");
	}

}
