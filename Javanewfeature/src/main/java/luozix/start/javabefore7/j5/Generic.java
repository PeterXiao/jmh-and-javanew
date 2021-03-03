/**
 * Project Name:java11_in_action File Name:Generic.java Package Name:luozix.start.javabefore7.j5
 * Date:2021年3月3日上午10:23:04 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Generic.java @Package luozix.start.javabefore7.j5 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:23:04
 * @version V1.0
 */
package luozix.start.javabefore7.j5;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:Generic <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:23:04 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Generic @Description: 泛型
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:23:04
 * @version
 * @since JDK 1.8
 */
public class Generic<T> {
  public T getById(Integer id) {
    return null;
  }

  public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<>();

    Generic<Long> generic = new Generic<>();
  }
}
