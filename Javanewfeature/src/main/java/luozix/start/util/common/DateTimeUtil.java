/**
 * Project Name:java11_in_action File Name:DateTimeUtil.java Package Name:luozix.start.util.common
 * Date:2021年3月4日下午3:09:44 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: DateTimeUtil.java @Package luozix.start.util.common @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:09:44
 * @version V1.0
 */
package luozix.start.util.common;
/**
 * ClassName:DateTimeUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:09:44 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @ClassName: DateTimeUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:09:44
 * @version
 * @since JDK 1.8
 */
public class DateTimeUtil {

  private static final String PATTERN_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

  /*
  todo
  时间日期格式化
  时间日期转化: ISO, timestamp
  时区
  时间间隔: 自然日, 绝对日
  排序: 小大, 大小
  比较: 小, 相等, 大; 是否在某时间前, 后, 区间
  x闰年判断
   */

  /**
   * Format date according to pattern
   *
   * @param date date
   * @param pattern pattern
   * @return formatted string
   */
  public static String format(Date date, String pattern) {
    return date == null || pattern == null ? null : new SimpleDateFormat(pattern).format(date);
  }

  /**
   * Format calendar according to pattern
   *
   * @param calendar calendar
   * @param pattern pattern
   * @return formatted string
   */
  public static String format(Calendar calendar, String pattern) {
    return format(calendar.getTime(), pattern);
  }

  /**
   * Format timestamp according to pattern
   *
   * @param timestamp millisec
   * @param pattern pattern
   * @return formatted string
   */
  public static String format(long timestamp, String pattern) {
    return format(new Date(timestamp), pattern);
  }

  /**
   * Parse string to date according to pattern
   *
   * @param text text to be parsed
   * @param pattern pattern
   * @return Date
   */
  public static Date parseDate(String text, String pattern) {
    try {
      return new SimpleDateFormat(pattern).parse(text);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Date parseDate(String isoDateString) {
    return parseDate(isoDateString, PATTERN_ISO8601);
  }

  public static Calendar parseCalendar(String isoDateString) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(parseDate(isoDateString));
    return calendar;
  }

  public static long parseTimestamp(String isoDateString) {
    return parseDate(isoDateString).getTime();
  }

  public static String parseIso(Date date) {
    return format(date, PATTERN_ISO8601);
  }

  public static String parseIso(Calendar calendar) {
    return parseIso(calendar.getTime());
  }

  public static String parseIso(long timestamp) {
    return parseIso(new Date(timestamp));
  }

  /**
   * Compare two date
   *
   * @param first first date
   * @param second second date
   * @return Positive number if second later than first; Negtive number if second earlier than
   *     first; 0 if they are equal
   */
  public static long compare(Date first, Date second) {
    return second.getTime() - first.getTime();
  }

  public static long compare(Calendar first, Calendar second) {
    return second.getTimeInMillis() - first.getTimeInMillis();
  }

  public static long compare(long first, long second) {
    return second - first;
  }

  public static long compare(Date first, Calendar second) {
    return second.getTimeInMillis() - first.getTime();
  }

  public static long compare(Date first, long second) {
    return second - first.getTime();
  }

  public static long compare(Calendar first, Date second) {
    return second.getTime() - first.getTimeInMillis();
  }

  public static long compare(Calendar first, long second) {
    return second - first.getTimeInMillis();
  }

  public static long compare(long first, Date second) {
    return second.getTime() - first;
  }

  public static long compare(long first, Calendar second) {
    return second.getTimeInMillis() - first;
  }

  /**
   * return if a year is leap year
   *
   * @param year year to be examined
   * @return true if it's leap year; Otherwise false
   */
  public static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }
}
