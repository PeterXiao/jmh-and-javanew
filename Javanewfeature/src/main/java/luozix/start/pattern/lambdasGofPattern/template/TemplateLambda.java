/**
 * Project Name:java11_in_action File Name:TemplateLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.template Date:2021年3月4日下午5:51:26 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: TemplateLambda.java @Package
 * luozix.start.pattern.lambdasGofPattern.template @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:51:26
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.template;
/**
 * ClassName:TemplateLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:51:26 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: TemplateLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:51:26
 * @version
 * @since JDK 1.8
 */
import java.util.function.Consumer;

public class TemplateLambda {
  public static void withResource(Consumer<Resource> consumer) {
    Resource resource = new Resource();
    try {
      consumer.accept(resource);
    } finally {
      resource.dispose();
    }
  }

  public static void main(String[] args) {
    withResource(resource -> resource.useResource());
    withResource(resource -> resource.employResource());
  }
}
