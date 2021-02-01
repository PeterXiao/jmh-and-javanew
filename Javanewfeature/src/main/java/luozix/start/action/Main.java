/**
 * 
 */
package luozix.start.action;

import org.junit.jupiter.api.Test;

/**
 * @author xiaoy
 *
 *
 *基本数据类型
基本数据类型是CPU可以直接进行运算的类型。Java定义了以下几种基本数据类型：
Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
整数类型：byte，short，int，long

浮点数类型：float，double

字符类型：char

布尔类型：boolean
 *
 *
 *
Java修饰符
像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：

*访问控制修饰符 : default, public , protected, private
*非访问控制修饰符 : final, abstract, static, synchronized

 Java 变量
Java 中主要有如下几种类型的变量
*局部变量
*类变量（静态变量）
*成员变量（非静态变量）
*
*
 Java 数组
数组是储存在堆上的对象，可以保存多个同类型变量。
 
Java 枚举
Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的 bug。
 
 *
 */
public class Main {

	
	    static boolean bool;
	    static byte by;
	    static char ch;
	    static double d;
	    static float f;
	    static int i;
	    static long l;
	    static short sh;
	    static String str;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello,World!");
		
		int xxx = 1;
		
        System.out.println(xxx);
        
         xxx = 100;
        
        System.out.println(xxx);
        
        
        int n = 100; // 定义变量n，同时赋值为100
        System.out.println("n = " + n); // 打印n的值

        n = 200; // 变量n赋值为200
        System.out.println("n = " + n); // 打印n的值

        int x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
        System.out.println("x = " + x); // 打印x的值

        x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
        System.out.println("x = " + x); // 打印x的值
        System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？
        
        
        char a = 'A';
        char zh = '中';
        System.out.println(a);
        System.out.println(zh);        
   //  常量
        final double PI = 3.14; // PI是一个常量
        double r = 5.0;
        double area = PI * r * r;
      //  PI = 300; // compile error!
        
        var sb = new StringBuilder();
        
        System.out.println("Bool :" + bool);
        System.out.println("Byte :" + by);
        System.out.println("Character:" + ch);
        System.out.println("Double :" + d);
        System.out.println("Float :" + f);
        System.out.println("Integer :" + i);
        System.out.println("Long :" + l);
        System.out.println("Short :" + sh);
        System.out.println("String :" + str);

	}

	// transient 修饰符
//	序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。
//	该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。

	public transient int limit = 55; // 不会持久化
	public int b; // 持久化

	@Test
	 public void inteSub() {
        int i = 2147483647;
        int i2 = -2147483648;
        int i3 = 2_000_000_000; // 加下划线更容易识别
        int i4 = 0xff0000; // 十六进制表示的16711680
        int i5 = 0b1000000000; // 二进制表示的512
        long l = 9000000000000000000L; // long型的结尾需要加L
        
        float f1 = 3.14f;
        float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
        double d = 1.79e308;
        double d2 = -1.79e308;
        double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324
        
        boolean b1 = true;
        boolean b2 = false;
        boolean isGreater = 5 > 3; // 计算结果为true
        int age = 12;
        boolean isAdult = age >= 18; // 计算结果为false
                
           
	}
	
	@Test
	public void intAlg() {
        int i = (100 + 200) * (99 - 88); // 3300
        int n = 7 * (5 + (i - 9)); // 23072
        System.out.println(i);
        System.out.println(n);
        
        //溢出
        int x = 2147483640;
        int y = 15;
        int sum = x + y;
        System.out.println(sum); // -2147483641
        
        long xL = 2147483640;
        long yL = 15;
        long sumL = xL + yL;
        System.out.println(sumL); // 2147483655
        
        
        //++ -- 自增 自减
        
        int n1 = 3300;
        n1++; // 3301, 相当于 n = n + 1;
        n1--; // 3300, 相当于 n = n - 1;
        int y1 = 100 + (++n1); // 不要这么写
        System.out.println(y1);
	}
	
	@Test
	public void intMove() {
		int n = 7;       // 00000000 00000000 00000000 00000111 = 7
		int a = n << 1;  // 00000000 00000000 00000000 00001110 = 14
		int b = n << 2;  // 00000000 00000000 00000000 00011100 = 28
		int c = n << 28; // 01110000 00000000 00000000 00000000 = 1879048192
		int d = n << 29; // 11100000 00000000 00000000 00000000 = -536870912
		//如果对一个负数进行右移，最高位的1不动，结果仍然是一个负数：
//		int n = -536870912;
//		int a = n >> 1;  // 11110000 00000000 00000000 00000000 = -268435456
//		int b = n >> 2;  // 11111000 00000000 00000000 00000000 = -134217728
//		int c = n >> 28; // 11111111 11111111 11111111 11111110 = -2
//		int d = n >> 29; // 11111111 11111111 11111111 11111111 = -1
		
		
		//使用>>>，它的特点是不管符号位，右移后高位总是补0，因此，对一个负数进行>>>右移，它会变成正数，原因是最高位的1变成了0：
		int n1 = -536870912;
		int a1 = n1 >>> 1;  // 01110000 00000000 00000000 00000000 = 1879048192
		int b1 = n1 >>> 2;  // 00111000 00000000 00000000 00000000 = 939524096
		int c1 = n1 >>> 29; // 00000000 00000000 00000000 00000111 = 7
		int d1 = n1 >>> 31; // 00000000 00000000 00000000 00000001 = 1
		
//		对byte和short类型进行移位时，会首先转换为int再进行位移。
//
//		仔细观察可发现，左移实际上就是不断地×2，右移实际上就是不断地÷2。
	}
	

}

/*
 * 
 * 变量的作用范围
 * if (...) { // if开始
    ...
    while (...) { while 开始
        ...
        if (...) { // if开始
            ...
        } // if结束
        ...
    } // while结束
    ...
} // if结束

{
    ...
    int i = 0; // 变量i从这里开始定义
    ...
    {
        ...
        int x = 1; // 变量x从这里开始定义
        ...
        {
            ...
            String s = "hello"; // 变量s从这里开始定义
            ...
        } // 变量s作用域到此结束
        ...
        // 注意，这是一个新的变量s，它和上面的变量同名，
        // 但是因为作用域不同，它们是两个不同的变量:
        String s = "hi";
        ...
    } // 变量x和s作用域到此结束
    ...
 * 
 * 
 * 
 * 
 */
