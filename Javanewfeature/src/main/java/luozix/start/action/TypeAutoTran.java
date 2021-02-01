/**
 * 
 */
package luozix.start.action;

/**
 * @author xiaoy
 *
 */
public class TypeAutoTran {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        short s = 1234;
        int i = 123456;
        int x = s + i; // s自动转型为int
        //short y = s + i; // 编译错误!
        
        //强制转换
        int i1 = 1234567;
        short s1 = (short) i1; // -10617
        System.out.println(s1);
        int i2 = 12345678;
        short s2 = (short) i2; // 24910
        System.out.println(s2);
        
        
		//
		int a, b, c; // 声明三个int型整数：a、 b、c
		int d = 3, e = 4, f = 5; // 声明三个整数并赋予初值
		byte z = 22; // 声明并初始化 z
		String s11 = "runoob"; // 声明并初始化字符串 s
		double pi = 3.14159; // 声明了双精度浮点型变量 pi
		char x1 = 'x'; // 声明变量 x 的值是字符 'x'。

		TypeAutoTran test = new TypeAutoTran();
		TypeAutoTran.pupAge();
	}

	public static void pupAge() {
		int age = 0;
		age = age + 7;
		System.out.println("小狗的年龄是: " + age);
	}
}
/*
 * 
 * 
 * Java语言支持的变量类型有：
 * 
 * 类变量：独立于方法之外的变量，用 static 修饰。 实例变量：独立于方法之外的变量，不过没有 static 修饰。 局部变量：类的方法中的变量。
 *
 * Java 局部变量
 * 
 * 局部变量声明在方法、构造方法或者语句块中；
 * 
 * 局部变量在方法、构造方法、或者语句块被执行的时候创建，当它们执行完成后，变量将会被销毁；
 * 
 * 访问修饰符不能用于局部变量；
 * 
 * 局部变量只在声明它的方法、构造方法或者语句块中可见；
 * 
 * 局部变量是在栈上分配的。
 * 
 * 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。
 *
 *
 */