    /** 
	 * Project Name:java11_in_action 
	 * File Name:Example.java 
	 * Package Name:luozix.start.java11.interfaces 
	 * Date:2021年3月2日下午6:33:32 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Example.java
* @Package luozix.start.java11.interfaces
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:33:32
* @version V1.0  
*/  
	  
	package luozix.start.java11.interfaces;
/**
 * ClassName:Example <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:33:32 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Example @Description: TODO(这里用一句话描述这个类的作用)
 *
 * <p>* 接口中的私有方法
 *
 * <p>Java 8 为接口添加了默认方法，接口可以实现行为，不止于方法签名。
 *
 * <p>但是，如果在接口上有几个默认方法，代码几乎相同，会导致什么情况？
 *
 * <p>一般我们会重构这些方法，调用一个可复用的私有方法。但默认方法不能是私有的。
 *
 * <p>将复用代码创建为一个默认方法不是一个好的选择，因为该辅助方法会成为公共API的一部分。
 *
 * <p>Java9 支持向接口添加私有方法来解决这个问题。
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午6:33:32
 * @version
 * @since JDK 1.8
 */
public interface Example {

  private static void sayHello() {
    System.out.println("你已经是大佬了，快和萌新打个招呼！");
  }

  // 普通方法
  void normalInterfaceMethod();

  // 默认方法
  default void interfaceMethodWithDefault() {
    init();
  }

  // 另一个蛇皮默认方法
  default void anotherDefaultMethod() {
    init();
  }

  // 这个方法不是公共 API 的一部分
  private void init() {
    System.out.println("正在给大佬准备洗脚水...");
  }
}
