/**
 *
 */
package one;

import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author LiY
 * @time 下午10:42:35
 */
public class Test {

	public static void main(String[] args) {
		final OneClass c = new OneClass();
		System.out.println(c.getClass().getName());
		// 空列表，数据类型为 Object
		final List immutableList = List.of();

		// 创建 List<String>
		final var foo = List.of("biezhi", "github", "技术小黑屋");

		// 空 Map，Key 和 Value 类型都是 Object
		final Map emptyImmutableMap = Map.of();

		// 快速创建一个 Map
		final var mmp = Map.of(2017, "先赚他一个亿", 2018, "去年的梦想可能有点儿夸张");

		// 使用 Entries 创建一个 Map
		final Map<Integer, String> emptyEntryMap = Map.ofEntries(entry(20, "装逼"), entry(30, "单身"), entry(40, "回家种地"));

		// 创建一个 Map.Entry
		final Map.Entry<String, String> immutableMapEntry = Map.entry("biezhi", "emmmm");
		// 其实和上面的代码片段是一样一样的
		Map.ofEntries(immutableMapEntry);

		// 创建一个空 Set<String>
		final Set<String> immutableSet = Set.of();

		// 快速创建一个 Set<String>
		final Set<String> bar = Set.of("我", "可能", "是个", "假的", "程序员");

//      writeHeader("User-Agent\tMozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5)");
//      demonstrateStringLines();
//      demonstrateStringStrip();
//      demonstrateStringStripLeading();
//      demonstrateStringStripTrailing();
//      demonstrateStringIsBlank();
		lines();
	}

	/**
	 * Write provided {@code String} in header. Note that this implementation uses
	 * {@code String.repeat(int)}.
	 *
	 * @param headerText Title of header.
	 */
	private static void writeHeader(final String headerText) {
		final String headerSeparator = "=".repeat(headerText.length() + 4);

		System.out.println("\n" + headerSeparator);
		System.out.println(headerText);
		System.out.println(headerSeparator);
	}

	/**
	 * Demonstrate method {@code String.lines()} added with JDK 11.
	 */
	public static void demonstrateStringLines() {
		final String originalString = "Hello\nWorld\n123";

		final String stringWithoutLineSeparators = originalString.replaceAll("\\n", "\\\\n");

		writeHeader("String.lines() on '" + stringWithoutLineSeparators + "'");

		originalString.lines().forEach(System.out::println);
	}

	/**
	 * Demonstrate method {@code String.strip()} added with JDK 11.
	 */
	public static void demonstrateStringStrip() {
		final String originalString = "  biezhi.me  23333  ";

		writeHeader("String.strip() on '" + originalString + "'");
		System.out.println("'" + originalString.strip() + "'");
	}

	/**
	 * Demonstrate method {@code String.stripLeading()} added with JDK 11.
	 */
	public static void demonstrateStringStripLeading() {
		final String originalString = "  biezhi.me  23333  ";

		writeHeader("String.stripLeading() on '" + originalString + "'");
		System.out.println("'" + originalString.stripLeading() + "'");
	}

	/**
	 * Demonstrate method {@code String.stripTrailing()} added with JDK 11.
	 */
	public static void demonstrateStringStripTrailing() {
		final String originalString = "  biezhi.me  23333  ";

		writeHeader("String.stripTrailing() on '" + originalString + "'");
		System.out.println("'" + originalString.stripTrailing() + "'");
	}

	/**
	 * Demonstrate method {@code String.isBlank()} added with JDK 11.
	 */
	public static void demonstrateStringIsBlank() {
		writeHeader("String.isBlank()");

		final String emptyString = "";
		System.out.println("空字符串    -> " + emptyString.isBlank());

		final String onlyLineSeparator = System.getProperty("line.separator");
		System.out.println("换行符     -> " + onlyLineSeparator.isBlank());

		final String tabOnly = "\t";
		System.out.println("Tab 制表符 -> " + tabOnly.isBlank());

		final String spacesOnly = "   ";
		System.out.println("空格       -> " + spacesOnly.isBlank());
	}

	public static void lines() {
		writeHeader("String.lines()");

		final String str = "Hello \n World, I,m\nbiezhi.";

		System.out.println(str.lines().collect(Collectors.toList()));
	}

}
