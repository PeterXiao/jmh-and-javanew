/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:FunctionTest.java Package Name:spiservice
 * Date:2021年5月5日下午9:20:04 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: FunctionTest.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月5日 下午9:20:04
 * @version V1.0
 */
package spiservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName:FunctionTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月5日 下午9:20:04 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: FunctionTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月5日 下午9:20:04
 * @version
 * @since JDK 1.8
 */
public class FunctionTest {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年5月5日 下午9:20:04.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    FunctionTest test = new FunctionTest();
    // lambda表达式实现了apply，也就实现了Function接口,不要被<Integer, Integer>影响了
    System.out.println(test.operate(5, integer -> integer * integer)); // 第二个参数是方法
    // 输入参数的类型//返回类型

    String multilineString = "Baeldung helps \n \n developers \n explore Java.";
    List<String> lines =
        multilineString
            .lines()
            .filter(line -> !line.isBlank())
            .map(String::strip)
            .collect(Collectors.toList());
    assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");

    //    Path filePath = Files.writeString(Files.createTempFile(tempDir, "demo", ".txt"), "Sample
    // text");
    //    String fileContent = Files.readString(filePath);
    //    assertThat(fileContent).isEqualTo("Sample text");

  }

  public int operate(int i, Function<Integer, Integer> function) {
    return function.apply(i); // apply的返回值是Integer，参数是i
  }
}
