/**
 * Project Name:java11_in_action File Name:StrategyGof.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.examples.strategy Date:2021年3月4日下午6:09:17 Copyright
 * (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: StrategyGof.java @Package
 * luozix.start.pattern.lambdasGofPattern.examples.strategy @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:09:17
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.examples.strategy;
/**
 * ClassName:StrategyGof <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:09:17 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: StrategyGof @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:09:17
 * @version
 * @since JDK 1.8
 */
public class StrategyGof {

  interface TextFormatter {
    boolean filter(String text);

    String format(String text);
  }

  public static class PlainTextFormatter implements TextFormatter {

    @Override
    public boolean filter(String text) {
      return true;
    }

    @Override
    public String format(String text) {
      return text;
    }
  }

  public static class ErrorTextFormatter implements TextFormatter {

    @Override
    public boolean filter(String text) {
      return text.startsWith("ERROR");
    }

    @Override
    public String format(String text) {
      return text.toUpperCase();
    }
  }

  public static class ShortTextFormatter implements TextFormatter {

    @Override
    public boolean filter(String text) {
      return text.length() < 20;
    }

    @Override
    public String format(String text) {
      return text.toLowerCase();
    }
  }

  public static class TextEditor {
    private final TextFormatter textFormatter;

    public TextEditor(TextFormatter textFormatter) {
      this.textFormatter = textFormatter;
    }

    public void publishText(String text) {
      if (textFormatter.filter(text)) {
        System.out.println(textFormatter.format(text));
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("ErrorTextFormatter:");
    TextEditor textEditor = new TextEditor(new ErrorTextFormatter());
    textEditor.publishText("ERROR - something bad happened");
    textEditor.publishText("DEBUG - I'm here");

    System.out.println("\nShortTextFormatter:");
    textEditor = new TextEditor(new ShortTextFormatter());
    textEditor.publishText("ERROR - something bad happened");
    textEditor.publishText("DEBUG - I'm here");

    System.out.println("\nPlainTextFormatter:");
    textEditor = new TextEditor(new PlainTextFormatter());
    textEditor.publishText("ERROR - something bad happened");
    textEditor.publishText("DEBUG - I'm here");
  }
}
