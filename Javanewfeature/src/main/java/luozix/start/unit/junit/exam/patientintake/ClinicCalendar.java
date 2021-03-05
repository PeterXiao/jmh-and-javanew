/**
 * Project Name:java11_in_action File Name:ClinicCalendar.java Package
 * Name:luozix.start.unit.junit.exam.patientintake Date:2021年3月5日上午11:11:46 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ClinicCalendar.java @Package luozix.start.unit.junit.exam.patientintake @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:11:46
 * @version V1.0
 */
package luozix.start.unit.junit.exam.patientintake;
/**
 * ClassName:ClinicCalendar <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月5日 上午11:11:46 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ClinicCalendar @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:11:46
 * @version
 * @since JDK 1.8
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClinicCalendar {

  private List<PatientAppointment> appointments;

  public ClinicCalendar() {
    appointments = new ArrayList<>();
  }

  public void addAppointment(
      String patientFirstName, String patientLastName, String doctorKey, String dateTime) {
    Doctor doc = Doctor.valueOf(doctorKey.toLowerCase());
    LocalDateTime localDateTime;
    try {
      localDateTime =
          LocalDateTime.parse(
              dateTime.toUpperCase(), DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US));
    } catch (Throwable t) {
      throw new RuntimeException(
          "Unable to create date time from: ["
              + dateTime.toUpperCase()
              + "], please enter with format [M/d/yyyy h:mm a]"
              + t.getMessage());
    }
    PatientAppointment appointment =
        new PatientAppointment(patientFirstName, patientLastName, localDateTime, doc);
    appointments.add(appointment);
  }

  public List<PatientAppointment> getAppointments() {
    return appointments;
  }
}
