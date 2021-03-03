/**
 * Project Name:java11_in_action File Name:AstroClientTest.java Package
 * Name:luozix.start.java11.http Date:2021年3月3日上午9:49:38 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: AstroClientTest.java @Package luozix.start.java11.http @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:49:38
 * @version V1.0
 */
package luozix.start.java11.http;
/**
 * ClassName:AstroClientTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午9:49:38 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import luozix.start.java11.http.json.Assignment;
import luozix.start.java11.http.json.AstroResponse;

/**
 * @ClassName: AstroClientTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:49:38
 * @version
 * @since JDK 1.8
 */
class AstroClientTest {

  private Logger logger = Logger.getLogger(AstroClientTest.class.getName());

  private AstroClient client = new AstroClient();

  @Test
  void getSync() {
    AstroResponse response =
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> client.getSync());

    int num = response.getNumber();
    List<Assignment> assignments = response.getPeople();

    assertEquals("success", response.getMessage());
    assertEquals(num, assignments.size());
    assignments.forEach(
        assignment ->
            assertAll(
                () -> assertTrue(assignment.getName().length() > 0),
                () -> assertTrue(assignment.getCraft().length() > 0)));

    logResponse(num, assignments);
  }

  @Test
  void getAsync() {
    AstroResponse response =
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> client.getAsync());

    int num = response.getNumber();
    List<Assignment> assignments = response.getPeople();

    assertEquals("success", response.getMessage());
    assertEquals(num, assignments.size());

    logResponse(num, assignments);
  }

  private void logResponse(int num, List<Assignment> assignments) {
    logger.info(String.format("There are %d people in space", num));
    assignments.forEach(
        person ->
            logger.info(() -> String.format("%s aboard %s", person.getName(), person.getCraft())));
  }
}
