/**
 * Project Name:java11_in_action File Name:ChainOfRespGoF.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.chainofresponsibility Date:2021年3月4日下午5:39:08
 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ChainOfRespGoF.java @Package
 * luozix.start.pattern.lambdasGofPattern.chainofresponsibility @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:39:08
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.chainofresponsibility;
/**
 * ClassName:ChainOfRespGoF <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:39:08 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ChainOfRespGoF @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:39:08
 * @version
 * @since JDK 1.8
 */
public class ChainOfRespGoF {

  public interface FileParser {
    String parse(File file);

    void setNextParser(FileParser next);
  }

  public abstract static class AbstractFileParser implements FileParser {
    protected FileParser next;

    @Override
    public void setNextParser(FileParser next) {
      this.next = next;
    }
  }

  public static class TextFileParser extends AbstractFileParser {
    @Override
    public String parse(File file) {
      if (file.getType() == File.Type.TEXT) {
        return "Text file: " + file.getContent();
      } else if (next != null) {
        return next.parse(file);
      } else {
        throw new RuntimeException("Unknown file: " + file);
      }
    }
  }

  public static class PresentationFileParser extends AbstractFileParser {
    @Override
    public String parse(File file) {
      if (file.getType() == File.Type.PRESENTATION) {
        return "Presentation file: " + file.getContent();
      } else if (next != null) {
        return next.parse(file);
      } else {
        throw new RuntimeException("Unknown file: " + file);
      }
    }
  }

  public static class AudioFileParser extends AbstractFileParser {
    @Override
    public String parse(File file) {
      if (file.getType() == File.Type.AUDIO) {
        return "Audio file: " + file.getContent();
      } else if (next != null) {
        return next.parse(file);
      } else {
        throw new RuntimeException("Unknown file: " + file);
      }
    }
  }

  public static class VideoFileParser extends AbstractFileParser {
    @Override
    public String parse(File file) {
      if (file.getType() == File.Type.VIDEO) {
        return "Video file: " + file.getContent();
      } else if (next != null) {
        return next.parse(file);
      } else {
        throw new RuntimeException("Unknown file: " + file);
      }
    }
  }

  public static void main(String[] args) {
    FileParser textParser = new TextFileParser();
    FileParser presentationParser = new PresentationFileParser();
    FileParser audioParser = new AudioFileParser();
    FileParser videoParser = new VideoFileParser();

    textParser.setNextParser(presentationParser);
    presentationParser.setNextParser(audioParser);
    audioParser.setNextParser(videoParser);

    File file = new File(File.Type.AUDIO, "Dream Theater  - The Astonishing");

    System.out.println(textParser.parse(file));
  }
}
