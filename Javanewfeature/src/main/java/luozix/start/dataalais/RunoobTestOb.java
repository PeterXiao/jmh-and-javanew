/**
 * 
 */
package luozix.start.dataalais;

import java.util.GregorianCalendar;

/**
 * @author xiaoy
 *
 */
public class RunoobTestOb extends GregorianCalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 创建 RunoobTest 对象
			RunoobTestOb cal = new RunoobTestOb();

			// 输出当前时间
			System.out.println("" + cal.getTime());

			// finalize cal
			System.out.println("Finalizing...");
			cal.finalize();
			System.out.println("Finalized.");

		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

}
