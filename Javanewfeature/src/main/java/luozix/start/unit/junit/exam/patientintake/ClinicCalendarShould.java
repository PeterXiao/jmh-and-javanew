/**
 * Project Name:java11_in_action File Name:ClinicCalendarShould.java Package
 * Name:luozix.start.unit.junit.exam.patientintake Date:2021年3月5日上午11:13:49 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ClinicCalendarShould.java @Package
 * luozix.start.unit.junit.exam.patientintake @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:13:49
 * @version V1.0
 */
package luozix.start.unit.junit.exam.patientintake;
/**
 * ClassName:ClinicCalendarShould <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月5日 上午11:13:49 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * @ClassName: ClinicCalendarShould @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月5日 上午11:13:49
 * @version
 * @since JDK 1.8
 */
import org.junit.jupiter.api.Test;

class ClinicCalendarShould {

  @Test
  void allowEntryOfAnAppointment() {
    ClinicCalendar calendar = new ClinicCalendar();
    calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00 pm");
    List<PatientAppointment> appointments = calendar.getAppointments();
    assertNotNull(appointments);
    assertEquals(1, appointments.size());
    PatientAppointment enteredAppt = appointments.get(0);
    assertEquals("Jim", enteredAppt.getPatientFirstName());
    assertEquals("Weaver", enteredAppt.getPatientLastName());
    assertEquals(Doctor.avery, enteredAppt.getDoctor());
    assertEquals(
        "9/1/2018 02:00 PM",
        enteredAppt
            .getAppointmentDateTime()
            .format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
  }
}
