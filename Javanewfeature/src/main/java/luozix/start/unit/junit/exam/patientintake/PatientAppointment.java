/**
 * Project Name:java11_in_action File Name:PatientAppointment.java Package
 * Name:luozix.start.unit.junit.exam.patientintake Date:2021年3月5日上午11:11:24 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: PatientAppointment.java @Package luozix.start.unit.junit.exam.patientintake @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:11:24
 * @version V1.0
 */
package luozix.start.unit.junit.exam.patientintake;
/**
 * ClassName:PatientAppointment <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月5日 上午11:11:24 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: PatientAppointment @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:11:24
 * @version
 * @since JDK 1.8
 */
import java.time.LocalDateTime;

public class PatientAppointment {

  private String patientFirstName;
  private String patientLastName;
  private LocalDateTime appointmentDateTime;
  private Doctor doctor;

  public PatientAppointment(
      String patientFirstName,
      String patientLastName,
      LocalDateTime appointmentDateTime,
      Doctor doctor) {
    this.patientFirstName = patientFirstName;
    this.patientLastName = patientLastName;
    this.appointmentDateTime = appointmentDateTime;
    this.doctor = doctor;
  }

  public String getPatientFirstName() {
    return patientFirstName;
  }

  public String getPatientLastName() {
    return patientLastName;
  }

  public LocalDateTime getAppointmentDateTime() {
    return appointmentDateTime;
  }

  public Doctor getDoctor() {
    return doctor;
  }
}
