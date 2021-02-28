    /** 
	 * Project Name:java11_in_action 
	 * File Name:StringToDateTest.java 
	 * Package Name:luozix.start.java8.problems.string 
	 * Date:2021年2月28日下午8:27:15 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: StringToDateTest.java
* @Package luozix.start.java8.problems.string
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:27:15
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.string;  
	/** 
	 * ClassName:StringToDateTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:27:15 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
/**
* @ClassName: StringToDateTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:27:15
* @version  
*@since JDK 1.8
*/
class StringToDateTest {

	/**
	 * Test method for
	 * {@link luozix.start.java8.problems.string.StringToDate#stringToDate(java.lang.String, java.lang.String)}.
	 * 
	 * @throws ParseException
	 */
	@Test
	void testStringToDate() throws ParseException {
		var calendar = Calendar.getInstance();
		calendar.setTime(StringToDate.stringToDate("2017-08-18", "yyyy-MM-dd"));
		assertEquals(2017, calendar.get(Calendar.YEAR));
		assertEquals(8, calendar.get(Calendar.MONTH) + 1);
		assertEquals(18, calendar.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.string.StringToDate#isAnagram(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testIsAnagram() {
		assertTrue(StringToDate.isAnagram("Aditya", "aytdiA"));
		assertFalse(StringToDate.isAnagram("Aditya", "aytida"));
		assertTrue(StringToDate.isAnagram("~~# @!", "~@!#~ "));
		assertTrue(StringToDate.isAnagram("Mother In Law", "hIt Ler woMan"));
		assertFalse(StringToDate.isAnagram("aa", "aaa"));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.string.StringToDate#compareVersion(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCompareVersion() {
		assertEquals(0, StringToDate.compareVersion("awesome-app-2.3.4-SNAPSHOT", "2.3.4"));
		assertEquals(0, StringToDate.compareVersion("2.3.4-SNAPSHOT", "2.3.4"));
		assertEquals(1, StringToDate.compareVersion("2.3.4.1-SNAPSHOT", "2.3.4"));
		assertEquals(0, StringToDate.compareVersion("2.03.4", "2.3.4"));
		assertEquals(-1, StringToDate.compareVersion("2.03.4", "2.3.4.1"));
		assertEquals(-1, StringToDate.compareVersion("2.3.4", "2.30.4"));
		assertEquals(0, StringToDate.compareVersion("2.3.0", "2.3"));
		assertEquals(1, StringToDate.compareVersion("2.3.3", "2.3"));

		// Test for sorting versions
		List<String> versions = Arrays.asList("2.3.4.1", "2.3.5-beta2", "2.3.4.RELEASE", "awesome-app-2.2",
				"2.3.2-SNAPSHOT", "2.2.1");

		List<String> expectedSortedVersion = Arrays.asList("awesome-app-2.2", "2.2.1", "2.3.2-SNAPSHOT",
				"2.3.4.RELEASE", "2.3.4.1", "2.3.5-beta2");

		String oldestVersion = versions.stream().min(StringToDate::compareVersion).get();
		assertEquals("awesome-app-2.2", oldestVersion);

		String newestVersion = versions.stream().max(StringToDate::compareVersion).get();
		assertEquals("2.3.5-beta2", newestVersion);

		assertArrayEquals(expectedSortedVersion.toArray(),
				versions.stream().sorted(StringToDate::compareVersion).toArray());
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.string.StringToDate#findLevenshteinDistance(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindLevenshteinDistance() {
		assertEquals(3, StringToDate.findLevenshteinDistance("kitten", "kit"));
		assertEquals(6, StringToDate.findLevenshteinDistance("kitten", ""));
		assertEquals(7, StringToDate.findLevenshteinDistance("", "sitting"));
		assertEquals(3, StringToDate.findLevenshteinDistance("kitten", "sitting"));
		assertEquals(5, StringToDate.findLevenshteinDistance("intention", "execution"));
		assertEquals(10, StringToDate.findLevenshteinDistance("zoologicoarchaeologist", "zoogeologist"));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.string.StringToDate#isPalindrome(java.lang.String)}.
	 */
	@Test
	void testIsPalindrome() {
		assertTrue(StringToDate.isPalindrome("saippuakauppias"));
		// non-letter characters are skipped
		assertTrue(StringToDate.isPalindrome("111 Saippua - Kauppias 321"));
		assertFalse(StringToDate.isPalindrome("Type O Negative"));
		assertFalse(StringToDate.isPalindrome("Foo12121Bar"));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.string.StringToDate#reverseString(java.lang.String)}.
	 */
	@Test
	void testReverseString() {
		assertEquals("oof", StringToDate.reverseString("foo"));
		assertEquals("ÖÄÅ321FED cba", StringToDate.reverseString("abc DEF123ÅÄÖ"));
	}

	/**
	 * Tests for {@link CompareVersionSnippet#compareVersion(String, String)}.
	 */

}
