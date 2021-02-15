    /** 
	 * Project Name:java11_in_action 
	 * File Name:lambdas02.java 
	 * Package Name:luozix.start.lambdas 
	 * Date:2021年2月14日下午3:53:45 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: lambdas02.java
* @Package luozix.start.lambdas
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月14日 下午3:53:45
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 
		 * ClassName:lambdas02 <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月14日 下午3:53:45 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: lambdas02
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月14日 下午3:53:45
* @version  
*@since JDK 1.8
*/
public class lambdas02 {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月14日 下午3:53:45.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int count = 0;
		var allArtists = new ArrayList<Artist>();
//		for (Artist artist : allArtists) {
//			if (artist.isFrom("London")) {
//				count++;
//			}
//		}
//		int count = 0;
//		Iterator<Artist> iterator = allArtists.iterator();
//		while (iterator.hasNext()) {
//			Artist artist = iterator.next();
//			if (artist.isFrom("London")) {
//				count++;
//			}
//		}
		long count = allArtists.stream().filter(artist -> artist.isFrom("London")).count();

//		allArtists.stream().filter(artist -> artist.isFrom("London"));
//		allArtists.stream().filter(artist -> {
//			System.out.println(artist.getName());
//			return artist.isFrom("London");
//		});

//		long count = allArtists.stream().filter(artist -> {
//			System.out.println(artist.getName());
//			return artist.isFrom("London");
//		}).count();

		List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
		assertEquals(Arrays.asList("a", "b", "c"), collected);
//		List<String> collectedlis = new ArrayList<>();
//		for (String string : asList("a", "b", "hello")) {
//			String uppercaseString = string.toUpperCase();
//			collected.add(uppercaseString);
//		}
//
//		assertEquals(asList("A", "B", "HELLO"), collected);

	}

}
