/**
 * 
 */
package luozix.start.action.whiledo;

/**
 * @author xiaoy
 *
 */
public class TestFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [] numbers = {10, 20, 30, 40, 50};
		 
	      for(int x : numbers ){
	         System.out.print( x );
	         System.out.print(",");
	      }
	      System.out.print("\n");
	      String [] names ={"James", "Larry", "Tom", "Lacy"};
	      for( String name : names ) {
	         System.out.print( name );
	         System.out.print(",");
	      }

			int[] numbersl = { 10, 20, 30, 40, 50 };

			for (int x : numbersl) {
				// x 等于 30 时跳出循环
				if (x == 30) {
					break;
				}
				System.out.print(x);
				System.out.print("\n");
			}

			for (int x : numbers) {
				if (x == 30) {
					continue;
				}
				System.out.print(x);
				System.out.print("\n");
			}

	}

}

/*
 * break 关键字 break 主要用在循环语句或者 switch 语句中，用来跳出整个语句块。
 * 
 * break 跳出最里层的循环，并且继续执行该循环下面的语句。
 * 
 * 语法 break 的用法很简单，就是循环结构中的一条语句：
 */

/*
 * continue 关键字 continue 适用于任何循环控制结构中。作用是让程序立刻跳转到下一次循环的迭代。
 * 
 * 在 for 循环中，continue 语句使程序立即跳转到更新语句。
 * 
 * 在 while 或者 do…while 循环中，程序立即跳转到布尔表达式的判断语句。
 */