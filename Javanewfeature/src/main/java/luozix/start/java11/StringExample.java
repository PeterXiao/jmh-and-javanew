    /** 
	 * Project Name:java11_in_action 
	 * File Name:StringExample.java 
	 * Package Name:luozix.start.java11 
	 * Date:2021年3月2日下午6:28:38 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: StringExample.java
* @Package luozix.start.java11
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:28:38
* @version V1.0  
*/  
	  
	package luozix.start.java11;

import java.util.stream.Collectors;

/**
 * ClassName:StringExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:28:38 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: StringExample @Description: TODO(这里用一句话描述这个类的作用)
 *
 * <p>* String.repeat(int)
 *
 * <p>String.lines()
 *
 * <p>String.strip()
 *
 * <p>String.stripLeading()
 *
 * <p>String.stripTrailing()
 *
 * <p>String.isBlank()
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午6:28:38
 * @version
 * @since JDK 1.8
 */
public class StringExample {

  /**
   * Write provided {@code String} in header. Note that this implementation uses {@code
   * String.repeat(int)}.
   *
   * @param headerText Title of header.
   */
  private static void writeHeader(final String headerText) {
    final String headerSeparator = "=".repeat(headerText.length() + 4);

    System.out.println("\n" + headerSeparator);
    System.out.println(headerText);
    System.out.println(headerSeparator);
  }

  /** Demonstrate method {@code String.lines()} added with JDK 11. */
  public static void demonstrateStringLines() {
    String originalString = "Hello\nWorld\n123";

    String stringWithoutLineSeparators = originalString.replaceAll("\\n", "\\\\n");

    writeHeader("String.lines() on '" + stringWithoutLineSeparators + "'");

    originalString.lines().forEach(System.out::println);
  }

  /** Demonstrate method {@code String.strip()} added with JDK 11. */
  public static void demonstrateStringStrip() {
    String originalString = "  biezhi.me  23333  ";

    writeHeader("String.strip() on '" + originalString + "'");
    System.out.println("'" + originalString.strip() + "'");
  }

  /** Demonstrate method {@code String.stripLeading()} added with JDK 11. */
  public static void demonstrateStringStripLeading() {
    String originalString = "  biezhi.me  23333  ";

    writeHeader("String.stripLeading() on '" + originalString + "'");
    System.out.println("'" + originalString.stripLeading() + "'");
  }

  /** Demonstrate method {@code String.stripTrailing()} added with JDK 11. */
  public static void demonstrateStringStripTrailing() {
    String originalString = "  biezhi.me  23333  ";

    writeHeader("String.stripTrailing() on '" + originalString + "'");
    System.out.println("'" + originalString.stripTrailing() + "'");
  }

  /** Demonstrate method {@code String.isBlank()} added with JDK 11. */
  public static void demonstrateStringIsBlank() {
    writeHeader("String.isBlank()");

    String emptyString = "";
    System.out.println("空字符串    -> " + emptyString.isBlank());

    String onlyLineSeparator = System.getProperty("line.separator");
    System.out.println("换行符     -> " + onlyLineSeparator.isBlank());

    String tabOnly = "\t";
    System.out.println("Tab 制表符 -> " + tabOnly.isBlank());

    String spacesOnly = "   ";
    System.out.println("空格       -> " + spacesOnly.isBlank());
  }

  public static void lines() {
    writeHeader("String.lines()");

    String str = "Hello \n World, I,m\nLuozi.";

    System.out.println(str.lines().collect(Collectors.toList()));
  }

  /**
  * @Title: main
  * @Description: TODO(这里用一句话描述这个方法的作用)
  * @param @param args    设定文件
  * @return void    返回类型
  * date: 2021年3月2日 下午6:28:38.<br/>
  * @author xiaoy 
  * @param args 
  *@since JDK 1.8
  * @throws
  */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    //    writeHeader("User-Agent\tMozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5)");
    //    demonstrateStringLines();
    //    demonstrateStringStrip();
    //    demonstrateStringStripLeading();
    //    demonstrateStringStripTrailing();
    //    demonstrateStringIsBlank();
    lines();
  }

}
