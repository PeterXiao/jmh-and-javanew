/**
 * 
 */
package luozix.start.java15.texts;

public class TextUtil {

	public static void printText(String string) {
		string = string.replaceAll(" ", "•");
		string = string.replaceAll("\n", "⏎\n");
		string = string.trim();
		System.out.println(string.isBlank() ? "Blank" : string);
	}

}
