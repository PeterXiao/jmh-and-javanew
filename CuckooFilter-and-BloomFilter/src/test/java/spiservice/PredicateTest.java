/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:PredicateTest.java Package Name:spiservice
 * Date:2021年5月5日下午9:28:48 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: PredicateTest.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月5日 下午9:28:48
 * @version V1.0
 */
package spiservice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName:PredicateTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月5日 下午9:28:48 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: PredicateTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月5日 下午9:28:48
 * @version
 * @since JDK 1.8
 */
public class PredicateTest {
  public static void main(String[] args) {
    PredicateTest test = new PredicateTest();
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    test.printByCondition(list, l -> l % 2 == 0); // print 偶数
    System.out.println("\n" + "-----------------");
    test.printByConditionNegate(list, l -> l % 2 == 0); // print 非偶数
    System.out.println("\n" + "-----------------");
    test.printByConditionAnd(list, l -> l % 2 == 0, l -> l > 4); // print 偶数且大于4的数
    System.out.println("\n" + "-----------------");
    test.printByConditionOr(list, l -> l % 2 == 0, l -> l < 4); // print  偶数或小于4 的数
  }

  public void printByCondition(List<Integer> list, Predicate<Integer> predicate) {
    // l表示list中的某一个元素   //某个元素满足某种条件就输出
    list.forEach(
        l -> {
          if (predicate.test(l)) System.out.print(l + "  ");
        });
  }

  public void printByConditionNegate(List<Integer> list, Predicate<Integer> predicate) {
    // l表示list中的某一个元素     //某元素不满足某种条件输出
    list.forEach(
        l -> {
          if (predicate.negate().test(l)) System.out.print(l + "  ");
        });
  }

  public void printByConditionAnd(
      List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
    // 某元素同时满足两个条件
    list.forEach(
        l -> {
          if (predicate1.and(predicate2).test(l)) System.out.print(l + "  ");
        });
  }

  public void printByConditionOr(
      List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
    // 某元素满足某一个条件
    list.forEach(
        l -> {
          if (predicate1.or(predicate2).test(l)) System.out.print(l + "  ");
        });
  }
}
