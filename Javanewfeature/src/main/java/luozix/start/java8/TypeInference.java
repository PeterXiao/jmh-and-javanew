/**
 * Project Name:java11_in_action File Name:TypeInference.java Package Name:luozix.start.java8
 * Date:2021年3月3日上午11:17:45 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: TypeInference.java @Package luozix.start.java8 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:17:45
 * @version V1.0
 */
package luozix.start.java8;
/**
 * ClassName:TypeInference <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午11:17:45 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: TypeInference @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:17:45
 * @version
 * @since JDK 1.8
 */
public class TypeInference<T> {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午11:17:45.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    final TypeInference<String> typeInference = new TypeInference<>();
    typeInference.getOrDefault("22", TypeInference.defaultValue());
  }

  public static <T> T defaultValue() {
    return null;
  }

  public T getOrDefault(T value, T defaultValue) {
    return (value != null) ? value : defaultValue;
  }
}
