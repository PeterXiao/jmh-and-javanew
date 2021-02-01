/**
 * 
 */
package luozix.start.dataalais;

import java.util.ArrayList;

/**
 * @author xiaoy
 *
 */
public class Objecthashcode {
	public static void main(String[] args) {

		// Object 使用 hashCode()
		Object obj1 = new Object();
		System.out.println(obj1.hashCode());

		Object obj2 = new Object();
		System.out.println(obj2.hashCode());

		Object obj3 = new Object();
		System.out.println(obj3.hashCode());

		// String 使用 hashCode()
		String str = new String();
		System.out.println(str.hashCode()); // 0

		// ArrayList 使用 hashCode()
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list.hashCode()); // 1

		// Object 使用 hashCode()
		Object obj11 = new Object();

		// obj1 赋值给 obj2
		Object obj21 = obj11;

		// 判断两个对象是否相等
		System.out.println(obj11.equals(obj21)); // true

		// 获取 obj1 与 obj2 的哈希值
		System.out.println(obj11.hashCode()); // 225534817
		System.out.println(obj21.hashCode()); // 225534817

	}
}
