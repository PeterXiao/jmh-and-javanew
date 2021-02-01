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
public class TestRegexMatches {
	private static final String REGEX = "foo";
	private static final String INPUT = "fooooooooooooooooo";
	private static final String INPUT2 = "ooooofoooooooooooo";
	private static Pattern pattern;
	private static Matcher matcher;
	private static Matcher matcher2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 
		       pattern = Pattern.compile(REGEX);
		       matcher = pattern.matcher(INPUT);
		       matcher2 = pattern.matcher(INPUT2);
		 
		       System.out.println("Current REGEX is: "+REGEX);
		       System.out.println("Current INPUT is: "+INPUT);
		       System.out.println("Current INPUT2 is: "+INPUT2);
		 
		 
		       System.out.println("lookingAt(): "+matcher.lookingAt());
		       System.out.println("matches(): "+matcher.matches());
		       System.out.println("lookingAt(): "+matcher2.lookingAt());

	}

}
