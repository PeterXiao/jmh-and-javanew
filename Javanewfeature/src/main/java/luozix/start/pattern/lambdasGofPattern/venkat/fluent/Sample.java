/**
 * Project Name:java11_in_action File Name:Sample.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.venkat.fluent Date:2021年3月4日下午6:15:40 Copyright (c)
 * 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Sample.java @Package luozix.start.pattern.lambdasGofPattern.venkat.fluent @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:15:40
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.venkat.fluent;
/**
 * ClassName:Sample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:15:40 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.function.Consumer;

// class Mailer {
//  public void from(String addr) { System.out.println("from"); }
//  public void to(String addr) { System.out.println("to"); }
//  public void subject(String subjectLine) { System.out.println("subject"); }
//  public void body(String message) { System.out.println("body"); }
//  public void send() { System.out.println("sending..."); }
// }
// public class Sample {
//  public static void main(String[] args) {
//    Mailer mailer = new Mailer();
//    mailer.from("builder@agiledeveloper.com");
//    mailer.to("venkats@agiledeveloper.com");
//    mailer.subject("Your code sucks");
//    mailer.body("...");
//    mailer.send();
//  }
// }

class Mailer {
  public Mailer from(String addr) {
    System.out.println("from");
    return this;
  }

  public Mailer to(String addr) {
    System.out.println("to");
    return this;
  }

  public Mailer subject(String subjectLine) {
    System.out.println("subject");
    return this;
  }

  public Mailer body(String message) {
    System.out.println("body");
    return this;
  }

  public static void send(Consumer<Mailer> block) {
    Mailer mailer = new Mailer();
    block.accept(mailer);
    System.out.println("sending...");
  }
}

public class Sample {
  public static void main(String[] args) {
    Mailer.send(
        mailer -> {
          mailer
              .from("builder@agiledeveloper.com")
              .to("venkats@agiledeveloper.com")
              .subject("Your code sucks")
              .body("...");
        });
  }
}
