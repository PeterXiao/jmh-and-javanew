/**
 * 
 */
package luozix.start.action.jdkclass;

/**
 * @author xiaoy
 *
 */
public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Runoob"; // String 直接创建
		String s2 = "Runoob"; // String 直接创建
		String s3 = s1; // 相同引用
		String s4 = new String("Runoob"); // String 对象创建
		String s5 = new String("Runoob"); // String 对象创建

		char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b' };
		String helloString = new String(helloArray);
		System.out.println(helloString);

		String site = "www.runoob.com";
		int len = site.length();
		System.out.println("菜鸟教程网址长度 : " + len);

		String string1 = "null";
		String string2 = "null";
		string1.concat(string2);

		String stringL = "菜鸟教程网址：";
		System.out.println("1、" + stringL + "www.runoob.com");

		Object floatVar = null;
		Object intVar = null;
		Object stringVar = null;
		System.out.printf("浮点型变量的值为 " + "%f, 整型变量的值为 " + " %d, 字符串变量的值为 " + "is %s", floatVar, intVar, stringVar);

		String fs;
		fs = String.format("浮点型变量的值为 " + "%f, 整型变量的值为 " + " %d, 字符串变量的值为 " + " %s", floatVar, intVar, stringVar);
	}

}
/*
 * 
 * 创建格式化字符串 我们知道输出格式化数字可以使用 printf() 和 format() 方法。
 * 
 * String 类使用静态方法 format() 返回一个String 对象而不是 PrintStream 对象。
 * 
 * String 类的静态方法 format() 能用来创建可复用的格式化字符串，而不仅仅是用于一次打印输出。
 */