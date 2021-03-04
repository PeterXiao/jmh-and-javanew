/**
 * Project Name:java11_in_action File Name:NullUtil.java Package Name:luozix.start.util.common
 * Date:2021年3月4日下午3:05:43 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: NullUtil.java @Package luozix.start.util.common @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:05:43
 * @version V1.0
 */
package luozix.start.util.common;
/**
 * ClassName:NullUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:05:43 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import static org.hamcrest.CoreMatchers.nullValue;

/**
 * @ClassName: NullUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:05:43
 * @version
 * @since JDK 1.8
 */
public class NullUtil {

  public static boolean isNUll(Object object) {

    return object == null;
  }

  public static boolean isNotNull(Object object) {
    return object != nullValue();
  }
}
