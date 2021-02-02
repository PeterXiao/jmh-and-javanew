/**
 * 
 */
package luozix.start.java15.texts;

/**
 * @author xiaoy
 *
 */
public class TextApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String html = """
				<html>
				    <body>
				        <p>Hello, world</p>
				    </body>
				</html>
				""";

		TextUtil.printText(html);

		// Line terminator is required
		// equal to-> var text = ""
		var text = """
				""";

//        var text2 = """"""; // illegal text block start
//        var text3 = """ """; // illegal text block start

		TextUtil.printText(text);

		String html1 = """
				    <html>
				       <body>
				         <p>Hello, world</p>
				       </body>
				    </html>
				""";

		TextUtil.printText(html1);

		String html1lString = """
				<html> \
				   <body> \
				     <p>Hello, world</p> \
				   </body> \
				</html> \
				""";

		TextUtil.printText(html1lString);

		String html1Str = """
				<html>                  \s
				   <body>               \s
				     <p>Hello, world</p>\s
				   </body>              \s
				</html>                 \s
				""";
		TextUtil.printText(html1Str);

		String html1Strings = """
				<html>
				   <body>
				     <p>%s, %s</p>
				   </body>
				</html>
				""";
		html1Strings = html1Strings.formatted("Hello", "world!");

		TextUtil.printText(html1Strings);

	}

}
