/**
 * 
 */
package luozix.start.action.jdkclass;

import java.util.Scanner;

/**
 * @author xiaoy
 *
 */
public class ScannerDemoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// 从键盘接收数据
		int i = 0;
		float f = 0.0f;
		System.out.print("输入整数：");
		if (scan.hasNextInt()) {
			// 判断输入的是否是整数
			i = scan.nextInt();
			// 接收整数
			System.out.println("整数数据：" + i);
		} else {
			// 输入错误的信息
			System.out.println("输入的不是整数！");
		}
		System.out.print("输入小数：");
		if (scan.hasNextFloat()) {
			// 判断输入的是否是小数
			f = scan.nextFloat();
			// 接收小数
			System.out.println("小数数据：" + f);
		} else {
			// 输入错误的信息
			System.out.println("输入的不是小数！");
		}
		scan.close();

		Scanner scannext = new Scanner(System.in);

		double sum = 0;
		int m = 0;

		while (scannext.hasNextDouble()) {
			double x = scannext.nextDouble();
			m = m + 1;
			sum = sum + x;
		}

		System.out.println(m + "个数的和为" + sum);
		System.out.println(m + "个数的平均值是" + (sum / m));
		scannext.close();
	}

}
