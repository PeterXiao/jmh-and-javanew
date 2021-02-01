/**
 * 
 */
package luozix.start.action.cls.enums;

/**
 * @author xiaoy
 * 
 *         内部类中使用枚举
 * 
 *         枚举类也可以声明在内部类中：
 */
public class TestEnum {

	enum Color {
		RED, GREEN, BLUE;
	}
	
	//等价于：

//	  class Color
//{
//     public static final Color RED = new Color();
//     public static final Color BLUE = new Color();
//     public static final Color GREEN = new Color();
//}
//	 

	// 执行输出结果
	public static void main(String[] args) {
		Color c1 = Color.RED;
		System.out.println(c1);

		for (Color myVar : Color.values()) {
			System.out.println(myVar);
		}

		Color myVar = Color.BLUE;

		switch (myVar) {
		case RED:
			System.out.println("红色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		case BLUE:
			System.out.println("蓝色");
			break;
		}

		// 调用 values()
		Color[] arr = Color.values();

		// 迭代枚举
		for (Color col : arr) {
			// 查看索引
			System.out.println(col + " at index " + col.ordinal());
		}

		// 使用 valueOf() 返回枚举常量，不存在的会报错 IllegalArgumentException
		System.out.println(Color.valueOf("RED"));
		// System.out.println(Color.valueOf("WHITE"));
	}

}
