/**
 * Project Name:java11_in_action File Name:Others.java Package Name:luozix.start.perf
 * Date:2021年3月4日下午4:18:19 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Others.java @Package luozix.start.perf @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:18:19
 * @version V1.0
 */
package luozix.start.perf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.openjdk.jol.info.GraphLayout;

/**
 * ClassName:Others <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午4:18:19 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
/**
 * @ClassName: Others @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午4:18:19
 * @version
 * @since JDK 1.8
 */
public class Others {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月4日 下午4:18:19.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    List<Integer> sizeList = Arrays.asList(1, 10, 100, 1000, 10000, 100000);
    System.out.printf("%s\t%s\t%s\n", "Size", "HashMap", "Int2ObjectArrayMap");
    for (Integer size : sizeList) {
      Map<Integer, String> hashMap = buildHashMap(size);
      Map<Integer, String> int2ObjectArrayMap = buildInt2ObjectArrayMap(size);

      // long hashMapSize = GraphLayout.parseInstance(hashMap).totalSize();
      // long int2ObjectArrayMapSize = GraphLayout.parseInstance(int2ObjectArrayMap).totalSize();

      // System.out.printf("%d\t%d\t%d\n", size, hashMapSize, int2ObjectArrayMapSize);
      
    }
  }

  private static Map<Integer, String> buildInt2ObjectArrayMap(Integer size) {
    Int2ObjectArrayMap<String> map = new Int2ObjectArrayMap<>();
    for (int i = 0; i < size; i++) {
      map.put(i, "");
    }
    return map;
  }

  private static Map<Integer, String> buildHashMap(Integer size) {
    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
      map.put(i, "");
    }
    return map;
  }
}
