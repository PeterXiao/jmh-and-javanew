/**
 * 
 */
package luozix.start.action;

/**
 * @author xiaoy
 *
 */
public class AlgMv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//位运算是按位进行与、或、非和异或的运算。

//与运算的规则是，必须两个数同时为1，结果才为1：
		int n =0;
		n = 0 & 0; // 0
		n = 0 & 1; // 0
		n = 1 & 0; // 0
		n = 1 & 1; // 1
	//或运算的规则是，只要任意一个为1，结果就为1：	
		n = 0 | 0; // 0
		n = 0 | 1; // 1
		n = 1 | 0; // 1
		n = 1 | 1; // 1
	//	非运算的规则是，0和1互换：	
		n = ~0; // 1
		n = ~1; // 0
	//异或运算的规则是，如果两个数不同，结果为1，否则为0：	
		n = 0 ^ 0; // 0
		n = 0 ^ 1; // 1
		n = 1 ^ 0; // 1
		n = 1 ^ 1; // 0
		
	//对两个整数进行位运算，实际上就是按位对齐，然后依次对每一位进行运算。	
        int i = 167776589; // 00001010 00000000 00010001 01001101
         n = 167776512; // 00001010 00000000 00010001 00000000
        System.out.println(i & n); // 167776512
		
	}

	/** 返回两个整型变量数据的较大值 */
	public static int max(int num1, int num2) {
		int result;
		if (num1 > num2)
			result = num1;
		else
			result = num2;

		return result;
	}

	public static int thrmax(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}
}
/*
运算优先级
在Java的计算表达式中，运算优先级从高到低依次是：

()
! ~ ++ --
* / %
+ -
<< >> >>>
&
|
+= -= *= /=
记不住也没关系，只需要加括号就可以保证运算的优先级正确。

*/