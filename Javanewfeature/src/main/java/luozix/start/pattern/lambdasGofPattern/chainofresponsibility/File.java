/**
 * Project Name:java11_in_action File Name:File.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.chainofresponsibility Date:2021年3月4日下午5:38:13
 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: File.java @Package
 * luozix.start.pattern.lambdasGofPattern.chainofresponsibility @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:38:13
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.chainofresponsibility;
/**
 * ClassName:File <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:38:13 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: File @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:38:13
 * @version
 * @since JDK 1.8
 */
public class File {

  enum Type {
    TEXT,
    PRESENTATION,
    AUDIO,
    VIDEO
  }

  private final Type type;
  private final String content;

  public File(Type type, String content) {
    this.type = type;
    this.content = content;
  }

  public Type getType() {
    return type;
  }

  public String getContent() {
    return content;
  }

  @Override
  public String toString() {
    return type + ": " + content;
  }
}
