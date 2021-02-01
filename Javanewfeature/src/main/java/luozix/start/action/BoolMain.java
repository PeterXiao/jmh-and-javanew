/**
 * 
 */
package luozix.start.action;

/**
 * @author xiaoy
 *
 */
public class BoolMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isGreater = 5 > 3; // true
		int age = 12;
		boolean isZero = age == 0; // false
		boolean isNonZero = !isZero; // true
		boolean isAdult = age >= 18; // false
		boolean isTeenager = age >6 && age <18; // true
		//布尔运算的一个重要特点是短路运算。如果一个布尔运算的表达式能提前确定结果，则后续的计算不再执行，直接返回结果。
        boolean b = 5 < 3;
        boolean result = b && (5 / 0 > 0);
        System.out.println(result);
        b = 5 > 3;
//        result = b && (5 / 0 > 0);
        
   //Java还提供一个三元运算符b ? x : y，它根据第一个布尔表达式的结果，分别返回后续两个表达式之一的计算结果。     
        int n = -100;
        int x = n >= 0 ? n : -n;
        System.out.println(x);
        
        int agel = 7;
        // primary student的定义: 6~12岁
        boolean isPrimaryStudent =(agel>=6)&&(agel<12);
        System.out.println(isPrimaryStudent ? "Yes" : "No");
	}

}
/*
 * 
 * 对于布尔类型boolean，永远只有true和false两个值。

布尔运算是一种关系运算，包括以下几类：

比较运算符：>，>=，<，<=，==，!=
与运算 &&
或运算 ||
非运算 !
 */