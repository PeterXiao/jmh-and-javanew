/**
 * 
 */
package luozix.start.exams;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaoy
 *
 */
public class StringCompareEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Hello World!";
		String anString = "hello world!";
		Object object = string;
		System.out.println();
		System.out.println(string.compareTo(anString));
		System.out.println(string.compareToIgnoreCase(anString)); // 忽略大小写
		System.out.println(string.compareTo(object.toString()));

		String strOString = "Hello World,Hello Rub!";
		int lastindex = strOString.lastIndexOf("Rub");
		switch (lastindex) {
		case -1:
			System.out.println("没有找到字符串 Rub");
			break;
		default:
			System.out.println("Rub 字符串最后出现的位置： " + lastindex);

		}

//	      if(lastIndex == - 1){
//	          System.out.println("没有找到字符串 Runoob");
//	       }else{
//	          System.out.println("Runoob 字符串最后出现的位置： "+ lastIndex);
//	       }

		String str = "this is Java";
		System.out.println(removeCharAt(str, 3));

		String strreplaceString = "Hello World";
		System.out.println(strreplaceString.replace('H', 'W'));
		System.out.println(strreplaceString.replaceFirst("He", "Wa"));
		System.out.println(strreplaceString.replaceAll("He", "Ha"));

		String str1 = "Hello World";
		String regEx = "[abcdH]";
		String reStr = "";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str1); // 替换 a、b、c、d、H 为空，即删除这几个字母
		reStr = matcher.replaceAll("").trim();
		System.out.println(reStr);

		String string1 = "runoob";
		String reverse = new StringBuffer(string1).reverse().toString();
		System.out.println("字符串反转前:" + string1);
		System.out.println("字符串反转后:" + reverse);

		String littteString = "string rub!";
		System.out.println("原字符串" + littteString);
		System.out.println("字符串转大写" + littteString.toUpperCase());

		System.out.println("字符串转小写" + littteString.toUpperCase().toLowerCase());

		String first_sString = "Welcome to Microsoft";
		String second_sString = "I work with microsoft";
		boolean matchx = first_sString.regionMatches(11, second_sString, 12, 9);
		boolean matchx1 = first_sString.regionMatches(true, 11, second_sString, 12, 9);
		// 第一个参数true 表示忽略大小写
		System.out.print("区分大小写: " + matchx + "\n");
		System.out.println("不区分大小写： " + matchx1);

		double e = Math.E;
		System.out.format("%f%n", e);
		System.out.format(Locale.CHINA, "%-10.4f%n%n", e);
	}

	public static String removeCharAt(String s, int pos) {
		return s.substring(0, pos) + s.substring(pos + 1);
	}

}
