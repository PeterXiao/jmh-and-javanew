/**
 * 
 */
package luozix.start.action.jdkclass.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaoy
 *
 */
public class TestReplace {

	private static String REGEX = "dog";
	private static String INPUT = "The dog says meow. " + "All dogs say meow.";
	private static String REPLACE = "cat";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// get a matcher object
		Matcher m = p.matcher(INPUT);
		INPUT = m.replaceAll(REPLACE);
		System.out.println(INPUT);
	}

}
