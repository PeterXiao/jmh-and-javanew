/**
 * 
 */
package luozix.start.java12;

/**
 * @author xiaoy
 *
 */
import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatExample {
	public static void main(String[] args) {
		NumberFormat followers = NumberFormat.getCompactNumberInstance(new Locale("en", "US"),
				NumberFormat.Style.SHORT);
		followers.setMaximumFractionDigits(1);
		System.out.println(followers.format(5412) + " followers");
	}
}
