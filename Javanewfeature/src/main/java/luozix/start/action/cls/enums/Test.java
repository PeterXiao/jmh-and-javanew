/**
 * 
 */
package luozix.start.action.cls.enums;

/**
 * @author xiaoy
 *
 */
enum Color {
	RED, GREEN, BLUE;

	// 构造函数
	private Color() {
		System.out.println("Constructor called for : " + this.toString());
	}

	public void colorInfo() {
		System.out.println("Universal Color");
	}
}

public class Test {
	// 输出
	public static void main(String[] args) {
		Color c1 = Color.RED;
		System.out.println(c1);
		c1.colorInfo();
	}
}

//枚举类成员
//枚举跟普通类一样可以用自己的变量、方法和构造函数，构造函数只能使用 private 访问修饰符，所以外部无法调用。
//
//枚举既可以包含具体方法，也可以包含抽象方法。 如果枚举类具有抽象方法，则枚举类的每个实例都必须实现它。