/**
 * 
 */
package luozix.start.action;

/**
 * @author xiaoy
 *
 */
public class DoubleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y是否相等:
        System.out.println(x);
        System.out.println(y);
        
        //type up
        
        int n = 5;
        double d = 1.2 + 24.0 / n; // 6.0
        System.out.println(d);
        
        int n1 = (int) 12.3; // 12
        int n2 = (int) 12.7; // 12
        int n21 = (int) -12.7; // -12
        int n3 = (int) (12.7 + 0.5); // 13
        int n4 = (int) 1.2e20; // 2147483647
        
        double d1 = 2.6;
        int n11 = (int) (d1 + 0.5);
        System.out.println(n11);
	}

//	// 比较x和y是否相等，先计算其差的绝对值:
//	double r = Math.abs(x - y);
//	// 再判断绝对值是否足够小:
//	if (r < 0.00001) {
//	    // 可以认为相等
//	} else {
//	    // 不相等
//	}
}
