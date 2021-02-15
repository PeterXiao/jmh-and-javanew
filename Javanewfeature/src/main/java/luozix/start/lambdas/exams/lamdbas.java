    /** 
	 * Project Name:java11_in_action 
	 * File Name:lamdbas.java 
	 * Package Name:luozix.start.lambdas 
	 * Date:2021年2月14日下午5:02:56 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: lamdbas.java
* @Package luozix.start.lambdas
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月14日 下午5:02:56
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/** 
	 * ClassName:lamdbas <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月14日 下午5:02:56 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

/**
* @ClassName: lamdbas
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月14日 下午5:02:56
* @version  
*@since JDK 1.8
*/
public class lamdbas {
	public static void main(String[] args) {
		List<String> collected = new ArrayList<>();
		for (String string : Arrays.asList("a", "b", "hello")) {
			String uppercaseString = string.toUpperCase();
			collected.add(uppercaseString);
		}

		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);

		List<String> collectedstream = Stream.of("a", "b", "hello").map(string -> string.toUpperCase())
				.collect(toList());
		 
		assertEquals(Arrays.asList("A", "B", "HELLO"), collectedstream);
	}
}
