    /** 
	 * Project Name:java11_in_action 
	 * File Name:Beforelambdas.java 
	 * Package Name:luozix.start.lambdas.exams.examples.chapter3 
	 * Date:2021年2月15日上午10:16:03 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Beforelambdas.java
* @Package luozix.start.lambdas.exams.examples.chapter3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 上午10:16:03
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.examples.chapter3;  
	/** 
	 * ClassName:Beforelambdas <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月15日 上午10:16:03 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import static java.util.stream.Collectors.toList;
	import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/**
* @ClassName: Beforelambdas
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 上午10:16:03
* @version  
*@since JDK 1.8
*/
public class Beforelambdas {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月15日 上午10:16:03.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> beginningWithNumbers = new ArrayList<>();
		for (String string : Arrays.asList("a", "1abc", "abc1")) {
			if (Character.isDigit(string.charAt(0))) {
				beginningWithNumbers.add(string);
			}
		}
		
		List<String> beginningWithNumberList = Stream.of("a","1abc","abc1")
				.filter(value -> Character.isDigit(value.charAt(0))).collect(toList());

		assertEquals(Arrays.asList("1abc"), beginningWithNumbers);

	}

}
