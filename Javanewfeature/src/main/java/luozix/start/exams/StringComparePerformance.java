/**
 * 
 */
package luozix.start.exams;

/**
 * @author xiaoy
 *
 */
public class StringComparePerformance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s1 = "hello";
			String s2 = "hello";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("通过 String 关键词创建字符串" + " : " + (endTime - startTime) + " 毫秒");
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s3 = new String("hello");
			String s4 = new String("hello");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("通过 String 对象创建字符串" + " : " + (endTime1 - startTime1) + " 毫秒");
	
		String variables[] = new String[50000];
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables[i] = "hello";
        }

        long endTime0 = System.currentTimeMillis();
        System.out.println("使用字面量直接赋值字符串，花费时间：" + (endTime0 - startTime0) + "毫秒");
        String variables1[] = new String[50000];
        long startTime11 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables1[i] = new String("hello");
        }

        long endTime11 = System.currentTimeMillis();
        System.out.println("使用字符串对象花费时间：" + (endTime11 - startTime11) + "毫秒");
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
