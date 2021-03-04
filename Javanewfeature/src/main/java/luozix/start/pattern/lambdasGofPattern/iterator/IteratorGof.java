/**
 * Project Name:java11_in_action File Name:IteratorGof.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.iterator Date:2021年3月4日下午5:46:58 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: IteratorGof.java @Package luozix.start.pattern.lambdasGofPattern.iterator @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:46:58
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.iterator;
/**
 * ClassName:IteratorGof <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:46:58 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import static java.util.Arrays.asList;

/**
 * @ClassName: IteratorGof @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:46:58
 * @version
 * @since JDK 1.8
 */
import java.util.Iterator;
import java.util.List;

public class IteratorGof {
  static final List<Integer> list = asList(1, 2, 3, 4, 5, 6);

  public static void main(String[] args) {
    Iterator<Integer> iterator = list.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    for (Integer i : list) {
      System.out.println(i);
    }
  }
}
