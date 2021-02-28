    /** 
	 * Project Name:java11_in_action 
	 * File Name:StreamToStringTest.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午8:12:51 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: StreamToStringTest.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:12:51
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;  
	/** 
	 * ClassName:StreamToStringTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:12:51 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
* @ClassName: StreamToStringTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:12:51
* @version  
*@since JDK 1.8
*/
class StreamToStringTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.StreamToString#inputStreamToString(java.io.InputStream)}.
	 */
	@Test
	void testInputStreamToString() throws IOException {
		String str = "ąćśź\n" + "←≠²³¢²€\n" + "июля\n" + "åøä\n" + "ñí\n" + "7月15日起\n" + "خەيرلىك ئەتىگەن!";
		assertEquals(str,
				StreamToString.inputStreamToString(new FileInputStream("src/test/resources/dir1/placeholder.txt")));
		assertNotEquals(str.toUpperCase(),
				StreamToString.inputStreamToString(new FileInputStream("src/test/resources/dir1/placeholder.txt")));
	}

	/**
	 * Test method for
	 * {@link luozix.start.java8.problems.StreamToString#readFile(java.lang.String)}.
	 * 
	 * @throws IOException
	 */
	@Test
	void testReadFile() throws IOException {
		assertEquals("foo", StreamToString.readFile("src/test/resources/somelines.txt").get(0));
		assertEquals("bar", StreamToString.readFile("src/test/resources/somelines.txt").get(1));
		assertEquals("baz", StreamToString.readFile("src/test/resources/somelines.txt").get(2));
		assertNotEquals("abc", StreamToString.readFile("src/test/resources/somelines.txt").get(1));
	}

}
