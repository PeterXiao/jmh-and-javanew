    /** 
	 * Project Name:java11_in_action 
	 * File Name:VarExample.java 
	 * Package Name:luozix.start.java11 
	 * Date:2021年3月2日下午6:15:44 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: VarExample.java
* @Package luozix.start.java11
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:15:44
* @version V1.0  
*/  
	  
	package luozix.start.java11;
/**
 * ClassName:VarExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:15:44 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
* @ClassName: VarExample
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月2日 下午6:15:44
* @version  
*@since JDK 1.8
*/
public class VarExample {

  /**
   * @throws IOException @Title: main @Description: TODO 感受 JEP 286 的魔法世界
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月2日 下午6:15:44.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    var list = new ArrayList<String>(); // 自动推断 ArrayList<String>
    var stream = list.stream(); // 自动推断 Stream<String>

    var newList = List.of("hello", "biezhi");
    newList.forEach(System.out::println);

    String fileName = "./pom.xml";

    var path = Paths.get(fileName);
    var bytes = Files.readAllBytes(path);

    System.out.println("字节数组: " + bytes);

    for (var b : bytes) {
      // TODO
    }

    try (var foo = new FileInputStream(new File(""))) {
      System.out.println(foo);
    } catch (Exception e) {
      // ignore
    }
  }

}
