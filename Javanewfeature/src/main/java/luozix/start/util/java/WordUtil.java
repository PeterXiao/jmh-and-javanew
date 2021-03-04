/**
 * Project Name:java11_in_action File Name:WordUtil.java Package Name:luozix.start.util.java
 * Date:2021年3月4日下午3:24:11 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: WordUtil.java @Package luozix.start.util.java @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:24:11
 * @version V1.0
 */
package luozix.start.util.java;
/**
 * ClassName:WordUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:24:11 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: WordUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:24:11
 * @version
 * @since JDK 1.8
 */
public class WordUtil {

  /*
  todo
  字数计算:
  总字数 0
  UTF-8字符数    0
  GBK字符数  0
  x中文字数   0
  x英文字数   0
  x数字字数
  x标点字数   0
  x空白字符数  0
  全角字数
   */

  private WordUtil() throws IllegalAccessException {
    throw new IllegalAccessException("Instantiation is not allowed! Use static methods only!");
  }

  public static long count(String pattern, String text) {
    long count = 0;
    Pattern p = Pattern.compile(pattern);
    Matcher matcher = p.matcher(text);
    while (matcher.find()) {
      count += matcher.group().length();
    }
    return count;
  }

  public static long total(String text) {
    return text.length();
  }

  public static long countChinese(String text) {
    return count(ValidateUtil.PATTERN_CHINESE, text);
  }

  public static long countLatin(String text) {
    return count(ValidateUtil.PATTERN_LETTER, text);
  }

  public static long countDigital(String text) {
    return count(ValidateUtil.PATTERN_DIGITAL, text);
  }

  public static long countSymbol(String text) {
    return count(ValidateUtil.PATTERN_SYMBOL, text);
  }

  public static long countBlank(String text) {
    return count(ValidateUtil.PATTERN_BLANK, text);
  }

  public static ArrayList<String> extract(String pattern, String text) {
    ArrayList<String> result = new ArrayList<>();
    Pattern p = Pattern.compile(pattern);
    Matcher matcher = p.matcher(text);
    while (matcher.find()) {
      result.add(matcher.group());
    }
    return result;
  }

  public static ArrayList<String> extractChinese(String text) {
    return extract(ValidateUtil.PATTERN_CHINESE, text);
  }

  public static ArrayList<String> extractLatin(String text) {
    return extract(ValidateUtil.PATTERN_LETTER, text);
  }

  public static ArrayList<String> extractDigital(String text) {
    return extract(ValidateUtil.PATTERN_DIGITAL, text);
  }

  public static ArrayList<String> extractSymbol(String text) {
    return extract(ValidateUtil.PATTERN_SYMBOL, text);
  }

  public static ArrayList<String> extractBlank(String text) {
    return extract(ValidateUtil.PATTERN_BLANK, text);
  }
}
