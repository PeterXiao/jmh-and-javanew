/**
 * Project Name:java11_in_action File Name:Doctor.java Package
 * Name:luozix.start.unit.junit.exam.patientintake Date:2021年3月5日上午11:10:51 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Doctor.java @Package luozix.start.unit.junit.exam.patientintake @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:10:51
 * @version V1.0
 */
package luozix.start.unit.junit.exam.patientintake;
/**
 * ClassName:Doctor <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月5日 上午11:10:51 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Doctor @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:10:51
 * @version
 * @since JDK 1.8
 */
public enum Doctor {
  avery("Ralph Avery"),
  johnson("Beth Johnson"),
  murphy("Pat Murpy");

  private String name;

  Doctor(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
