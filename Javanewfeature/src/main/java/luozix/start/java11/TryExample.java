    /** 
	 * Project Name:java11_in_action 
	 * File Name:TryExample.java 
	 * Package Name:luozix.start.java11 
	 * Date:2021年3月2日下午6:12:55 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: TryExample.java
* @Package luozix.start.java11
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:12:55
* @version V1.0  
*/  
	  
	package luozix.start.java11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ClassName:TryExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:12:55 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: TryExample @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午6:12:55
 * @version * Java SE 7 引入了一个新的异常处理结构：Try-With-Resources，来自动管理资源。
 *     <p>这个新的声明结构主要目的是实现“Automatic Better Resource Management”（“自动资源管理”）。
 *     <p>Java SE 9 将对这个声明作出一些改进来避免一些冗长写法，同时提高可读性。
 * @since JDK 1.8
 */
public class TryExample {

  /**
   * @throws IOException @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月2日 下午6:12:55.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader reader1 = new BufferedReader(new FileReader("./README.md"));
    try (reader1) {
      while (reader1.ready()) {
        System.out.println(reader1.readLine());
      }
    }
  }

}
