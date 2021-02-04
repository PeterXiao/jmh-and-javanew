/**
 * 
 */
package luozix.start.exams;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoy
 *
 */

/**
 * Function: 判断一个数字是否为快乐数字 19 就是快乐数字 11就不是快乐数字 19 1*1+9*9=82 8*8+2*2=68
 * 6*6+8*8=100 1*1+0*0+0*0=1
 *
 * 11 1*1+1*1=2 2*2=4 4*4=16 1*1+6*6=37 3*3+7*7=58 5*5+8*8=89 8*8+9*9=145
 * 1*1+4*4+5*5=42 4*4+2*2=20 2*2+0*0=2
 *
 * 这里结果 1*1+1*1=2 和 2*2+0*0=2 重复，所以不是快乐数字
 */
public class HappyNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 345;
		int i = num % 10;
		int i1 = num / 10;
		int i2 = i1 / 10;
		System.out.println(i);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(isHappy(num));
	}

	/**
	 * 判断一个数字是否为快乐数字
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isHappy(int number) {// • 快乐数字
		Set<Integer> set = new HashSet<>(30);
		while (number != 1) {
			int sum = 0;
			while (number > 0) {
				// 计算当前值的每位数的平方 相加的和 在放入set中，如果存在相同的就认为不是 happy数字
				sum += (number % 10) * (number % 10);
				number = number / 10;
			}
			if (set.contains(sum)) {
				return false;
			} else {
				set.add(sum);
			}
			number = sum;
		}
		return true;
	}
}
