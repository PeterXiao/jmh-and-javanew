/**
 * Project Name:java11_in_action File Name:RadixUtil.java Package Name:luozix.start.util.java
 * Date:2021年3月4日下午3:19:17 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: RadixUtil.java @Package luozix.start.util.java @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:19:17
 * @version V1.0
 */
package luozix.start.util.java;
/**
 * ClassName:RadixUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:19:17 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: RadixUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:19:17
 * @version
 * @since JDK 1.8
 */
public class RadixUtil {
  /*
  todo
  进制工具
  二进制, 八进制, 十进制, 十六进制, 自定义进制互转
  字符串转十六进制
   */

  private static final char[] HEX_ARR_UPPER = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
  };
  private static final char[] HEX_ARR_LOWER = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
  };

  private RadixUtil() throws IllegalAccessException {
    throw new IllegalAccessException("Instantiation is not allowed! Use static methods only!");
  }

  public static String toBinaryString(int integer) {
    return Integer.toBinaryString(integer);
  }

  public static String toOctalString(int integer) {
    return Integer.toOctalString(integer);
  }

  public static String toHexString(int integer) {
    return Integer.toHexString(integer);
  }

  public static String toHexString(float floatNumber) {
    return Float.toHexString(floatNumber);
  }

  public static String toHexString(double doubleNumber) {
    return Double.toHexString(doubleNumber);
  }

  public static StringBuffer toHex(byte b) {
    StringBuffer stringBuffer = new StringBuffer();
    //        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
    //                '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    int high = ((b & 0xf0) >> 4);
    int low = (b & 0x0f);
    stringBuffer.append(HEX_ARR_UPPER[high]);
    stringBuffer.append(HEX_ARR_UPPER[low]);
    return stringBuffer;
  }

  public static String byteArrayToHexString(byte[] bytes) {
    int length = bytes.length;
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < length; i++) {
      stringBuffer.append(String.format("%2x", bytes[i]));
    }
    return new String(bytes);
  }

  public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = HEX_ARR_UPPER[v >>> 4];
      hexChars[j * 2 + 1] = HEX_ARR_UPPER[v & 0x0F];
    }
    return new String(hexChars);
  }

  public static String byteToBinaryString(byte b) {
    return "todo";
  }

  public static String byteToBinaryString(String byteString) {
    return Byte.toString(Byte.parseByte(byteString, 2));
  }

  public static String intToString(String intString, int radix) {
    return Integer.toString(Integer.parseInt(intString), radix);
  }

  public static String intToBinaryString(String intString) {
    return Integer.toBinaryString(Integer.parseInt(intString));
  }

  public static String intToOctalString(String intString) {
    return Integer.toOctalString(Integer.parseInt(intString));
  }

  public static String intToHexString(String intString) {
    return Integer.toHexString(Integer.parseInt(intString));
  }

  public static String toHexString(byte[] bytes) {
    StringBuffer stringBuffer = new StringBuffer();
    int len = bytes.length;
    for (int i = 0; i < len; i++) {
      stringBuffer = toHex(bytes[i]);
      if (i < len - 1) {
        stringBuffer.append(":");
      }
    }
    return stringBuffer.toString();
  }
}
