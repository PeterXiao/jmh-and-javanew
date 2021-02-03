/**
 * 
 */
package luozix.start.exams;

import org.junit.jupiter.api.Test;

/**
 * @author xiaoy
 *
 */
public class StringOptimization {
	public static void main(String[] args) {
		String variables[] = new String[50000];
		for (int i = 0; i < 50000; i++) {
			variables[i] = "s" + i;
		}
		long startTime0 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables[i] = "hello";
		}
		long endTime0 = System.currentTimeMillis();
		System.out.println("直接使用字符串： " + (endTime0 - startTime0) + " ms");
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables[i] = new String("hello");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("使用 new 关键字：" + (endTime1 - startTime1) + " ms");
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables[i] = new String("hello");
			variables[i] = variables[i].intern();
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("使用字符串对象的 intern() 方法: " + (endTime2 - startTime2) + " ms");
	}

	@Test
	public void name() {
		String variables[] = new String[50000];
		long startTime0 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables[i] = "hello";
		}

		long endTime0 = System.currentTimeMillis();
		System.out.println("使用字面量直接赋值字符串，花费时间：" + (endTime0 - startTime0) + "毫秒");
		String variables1[] = new String[50000];
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables1[i] = new String("hello");
		}

		long endTime1 = System.currentTimeMillis();
		System.out.println("使用字符串对象花费时间：" + (endTime1 - startTime1) + "毫秒");
		String variables2[] = new String[50000];
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables2[i] = new String("hello");
			variables2[i] = variables2[i].intern();
		}

		long endTime2 = System.currentTimeMillis();
		System.out.println("使用字符串对象intern()方法花费时间：" + (endTime2 - startTime2) + "毫秒");

	}
}
