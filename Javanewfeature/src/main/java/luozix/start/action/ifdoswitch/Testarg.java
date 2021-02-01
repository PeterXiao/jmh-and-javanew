/**
 * 
 */
package luozix.start.action.ifdoswitch;

/**
 * @author xiaoy
 *
 */
public class Testarg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		default:
			System.out.println("default");
		}
		
		System.out.println("=============");
		i = 1;
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		default:
			System.out.println("default");
		}

		System.out.println("=============");
		i = 1;
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		case 3:
			System.out.println("3");
			break;
		default:
			System.out.println("default");
		}
	}

}
