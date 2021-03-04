/**
 * Project Name:java11_in_action File Name:ChainOfRespLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.examples.chainofresponsibility
 * Date:2021年3月4日下午6:00:50 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ChainOfRespLambda.java @Package
 * luozix.start.pattern.lambdasGofPattern.examples.chainofresponsibility @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:00:50
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.examples.chainofresponsibility;
/**
 * ClassName:ChainOfRespLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:00:50 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ChainOfRespLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:00:50
 * @version
 * @since JDK 1.8
 */
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChainOfRespLambda {

  public static Optional<String> parseText(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.TEXT)
        .map(f -> "Text file: " + f.getContent());
  }

  public static Optional<String> parsePresentation(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.PRESENTATION)
        .map(f -> "Presentation file: " + f.getContent());
  }

  public static Optional<String> parseAudio(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.AUDIO)
        .map(f -> "Audio file: " + f.getContent());
  }

  public static Optional<String> parseVideo(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.VIDEO)
        .map(f -> "Video file: " + f.getContent());
  }

  public static void main(String[] args) {
    File file = new File(File.Type.AUDIO, "Dream Theater  - The Astonishing");

    System.out.println(
        Stream.<Function<File, Optional<String>>>of(
                ChainOfRespLambda::parseText,
                ChainOfRespLambda::parsePresentation,
                ChainOfRespLambda::parseAudio,
                ChainOfRespLambda::parseVideo)
            .map(f -> f.apply(file))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Unknown file: " + file)));
  }
}
