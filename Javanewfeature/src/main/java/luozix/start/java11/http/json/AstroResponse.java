/**
 * Project Name:java11_in_action File Name:AstroResponse.java Package
 * Name:luozix.start.java11.http.json Date:2021年3月3日上午9:48:02 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: AstroResponse.java @Package luozix.start.java11.http.json @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:48:02
 * @version V1.0
 */
package luozix.start.java11.http.json;
/**
 * ClassName:AstroResponse <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午9:48:02 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: AstroResponse @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:48:02
 * @version
 * @since JDK 1.8
 */
import java.util.List;

public class AstroResponse {
  private String message;
  private Integer number;
  private List<Assignment> people;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public List<Assignment> getPeople() {
    return people;
  }

  public void setPeople(List<Assignment> people) {
    this.people = people;
  }
}
