/**
 * 
 */
package luozix.start.action;

/**
 * @author xiaoy
 *
 */
public class ArrayMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        // 5位同学的成绩:
        int n1 = 68;
        int n2 = 79;
        int n3 = 91;
        int n4 = 85;
        int n5 = 62;
        
        // 5位同学的成绩:
        int[] ns = new int[5];
        ns[0] = 68;
        ns[1] = 79;
        ns[2] = 91;
        ns[3] = 85;
        ns[4] = 62;
        
        int[] ns1 = new int[5];
        System.out.println(ns1.length); // 5
        
        int n = 5;
        //System.out.println(ns[n]); // 索引n不能超出范围
        
        int[] nnsls = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(nnsls.length); // 编译器自动推算数组大小为5
        //注意数组是引用类型，并且数组大小不可变。
        // 5位同学的成绩:
        int[] ns11;
        ns11 = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(ns11.length); // 5
        ns11 = new int[] { 1, 2, 3 };
        System.out.println(ns11.length); // 3
        
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?

	}

}
