/**
 * Project Name:java11_in_action File Name:TypeInference.java Package
 * Name:luozix.start.javabefore7.j7 Date:2021年3月3日上午10:37:16 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: TypeInference.java @Package luozix.start.javabefore7.j7 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:37:16
 * @version V1.0
 */
package luozix.start.javabefore7.j7;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:TypeInference <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:37:16 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: TypeInference 类型推断 @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:37:16
 * @version
 * @since JDK 1.8
 */
public class TypeInference {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午10:37:16.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<String> list = new ArrayList<>();
    list.add("A");

    List<? extends String> list2 = new ArrayList<>();
    list.addAll(list2);
  }
}
