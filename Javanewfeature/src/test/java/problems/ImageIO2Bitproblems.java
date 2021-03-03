/**
 * Project Name:java11_in_action File Name:ImageIO2Bitproblems.java Package Name:problems
 * Date:2021年3月3日上午9:15:01 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ImageIO2Bitproblems.java @Package problems @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:15:01
 * @version V1.0
 */
package problems;
/**
 * ClassName:ImageIO2Bitproblems <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午9:15:01 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
/**
 * @ClassName: ImageIO2Bitproblems @Description:
 *
 * <p>输入的图片比较有特点，将任意一张图片(image.png)使用 imagemagick 做如下变换可得到触发 exception 的输入
 *
 * <p>convert image.png -colorspace gray -depth 2 -alpha off 0.png
 *
 * <p>只有 bit depth 为 2 时会抛出这个 exception，而 bit depth 为 1，4 和 8 时都可以正常完成程序的预期功能。
 *
 * <p>测试的 openJDK 是 15.0.2，同时测试了 openJDK 11.0.10 ，欢迎大佬复现。
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:15:01
 * @version
 * @since JDK 1.8
 */
public class ImageIO2Bitproblems {

  /**
   * @Title: main @Description: 验证Java ImageIO转换2bit png到 bmp 默认不切换图片depth，同时Java bmp默认实现了1 4 8 16
   * 24 32 rgb
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午9:15:01.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    File inputFile = new File("0.png");
    try (InputStream is = new FileInputStream(inputFile)) {
      BufferedImage image = ImageIO.read(is);
      ImageIO.write(image, "bmp", new File("0.bmp"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
