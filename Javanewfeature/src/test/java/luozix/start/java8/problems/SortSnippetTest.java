    /** 
	 * Project Name:java11_in_action 
	 * File Name:SortSnippetTest.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午7:49:06 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: SortSnippetTest.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:49:06
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;

	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import luozix.start.alg.actor.sort.Sort;
	/** 
		 * ClassName:SortSnippetTest <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午7:49:06 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: SortSnippetTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:49:06
* @version  
*@since JDK 1.8
*/
public class SortSnippetTest {

	/**
	 * Tests for {@link BubbleSortSnippet#bubbleSort(int[])}.
	 */
	@Test
	void testBubbleSort() {
		var arr = new int[] { 6, 3, 1, 5, 4, 2 };
		Sort.bubbleSort(arr);
		assertEquals(6, arr.length);
		assertEquals(1, arr[0]);
		assertEquals(2, arr[1]);
		assertEquals(3, arr[2]);
		assertEquals(4, arr[3]);
		assertEquals(5, arr[4]);
		assertEquals(6, arr[5]);
	}

	/**
	 * Tests for {@link InsertionSortSnippet#insertionSort(int[])}.
	 */
	@Test
	void testInsertionSort() {
		var arr = new int[] { 6, 3, 1, 5, 4, 2 };
		Sort.insertionSort(arr);
		assertEquals(6, arr.length);
		assertEquals(1, arr[0]);
		assertEquals(2, arr[1]);
		assertEquals(3, arr[2]);
		assertEquals(4, arr[3]);
		assertEquals(5, arr[4]);
		assertEquals(6, arr[5]);

		assertNotEquals(7, arr.length);
		assertNotEquals(2, arr[0]);
		assertNotEquals(3, arr[1]);
		assertNotEquals(4, arr[2]);
		assertNotEquals(5, arr[3]);
		assertNotEquals(6, arr[4]);
		assertNotEquals(7, arr[5]);
	}

	/**
	 * Tests for {@link QuickSortSnippet#quickSort(int[], int, int)}.
	 */
	@Test
	void testQuickSort() {
		var arr = new int[] { 7, 13, 3, 1, 8, 5 };
		Sort.quickSort(arr, 0, arr.length - 1);
		assertEquals(6, arr.length);
		assertEquals(1, arr[0]);
		assertEquals(3, arr[1]);
		assertEquals(5, arr[2]);
		assertEquals(7, arr[3]);
		assertEquals(8, arr[4]);
		assertEquals(13, arr[5]);
	}

	/**
	 * Tests for {@link SelectionSortSnippet#selectionSort(int[])}.
	 */
	@Test
	void testSelectionSort() {
		var arr = new int[] { 6, 3, 1, 5, 4, 2 };
		Sort.selectionSort(arr);
		assertEquals(6, arr.length);
		assertEquals(1, arr[0]);
		assertEquals(2, arr[1]);
		assertEquals(3, arr[2]);
		assertEquals(4, arr[3]);
		assertEquals(5, arr[4]);
		assertEquals(6, arr[5]);
	}
}
