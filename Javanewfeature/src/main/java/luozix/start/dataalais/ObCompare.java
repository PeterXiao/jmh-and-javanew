/**
 * 
 */
package luozix.start.dataalais;

/**
 * @author xiaoy
 *
 */
public class ObCompare {
	public static void main(String[] args) {

		// Object 类使用 equals() 方法
		// 创建两个对象
		Object obj1 = new Object();
		Object obj2 = new Object();

		// 判断 obj1 与 obj2 是否相等
		// 不同对象，内存地址不同，不相等，返回 false
		System.out.println(obj1.equals(obj2)); // false

		// obj1 赋值给 obj3
		// String 重写了 equals() 方法
		// 对象引用，内存地址相同，相等，返回 true
		Object obj3 = obj1;
		System.out.println(obj1.equals(obj3)); // true

		// String 类使用 equals() 方法
		// 创建两个对象
		String obj11 = new String();
		String obj21 = new String();

		// 判断 obj1 与 obj2 是否相等
		// 初始化的两个对象都为 null，所以是相等，返回 true
		System.out.println(obj11.equals(obj21)); // true

		// 给对象赋值
		obj11 = "Runoob";
		obj21 = "Google";

		// 判断 obj1 与 obj2 是否相等
		// 两个值不同，内存地址也不同，所以不相等，返回 false
		System.out.println(obj11.equals(obj21)); // false

	}
}
