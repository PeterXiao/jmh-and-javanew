/**
 * 
 */
package luozix.start.dataalais;

/**
 * @author xiaoy
 *
 */
public class RunoobTest1 implements Cloneable {

	// 声明变量
	String name;
	int likes;

	public static void main(String[] args) {

		// 创建对象
		RunoobTest1 obj1 = new RunoobTest1();

		// 初始化变量
		obj1.name = "Runoob";
		obj1.likes = 111;

		// 打印输出
		System.out.println(obj1.name); // Runoob
		System.out.println(obj1.likes); // 111

		try {

			// 创建 obj1 的拷贝
			RunoobTest1 obj2 = (RunoobTest1) obj1.clone();

			// 使用 obj2 输出变量
			System.out.println(obj2.name); // Runoob
			System.out.println(obj2.likes); // 111
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}