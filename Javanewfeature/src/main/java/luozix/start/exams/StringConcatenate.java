/**
 * 
 */
package luozix.start.exams;

import org.junit.jupiter.api.Test;

/**
 * @author xiaoy
 *
 */
public class StringConcatenate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			String result = "This is" + "testing the" + "difference" + "between" + "String" + "and" + "StringBuffer";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 + 操作符 : " + (endTime - startTime) + " ms");
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			StringBuffer result = new StringBuffer();
			result.append("This is");
			result.append("testing the");
			result.append("difference");
			result.append("between");
			result.append("String");
			result.append("and");
			result.append("StringBuffer");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 StringBuffer : " + (endTime1 - startTime1) + " ms");

	}

	@Test // +"为每个字符串变量赋值，公用一个内值，占用一份内存空间；"StringBuffer"每次新建一个新对象，内存分配新的空间，新分配5000份内存空间
	public void stringConcatenate() {
		long startTime = System.currentTimeMillis();
		String[] strArr = new String[500];
		for (int i = 0; i < 500; i++) {
			String result = "This is";
			strArr[i] = String.valueOf(result.hashCode());
		}
		long endTime = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 + 操作符 : " + (endTime - startTime) + " ms");
		System.out.println(strArr[0] + "\n" + strArr[1] + "\n" + strArr[2]);
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 500; i++) {
			StringBuffer result = new StringBuffer();
			result.append("This is");
			strArr[i] = String.valueOf(result.hashCode());
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 StringBuffer : " + (endTime1 - startTime1) + " ms");
		System.out.println(strArr[0] + "\n" + strArr[1] + "\n" + strArr[2]);
	}

	@Test
	public void stringCon() {
		String result1 = null;
		StringBuffer result = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			result1 += "This is" + "testing the" + "difference" + "between" + "String" + "and" + "StringBuffer";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 + 操作符 : " + (endTime - startTime) + " ms");
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {

			result.append("This is");
			result.append("testing the");
			result.append("difference");
			result.append("between");
			result.append("String");
			result.append("and");
			result.append("StringBuffer");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 StringBuffer : " + (endTime1 - startTime1) + " ms");
	}
}
