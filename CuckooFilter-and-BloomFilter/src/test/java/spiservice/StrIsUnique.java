/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:StrIsUnique.java Package Name:spiservice
 * Date:2021年6月14日下午1:34:23 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: StrIsUnique.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年6月14日 下午1:34:23
 * @version V1.0
 */
package spiservice;

import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * ClassName:StrIsUnique <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年6月14日 下午1:34:23 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: StrIsUnique @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年6月14日 下午1:34:23
 * @version
 * @since JDK 1.8
 */
public class StrIsUnique {
  public boolean isUnique02(String astr) {
    // 字符串为null或者为空，自然没有字符重复，即唯一
    if (null == astr || 0 == astr.length()) {
      return true;
    }
    int mark = 0;
    int num = 0;
    // 遍历每一个字符
    for (int i = 0; i < astr.length(); i++) {
      num = 1 << (astr.charAt(i) - 'a');
      // 通过与运算判断对应下标是否都为1，即是否有相同字符
      if ((mark & num) != 0) {
        return false;
      }
      // 在map中将对应下标置为1
      mark |= num;
    }
    return true;
  }

  public boolean isUnique(String astr) {
    // 字符串为null或者为空，自然没有字符重复，即唯一
    if (null == astr || 0 == astr.length()) {
      return true;
    }
    Map<Character, Integer> map = new HashMap<>(astr.length() + 1);
    // 遍历每一个字符，从map中判断是否存在相同的字符
    for (int i = 0; i < astr.length(); i++) {
      // 存在相同的字符
      if (null != map.get(astr.charAt(i)) && map.get(astr.charAt(i)) == 1) {
        return false;
      }
      // 在map中不存在此字符，放入map中
      map.put(astr.charAt(i), 1);
    }
    return true;
  }

  //    public static void main(String[] args) {
  //  }

  @Benchmark
  public void isUnique() {
    String astr = "陈皮的JavaLib";
    StrIsUnique strIsUnique = new StrIsUnique();
    strIsUnique.isUnique(astr);
    // System.out.println(strIsUnique.isUnique(astr));
  }

  @Benchmark
  public void isUnique02() {
    String astr1 = "javalib";
    StrIsUnique strIsUnique = new StrIsUnique();
    strIsUnique.isUnique02(astr1);
    // System.out.println(strIsUnique.isUnique02(astr1));
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(StrIsUnique.class.getSimpleName()).build();

    new Runner(opt).run();
  }
}
