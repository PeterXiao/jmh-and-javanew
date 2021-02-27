/**
 * 
 */
package luozix.start.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author xiaoy
 *
 */

public class UrlEncoderExample {

	public static void main(String[] args) {

		String url = "http://github.com/wesleyegberto";

		String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8));
		System.out.println("encodedUrl = " + encodedUrl);

		final String text = "Base64 finally in Java 8!";
		final String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);
		final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
		System.out.println(decoded);
	}

}
