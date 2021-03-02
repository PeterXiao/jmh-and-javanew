    /** 
	 * Project Name:java11_in_action 
	 * File Name:DiamondOperatorExample.java 
	 * Package Name:luozix.start.java11 
	 * Date:2021年3月2日下午6:32:46 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: DiamondOperatorExample.java
* @Package luozix.start.java11
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:32:46
* @version V1.0  
*/  
	  
	package luozix.start.java11;
/**
 * ClassName:DiamondOperatorExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:32:46 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: DiamondOperatorExample @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午6:32:46
 * @version
 * @since JDK 1.8
 */
/**
 * Java7 引入了一个新的特性：Diamond Operator，来避免冗长代码和提升可读性。
 *
 * <p>然而在 Java 8 中，Oracle 发现在 Diamond 操作器和匿名内部类的使用中存在一些局限性， 后来修复了这些问题并准备将其作为 Java9 的一部分发布出去。
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 */
public class DiamondOperatorExample {

  abstract static class MyHandler<T> {

    private T content;

    public MyHandler(T content) {
      this.content = content;
      System.out.println("构造函数收到了一条内容: " + content.toString());
    }

    public T getContent() {
      return content;
    }

    public void setContent(T content) {
      this.content = content;
    }

    abstract void handle();
  }

  public static void main(String[] args) {
    MyHandler<Integer> intHandler =
        new MyHandler<>(1) {
          @Override
          public void handle() {
            System.out.println("收到红包 > " + getContent() + "元");
          }
        };
    intHandler.handle();

    System.out.println("===================神奇的分割线===================");

    MyHandler<? extends Integer> intHandler1 =
        new MyHandler<>(10) {
          @Override
          void handle() {
            System.out.println("收到红包 > " + getContent() + "元");
          }
        };
    intHandler1.handle();

    System.out.println("===================神奇的分割线===================");

    MyHandler<?> handler =
        new MyHandler<>("魔法师") {
          @Override
          void handle() {
            System.out.println("马上把 [" + getContent() + "] 给处理了");
          }
        };
    handler.handle();
  }
}
