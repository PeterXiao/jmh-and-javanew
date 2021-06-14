/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:DojoTest.java Package Name:spiservice
 * Date:2021年6月13日下午3:03:33 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: DojoTest.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年6月13日 下午3:03:33
 * @version V1.0
 */
package spiservice;
/**
 * ClassName:DojoTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年6月13日 下午3:03:33 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ClassName: DojoTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年6月13日 下午3:03:33
 * @version
 * @since JDK 1.8
 */
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class DojoTest {
  private Dojo dojo = new Dojo();

  @Test
  public void list() {
    // given

    // when
    List<String> theList = dojo.list();

    // then
    assertThat(theList).contains("s1", "s2", "s3");
  }

  @Test
  public void map() {
    // given

    // when
    Map<String, String> theMap = dojo.map();

    // then
    assertThat(theMap).containsEntry("key1", "value1");
    assertThat(theMap).containsEntry("key2", "value2");
    assertThat(theMap).containsEntry("key3", "value3");
  }

  @Test
  public void streamIterate() {
    // given

    // when
    String str = dojo.streamIterate();

    // then
    assertThat(str).isEqualTo("0123456789");
  }

  @Test
  public void getChuckNorrisJoke() throws IOException {
    // given

    // when
    String joke = dojo.getChuckNorrisJoke();

    // then
    assertThat(joke)
        .contains(
            "There are no races, only countries of people Chuck Norris has beaten to different shades of black and blue.");
  }

  @Test
  public void nextTenDates() {
    // given

    // when
    List<LocalDate> nextTenDates = dojo.nextTenDates();

    // then
    assertThat(nextTenDates).size().isEqualTo(10);
  }

  @Test
  public void readAllBytes() throws IOException {
    // given

    // when
    String fileContent = dojo.readAllBytes();

    // then
    assertThat(fileContent).isEqualTo("TOTO\nTATA\nTITI");
  }

  @Test
  public void copyOf() throws IOException {
    // given
    List<String> source = new ArrayList<>();
    source.add("s1");
    source.add("s2");
    source.add("s3");

    // when
    List<String> copy = dojo.copyOf(source);

    // then
    assertThat(copy).size().isEqualTo(3);
  }

  @Test
  public void repeat() {
    // given

    // when
    String str = dojo.repeate("ah", 3);

    // then
    assertThat(str).isEqualTo("ahahah");
  }
}
