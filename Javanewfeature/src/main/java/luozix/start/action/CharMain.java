/**
 * 
 */
package luozix.start.action;

/**
 * @author xiaoy
 *
 */
public class CharMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 字符类型char是基本数据类型，它是character的缩写。一个char保存一个Unicode字符：
		char c1 = 'A';
		char c2 = '中';
		int n1 = 'A'; // 字母“A”的Unicodde编码是65
		int n2 = '中'; // 汉字“中”的Unicode编码是20013
		// 注意是十六进制:
		char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
		char c4 = '\u4e2d'; // '中'，因为十六进制4e2d = 十进制20013
		
		
		//字符串类型String是引用类型，我们用双引号"..."表示字符串。一个字符串可以存储0个到任意个字符
		String s = ""; // 空字符串，包含0个字符
		String s1 = "A"; // 包含一个字符
		String s2 = "ABC"; // 包含3个字符
		String s3 = "中文 ABC"; // 包含6个字符，其中有一个空格
		
		//转义字符\
		 s = "abc\"xyz"; // 包含7个字符: a, b, c, ", x, y, z
		 s = "abc\\xyz"; // 包含7个字符: a, b, c, \, x, y, z
		 s = "ABC\n\u4e2d\u6587"; // 包含6个字符: A, B, C, 换行符, 中, 文
		 
		 
	        String s11 = "Hello";
	        String s21 = "world";
	        String s1send= s11 + " " + s21 + "!";
	        System.out.println(s1send);	 
	        
	        int age = 25;
	        String sin = "age is " + age;
	        System.out.println(sin);
	        
	        String slines = "first line \n"
	                + "second line \n"
	                + "end";
	        
	        if(1>0) {
	            String sif = "hello";
	            String t = sif;
	            sif = "world";
	            System.out.println(t); // t是"hello"
	        }
	        
	        // 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
	        int a = 72;
	        int b = 105;
	        int c = 65281;
	        // FIXME:
	        String ss = "" + (char) a + (char) b + (char) c;
	        
	        System.out.println(ss);
	        
	}

}
/*


常见的转义字符包括：

\" 表示字符"
\' 表示字符'
\\ 表示字符\
\n 表示换行符
\r 表示回车符
\t 表示Tab
\\u#### 表示一个Unicode编码的字符 只有一个\


从Java 13开始，字符串可以用"""..."""表示多行字符串（Text Blocks）

        String s = """
                   SELECT * FROM
                     users
                   WHERE id > 100
                   ORDER BY name DESC
                   """;
        System.out.println(s);
*/