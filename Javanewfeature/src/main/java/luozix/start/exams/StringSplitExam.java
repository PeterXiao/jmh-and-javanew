/**
 * 
 */
package luozix.start.exams;

import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

/**
 * @author xiaoy
 *
 */
public class StringSplitExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "www-rubbo-com";
		String[] tempStrings;
		String deString = "-";
		tempStrings = string.split(deString);
		for (int i = 0; i < tempStrings.length; i++) {
			System.out.println(tempStrings[i]);
			System.out.print(" ");

		}

	      System.out.println("------java for each循环输出的方法-----");
	      String str1 = "www.runoob.com";
	      String[] temp1;
	      String delimeter1 = "\\.";  // 指定分割字符， . 号需要转义
	      temp1 = str1.split(delimeter1); // 分割字符串
	      for(String x :  temp1){
	         System.out.println(x);
	         System.out.println("");
		
	}

	String str = "www.runoob.com";
	// 实例化对象，并指向以 . 对 str 进行分割
	StringTokenizer str2 = new StringTokenizer(str, ".");
	// 对 str2 遍历并打印子字符串；
	while (str2.hasMoreTokens()) {
		System.out.println(str2.nextToken());
	}

	String s1 = "123-123.2-1--";
	String[] ss1 = s1.split("-");
	System.out.println(ss1.length);// 3
	System.out.println(Arrays.toString(ss1));// [123, 123.2, 1]
	String s2 = "123--123.2-1--";
	String[] ss2 = s2.split("-");
	System.out.println(ss2.length);// 4
	System.out.println(Arrays.toString(ss2));// [123, , 123.2, 1]

	// StringTokenizer和split方法还有一个很重要的区别就是：前者会以给定分割字符串的每个字符进行分割，而后者是以整个字符串进行切割。
	String str11 = "This is String , split by StringTokenizer, created by runoob";
	StringTokenizer st = new StringTokenizer(str11);

	System.out.println("----- 通过空格分隔 ------");
	while (st.hasMoreElements()) {
		System.out.println(st.nextElement());
	}

	System.out.println("----- 通过逗号分隔 ------");
	StringTokenizer st2 = new StringTokenizer(str11, ",");

	while (st2.hasMoreElements()) {
		System.out.println(st2.nextElement());
	}
}

@Test
public void test() {
	String str1 = "Hello";
	// 字符串分割
	System.out.println("字符串使用 split 分割");
	System.out.print("将 Hello 从字符串 ll 处分割:");
	for (String temp : str1.split("ll")) {
		System.out.print(temp + "  ");
	}
	System.out.println();
	System.out.println("------------------------------------");
	System.out.println("字符串使用 StringTokenizer 类进行分割");// 实验心得 StringTokenizer 不保留空集
	StringTokenizer s = new StringTokenizer(str1, "l");
	System.out.print("将 Hello 从字符 l 处分割：");
	while (s.hasMoreElements()) {
		System.out.print(s.nextElement() + "  ");
	}
	System.out.println();
}

@Test
public void test1() {
	String str = "Hello,this is a test";
	System.out.println("使用split分割str");
	System.out.print("将str从字符串 el 处分割:");
	for (String temp : str.split("el")) {
		System.out.print(temp + "  ");
	}
	System.out.println();
	System.out.println("------------------------------------");
	System.out.println("使用StringTokenizer类进行分割");
	StringTokenizer s = new StringTokenizer(str, "el");
	System.out.print("将str从字符e和l处分割：");
	while (s.hasMoreElements()) {
		System.out.print(s.nextElement() + "  ");
	}
	System.out.println();
}
}
