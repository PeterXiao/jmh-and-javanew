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
public class TestappendRe {

	private static String REGEX = "a*b";
	private static String INPUT = "aabfooaabfooabfoobkkk";
	private static String REPLACE = "-";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// 获取 matcher 对象
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, REPLACE);
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}
