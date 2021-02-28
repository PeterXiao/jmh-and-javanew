    /** 
	 * Project Name:java11_in_action 
	 * File Name:Base64DeEnTest.java 
	 * Package Name:luozix.start.java8.problems.encoding 
	 * Date:2021年2月28日下午8:04:49 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Base64DeEnTest.java
* @Package luozix.start.java8.problems.encoding
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:04:49
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.encoding;  
	/** 
	 * ClassName:Base64DeEnTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:04:49 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
* @ClassName: Base64DeEnTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:04:49
* @version  
*@since JDK 1.8
*/
class Base64DeEnTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.encoding.Base64DeEn#decodeBase64(java.lang.String)}.
	 */
	@Test
	void testDecodeBase64() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.encoding.Base64DeEn#encodeBase64(java.lang.String)}.
	 */
	@Test
	void testEncodeBase64() {
		fail("Not yet implemented");
	}

	/**
	 * Tests for {@link Base64DecodeSnippet#decodeBase64(String)}.
	 */
	@Test
	void testBase64Decoding() {
		var decodedString = Base64DeEn.decodeBase64("VGVzdFN0cmluZw==");
		assertEquals("TestString", decodedString);
	}

	/**
	 * Tests for {@link Base64DecodeSnippet#decodeBase64(String)} with empty input.
	 */
	@Test
	void testEmptyBase64Decoding() {
		var decodedString = Base64DeEn.decodeBase64("");
		assertEquals("", decodedString);
	}

	/**
	 * Tests for {@link Base64EncodeSnippet#encodeBase64(String)}.
	 */
	@Test
	void testBase64Encoding() {
		var encodedString = Base64DeEn.encodeBase64("TestString");
		assertEquals("VGVzdFN0cmluZw==", encodedString);
	}

	/**
	 * Tests for {@link Base64EncodeSnippet#encodeBase64(String)} for empty input.
	 */
	@Test
	void testEmptyBase64Encoding() {
		var encodedString = Base64DeEn.encodeBase64("");
		assertEquals("", encodedString);
	}
}

