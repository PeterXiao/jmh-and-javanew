    /** 
	 * Project Name:java11_in_action 
	 * File Name:HttpSnippetTest.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午8:17:08 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: HttpSnippetTest.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:17:08
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;  
	/** 
	 * ClassName:HttpSnippetTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:17:08 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
/**
* @ClassName: HttpSnippetTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:17:08
* @version  
*@since JDK 1.8
*/
class HttpSnippetTest {

	/**
	 * Test method for
	 * {@link luozix.start.java8.problems.HttpSnippet#httpGet(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testHttpGet() throws Exception {
		var response = HttpSnippet.httpGet("http://www.google.com");
		assertEquals(200, response.statusCode());
	}

	/**
	 * Test method for
	 * {@link luozix.start.java8.problems.HttpSnippet#httpPost(java.lang.String, java.util.HashMap)}.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	void testHttpPost() throws IOException, InterruptedException {
		HashMap<String, String> arguments = new HashMap<>();
		arguments.put("data", "Hello World");
		var result = HttpSnippet.httpPost("https://postman-echo.com/post", arguments);
		// This postman endpoint echoes the HTTP headers, request parameters, the
		// contents
		// of the request body and the complete URI requested.
		var echoedData = "\"data\":\"Hello World\"";
		assertThat(result.body(), containsString(echoedData));
	}

}
