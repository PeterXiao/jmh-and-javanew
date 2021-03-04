/**
 * Project Name:java11_in_action File Name:Resource.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.template Date:2021年3月4日下午5:52:09 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Resource.java @Package luozix.start.pattern.lambdasGofPattern.template @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:52:09
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.template;
/**
 * ClassName:Resource <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:52:09 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Resource @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:52:09
 * @version
 * @since JDK 1.8
 */
import java.util.Random;

public class Resource {
  public Resource() {
    System.out.println("Resource created");
  }

  public void useResource() {
    riskyOperation();
    System.out.println("Resource used");
  }

  public void employResource() {
    riskyOperation();
    System.out.println("Resource employed");
  }

  public void dispose() {
    System.out.println("Resource disposed");
  }

  private void riskyOperation() {
    if (new Random().nextInt(3) == 0) {
      throw new RuntimeException();
    }
  }

  public static void main(String[] args) {
    Resource resource = new Resource();
    resource.useResource();
    resource.employResource();
    resource.dispose();
  }
}
