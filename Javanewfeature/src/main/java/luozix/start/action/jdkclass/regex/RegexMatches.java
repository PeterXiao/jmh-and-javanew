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
public class RegexMatches {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";

		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}



	Pattern p = Pattern.compile(REGEX);
	Matcher m1 = p.matcher(INPUT); // 获取 matcher 对象
	int count = 0;

	while (m1.find())
	{
		count++;
		System.out.println("Match number " + count);
		System.out.println("start(): " + m1.start());
		System.out.println("end(): " + m1.end());

	}
}

private static final String REGEX = "\\bcat\\b";
private static final String INPUT = "cat cat cat cattie cat";
}
