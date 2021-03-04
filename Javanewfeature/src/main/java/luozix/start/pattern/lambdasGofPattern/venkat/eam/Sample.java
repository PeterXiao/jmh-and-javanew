/**
 * Project Name:java11_in_action File Name:Sample.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.venkat.eam Date:2021年3月4日下午6:14:55 Copyright (c)
 * 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Sample.java @Package luozix.start.pattern.lambdasGofPattern.venkat.eam @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:14:55
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.venkat.eam;
/**
 * ClassName:Sample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:14:55 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Sample @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:14:55
 * @version
 * @since JDK 1.8
 */
import java.util.function.Consumer;

class Resource {

  private Resource() {
    System.out.println("Instance created");
  }

  public void op1() {
    System.out.println("op1 called....");
  }

  public void op2() {
    System.out.println("op2 called...");
  }

  private void close() {
    System.out.println("do any cleanup here...");
  }

  public static void use(Consumer<Resource> consume) {
    Resource resource = new Resource();
    try {
      consume.accept(resource);
    } finally {
      resource.close();
    }
  }
}

public class Sample {
  public static void main(String[] args) {
    // This is how the class will be used by fellow programmers.

    Resource.use(
        resource -> {
          resource.op1();
          resource.op2();
        });
  }
}

/*
Instance created
op1 called....
op2 called...
do any cleanup here...
*/
