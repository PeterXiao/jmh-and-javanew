    /** 
	 * Project Name:java11_in_action 
	 * File Name:CreatingObjectSnippetTest.java 
	 * Package Name:luozix.start.java8.problems.cls 
	 * Date:2021年2月28日下午7:58:30 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: CreatingObjectSnippetTest.java
* @Package luozix.start.java8.problems.cls
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:58:30
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.cls;  
	/** 
	 * ClassName:CreatingObjectSnippetTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午7:58:30 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

/**
* @ClassName: CreatingObjectSnippetTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:58:30
* @version  
*@since JDK 1.8
*/
class CreatingObjectSnippetTest {

	/**
	 * Tests for {@link CreatingObjectSnippet#createObject(String)}.
	 */
	@Test
	void testCreateObject() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		assertEquals(String.class, CreatingObjectSnippet.createObject("java.lang.String").getClass());
		assertNotEquals(Integer.class, CreatingObjectSnippet.createObject("java.lang.String").getClass());
	}

}
