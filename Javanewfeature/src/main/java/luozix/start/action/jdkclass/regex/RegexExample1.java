/**
 * 
 */
package luozix.start.action.jdkclass.regex;

import java.util.regex.Pattern;

/**
 * @author xiaoy
 *
 */
public class RegexExample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "I am noob " + "from runoob.com.";

		String pattern = ".*runoob.*";

		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
	}

}
/*
 * 
 * 捕获组 捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
 * 
 * 例如，正则表达式 (dog) 创建了单一分组，组里包含"d"，"o"，和"g"。
 * 
 * 捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：
 * 
 * ((A)(B(C)))
 * 
 * (A)
 * 
 * (B(C))
 * 
 * (C) 可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int
 * 值，表示matcher对象当前有多个捕获组。
 * 
 * 还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
 * 
 */