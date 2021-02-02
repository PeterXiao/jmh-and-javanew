/**
 * 
 */
package luozix.start.java15.instanceofs;

/**
 * @author xiaoy
 *
 */
public class InstanceOfApp {
	public static void main(String[] args) {

		Object obj = "Hello world!";

		// before
		if (obj instanceof String) {
			String s = (String) obj;
			System.out.println("String: " + s);
		}

		// after
		if (obj instanceof String s) {
			System.out.println("String: " + s);
		}

		Object objL = "Hello world!";

		// legal usage
		if (objL instanceof String s && !s.isBlank()) {
			System.out.println("String: " + s);
		}

		// cannot resolve symbol 's'
//        if (obj instanceof String s || !s.isBlank()) {
//            System.out.println("String: " + s);
//        }

	}
}
