/**
 * 
 */
package luozix.start.dataalais;

import java.util.ArrayList;

/**
 * @author xiaoy
 *
 */
public class ObjectGetcls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// getClass() with Object
		Object obj1 = new Object();
		System.out.println("obj1 的类为: " + obj1.getClass());

		// getClass() with String
		String obj2 = new String();
		System.out.println("obj2 的类为: " + obj2.getClass());

		// getClass() with ArrayList
		ArrayList<Integer> obj3 = new ArrayList<>();
		System.out.println("obj3 的类为: " + obj3.getClass());
		// 创建 RunoobTest 类的对象
		RunoobTest obj = new RunoobTest();

		// RunoobTest 继承 Object 类，Object 是所有类的超类
		// 调用 getClass() 方法
		System.out.println(obj.getClass());

		Object obj31 = new Object();
		System.out.println(obj31.toString());

		// toString() with array
		// 创建数组
		String[] array = { "Google", "Runoob", "Taobao" };
		System.out.println(array.toString());

		// 数组元素值返回一个字符串的表示形式
		// Array 继承了 Object 类，所以可以直接使用 toString() 方法
		System.out.println(array[1].toString()); // Runoob
	}

}
