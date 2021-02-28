    /** 
	 * Project Name:java11_in_action 
	 * File Name:StringToDate.java 
	 * Package Name:luozix.start.java8.problems.string 
	 * Date:2021年2月28日下午6:43:31 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: StringToDate.java
* @Package luozix.start.java8.problems.string
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:43:31
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.string;

	import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

	/** 
		 * ClassName:StringToDate <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午6:43:31 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: StringToDate
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:43:31
* @version  
*@since JDK 1.8
*/
public class StringToDate {

	/**
	 * Convert string to date.
	 *
	 * @param date   the date string
	 * @param format expected date format
	 * @return Date
	 * @throws ParseException in case of an unparseable date string
	 */
	public static Date stringToDate(String date, String format) throws ParseException {
		var simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.parse(date);
	}

	/**
	 * Checks if two words are anagrams (contains same characters with same
	 * frequency in any order).
	 *
	 * @param s1 The first string to be checked
	 * @param s2 The second string to be checked
	 * @return true if they are anagrams of each other
	 */
	public static boolean isAnagram(String s1, String s2) {
		var l1 = s1.length();
		var l2 = s2.length();
		var arr1 = new int[256];
		var arr2 = new int[256];
		if (l1 != l2) {
			return false;
		}
		for (var i = 0; i < l1; i++) {
			arr1[s1.charAt(i)]++;
			arr2[s2.charAt(i)]++;
		}
		return Arrays.equals(arr1, arr2);
	}

	private static final String EXTRACT_VERSION_REGEX = ".*?((?<!\\w)\\d+([.-]\\d+)*).*";

	/**
	 * Compares two version strings. Credits:
	 * https://stackoverflow.com/a/6702000/6645088 and
	 * https://stackoverflow.com/a/44592696/6645088
	 *
	 * @param v1 the first version string to compare
	 * @param v2 the second version string to compare
	 * @return the value {@code 0} if the two strings represent same versions; a
	 *         value less than {@code 0} if {@code v1} is greater than {@code v2};
	 *         and a value greater than {@code 0} if {@code v2} is greater than
	 *         {@code v1}
	 */
	public static int compareVersion(String v1, String v2) {
		var components1 = getVersionComponents(v1);
		var components2 = getVersionComponents(v2);
		int length = Math.max(components1.length, components2.length);
		for (int i = 0; i < length; i++) {
			Integer c1 = i < components1.length ? Integer.parseInt(components1[i]) : 0;
			Integer c2 = i < components2.length ? Integer.parseInt(components2[i]) : 0;
			int result = c1.compareTo(c2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}

	private static String[] getVersionComponents(String version) {
		return version.replaceAll(EXTRACT_VERSION_REGEX, "$1").split("\\.");
	}

	/**
	 * Find the Levenshtein distance between two words.
	 * https://en.wikipedia.org/wiki/Levenshtein_distance
	 *
	 * @param word1 first word
	 * @param word2 second word
	 * @return distance
	 */
	public static int findLevenshteinDistance(String word1, String word2) {
		// If word2 is empty, removing
		int[][] ans = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			ans[i][0] = i;
		}
		// if word1 is empty, adding
		for (int i = 0; i <= word2.length(); i++) {
			ans[0][i] = i;
		}
		// None is empty
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int min = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);
				ans[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? ans[i - 1][j - 1] : min + 1;
			}
		}
		return ans[word1.length()][word2.length()];
	}

	/**
	 * Checks if given string is palindrome (same forward and backward). Skips
	 * non-letter characters Credits: https://github.com/kousen/java_8_recipes
	 *
	 * @param s string to check
	 * @return true if palindrome
	 */
	public static boolean isPalindrome(String s) {
		var sb = new StringBuilder();
		for (var c : s.toCharArray()) {
			if (Character.isLetter(c)) {
				sb.append(c);
			}
		}
		var forward = sb.toString().toLowerCase();
		var backward = sb.reverse().toString().toLowerCase();
		return forward.equals(backward);
	}


	    /**
	     * Reverse string.
	     *
	     * @param s the string to reverse
	     * @return reversed string
	     */
	    public static String reverseString(String s) {
	      return new StringBuilder(s).reverse().toString();
	    }
	  

}
