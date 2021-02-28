    /** 
	 * Project Name:java11_in_action 
	 * File Name:AllEqualSnippetTest.java 
	 * Package Name:luozix.start.java8.problems.array 
	 * Date:2021年2月28日下午7:53:07 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: AllEqualSnippetTest.java
* @Package luozix.start.java8.problems.array
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:53:07
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.array;  
	/** 
	 * ClassName:AllEqualSnippetTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午7:53:07 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;


/**
* @ClassName: AllEqualSnippetTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:53:07
* @version  
*@since JDK 1.8
*/
class AllEqualSnippetTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.array.AllEqualSnippet#allEqual(T[])}.
	 */
	@Test
	void testAllEqual() {
		var intArray = new Integer[5];
		assertTrue(AllEqualSnippet.allEqual(intArray));
		intArray[0] = 1;
		assertFalse(AllEqualSnippet.allEqual(intArray));
		var stringArray = new String[10];
		Arrays.fill(stringArray, "Hello World");
		assertTrue(AllEqualSnippet.allEqual(stringArray));
		stringArray[3] = "Bye World";
		assertFalse(AllEqualSnippet.allEqual(stringArray));
		var doubleArray = new Double[1];
		assertTrue(AllEqualSnippet.allEqual(doubleArray));
		assertThrows(NullPointerException.class, () -> AllEqualSnippet.allEqual(null));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.array.AllEqualSnippet#arrayConcat(T[], T[])}.
	 */
	@Test
	void testArrayConcat() {
		var integers = AllEqualSnippet.arrayConcat(new Integer[5], new Integer[5]);
		assertEquals(integers.length, 10);
		var strings = AllEqualSnippet.arrayConcat(new String[0], new String[0]);
		assertEquals(strings.length, 0);
		assertThrows(NullPointerException.class, () -> AllEqualSnippet.arrayConcat(null, null));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.array.AllEqualSnippet#findMax(int[])}.
	 */
	@Test
	void testFindMax() {
		assertEquals(9, AllEqualSnippet.findMax(new int[] { 1, 2, 4, 9, 8, 1 }));
		assertEquals(-8, AllEqualSnippet.findMax(new int[] { -43, -23, -51, -10, -8, -65, -9 }));
		assertEquals(0, AllEqualSnippet.findMax(new int[] { -4, -3, -2, -1, 0 }));
		assertEquals(1, AllEqualSnippet.findMax(new int[] { 1, 1, 1, 1, 1, 1 }));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.array.AllEqualSnippet#multiArrayConcat(T[], T[][])}.
	 */
	@Test
	void testMultiArrayConcat() {
		var single = AllEqualSnippet.multiArrayConcat(new Integer[1]);
		assertEquals(single.length, 1);
		var multiple = AllEqualSnippet.multiArrayConcat(new String[5], new String[12], new String[3], new String[8]);
		assertEquals(multiple.length, 28);
		assertThrows(NullPointerException.class, () -> AllEqualSnippet.multiArrayConcat(null, null, null, null));
	}

}
