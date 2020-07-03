/**
 *
 */
package basics.Strings;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * @author Office
 *
 */
public class TestBytetoInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = -128;
		int i1 = b & 0xff;
		int i2 = b;
		System.out.println(i1); //128
		System.out.println(i2); //-128
		System.out.println(Integer.toBinaryString(i1)); //10000000
		System.out.println(Integer.toBinaryString(i2)); //11111111111111111111111110000000
	    Instant result = DateTimeFormatter.RFC_1123_DATE_TIME
	            .parse("Sat, 29 Sep 2018 20:49:02 GMT", Instant::from);
	    System.out.println("Result: " + result);

	 // These two have the same value
	 //   new String("test").equals("test") // --> true

	    // ... but they are not the same object
	   // new String("test") == "test" // --> false

	    // ... neither are these
	// new String("test") == new String("test"); // --> false

	    // ... but these are because literals are interned by
	    // the compiler and thus refer to the same object
	   // "test" == "test" // --> true

	    // ... string literals are concatenated by the compiler
	    // and the results are interned.
	  //  "test" == "te" + "st" // --> true

	    // ... but you should really just call Objects.equals()
	 //   Objects.equals("test", new String("test")) // --> true
	 //   Objects.equals(null, "test") // --> false
	 //   Objects.equals(null, null) // --> true
	}

}
