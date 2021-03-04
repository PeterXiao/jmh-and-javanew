/**
 * Project Name:java11_in_action File Name:Sample.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.decorator Date:2021年3月4日下午5:54:28 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Sample.java @Package luozix.start.pattern.lambdasGofPattern.decorator @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:54:28
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.decorator;
/**
 * ClassName:Sample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:54:28 <br>
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
 * @date 2021年3月4日 下午5:54:28
 * @version
 * @since JDK 1.8
 */
import java.awt.Color;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unchecked")
class Camera {
  private Function<Color, Color> filter;

  public Camera() {
    setFilters();
  }

  public Color capture(final Color inputColor) {
    final Color processedColor = filter.apply(inputColor);
    // ... more processing...
    return processedColor;
  }

  public void setFilters(final Function<Color, Color>... filters) {
    filter =
        Arrays.stream(filters)
            .reduce((filter, next) -> filter.compose(next))
            .orElse(color -> color);
  }
}

@SuppressWarnings("unchecked")
public class Sample {
  public static void main(String[] args) {
    final Camera camera = new Camera();

    final Consumer<String> printCaptured =
        (filterInfo) ->
            System.out.println(
                String.format(
                    "with %s : %s", filterInfo, camera.capture(new Color(200, 100, 200))));

    printCaptured.accept("NO filters");

    camera.setFilters(Color::brighter);
    printCaptured.accept("bright filter");

    camera.setFilters(Color::darker);
    printCaptured.accept("bright darker");

    camera.setFilters(Color::brighter, Color::darker);
    printCaptured.accept("bright and darker");
  }
}
