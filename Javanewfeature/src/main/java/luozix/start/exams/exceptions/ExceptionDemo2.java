/**
 * 
 */
package luozix.start.exams.exceptions;

/**
 * @author xiaoy
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] argv) {
		new ExceptionDemo2().doTheWork();

		int array[] = { 20, 20, 40 };
		int num1 = 15, num2 = 10;
		int result = 10;
		try {
			result = num1 / num2;
			System.out.println("结果为 " + result);
			for (int i = 5; i >= 0; i--) {
				System.out.println("数组的元素值为 " + array[i]);
			}
		} catch (Exception e) {
			System.out.println("触发异常 : " + e);
		}
	}

	public void doTheWork() {
		Object o = null;
		for (int i = 0; i < 5; i++) {
			try {
				o = makeObj(i);
			} catch (IllegalArgumentException e) {
				System.err.println("Error: (" + e.getMessage() + ").");
				return;
			} finally {
				System.err.println("都已执行完毕");
				if (o == null)
					System.exit(0);
			}
			System.out.println(o);
		}
	}

	public Object makeObj(int type) throws IllegalArgumentException {
		if (type == 1)
			throw new IllegalArgumentException("不是指定的类型： " + type);
		return new Object();
	}
}