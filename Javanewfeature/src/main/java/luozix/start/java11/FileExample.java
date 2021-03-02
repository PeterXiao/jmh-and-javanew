    /** 
	 * Project Name:java11_in_action 
	 * File Name:FileExample.java 
	 * Package Name:luozix.start.java11 
	 * Date:2021年3月2日下午6:24:53 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: FileExample.java
* @Package luozix.start.java11
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:24:53
* @version V1.0  
*/  
	  
	package luozix.start.java11;
/**
 * ClassName:FileExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:24:53 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName: FileExample @Description: 你可以在当前源码的目录下执行
 *
 * <p>java HelloWorld.java 运行这个文件的 main 方法
 *
 * <p>该命令相当于
 *
 * <p>javac -d <memory> HelloWorld.java java -cp <memory> HelloWorld
 *
 * <p>该特性来自 <a href="http://openjdk.java.net/jeps/330">JEP330</a>
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午6:24:53
 * @version
 * @since JDK 1.8
 */
public class FileExample {

  /**
   * @throws IOException @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月2日 下午6:24:53.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    String text = "Hello Luozi.";

    // 写入文本
    Files.writeString(Paths.get("hello.txt"), text);

    // 读取文本
    String readText = Files.readString(Paths.get("hello.txt"));
    System.out.println(text.equals(readText));

    // 删除文本
    Files.delete(Paths.get("hello.txt"));

    System.out.println("Hello Guys, this is Java 11.");
  }

}
