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
        
        
	}

}
