    /** 
	 * Project Name:java11_in_action 
	 * File Name:GetAllFieldNamesSnippetTest.java 
	 * Package Name:luozix.start.java8.problems.cls 
	 * Date:2021年2月28日下午8:00:01 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: GetAllFieldNamesSnippetTest.java
* @Package luozix.start.java8.problems.cls
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:00:01
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.cls;  
	/** 
	 * ClassName:GetAllFieldNamesSnippetTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:00:01 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
* @ClassName: GetAllFieldNamesSnippetTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:00:01
* @version  
*@since JDK 1.8
*/
class GetAllFieldNamesSnippetTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.cls.GetAllFieldNamesSnippet#getAllFieldNames(java.lang.Class)}.
	 */
	@Test
	void testGetAllFieldNames() {
		class SuperClass {
			public int superFieldOne;
			private int superFieldTwo;
		}

		class TestClass extends SuperClass {
			public int fieldOne;
			private int fieldTwo;
		}

		var list = GetAllFieldNamesSnippet.getAllFieldNames(TestClass.class);
		assertEquals(4, list.size());
		assertTrue(list.contains("fieldOne"));
		assertTrue(list.contains("fieldTwo"));
		assertTrue(list.contains("superFieldOne"));
		assertTrue(list.contains("superFieldTwo"));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.cls.GetAllFieldNamesSnippet#getAllMethods(java.lang.Class)}.
	 */
	@Test
	void testGetAllMethods() {
		var list = GetAllFieldNamesSnippet.getAllMethods(GetAllFieldNamesSnippet.class);
		assertTrue(list.contains("getAllMethods"));
	}
	/**
	 * Test method for {@link luozix.start.java8.problems.cls.GetAllFieldNamesSnippet#getAllPublicFieldNames(java.lang.Class)}.
	 */

	@Test
	void testGetAllPublicFieldNames() {
		class TestClass {
			public int fieldOne;
			public int fieldTwo;
		}

		var list = GetAllFieldNamesSnippet.getAllPublicFieldNames(TestClass.class);
		assertEquals(2, list.size());
		assertTrue(list.contains("fieldOne"));
		assertTrue(list.contains("fieldTwo"));
	}

}
