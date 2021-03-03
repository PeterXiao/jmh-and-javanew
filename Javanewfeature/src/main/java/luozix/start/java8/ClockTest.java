/** */
package luozix.start.java8;

/**
 * @author xiaoy
 * @description java 8 之后的时间日期 API
 */
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ClockTest {
  public static void main(String[] args) {
    Clock currentClock = Clock.systemUTC();
    System.out.println("Instant = " + currentClock.instant());
    System.out.println("Ms = " + currentClock.millis());

    // Without time
    LocalDate localDate = LocalDate.now();
    LocalDate clockDate = LocalDate.now(currentClock);

    System.out.println("localDate = " + localDate);
    System.out.println("clockDate = " + clockDate);

    // Without date
    LocalTime localTime = LocalTime.now();
    LocalTime clockTime = LocalTime.now(currentClock);

    System.out.println("localTime = " + localTime);
    System.out.println("clockTime = " + clockTime);

    // Without Time-Zone
    LocalDateTime localDateTime = LocalDateTime.now();
    LocalDateTime clockDateTime = LocalDateTime.now(currentClock);

    System.out.println("localDateTime = " + localDateTime);
    System.out.println("clockDateTime = " + clockDateTime);

    // Zoned Date Time
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    ZonedDateTime clockZoned = ZonedDateTime.now(currentClock);
    ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

    System.out.println("zonedDateTime = " + zonedDateTime);
    System.out.println("clockZoned = " + clockZoned);
    System.out.println("zonedDatetimeFromZone = " + zonedDatetimeFromZone);

    final Duration duration = Duration.between(zonedDateTime, zonedDatetimeFromZone);
    System.out.println("Duration in nanos: " + duration.toNanos());
    System.out.println("Duration in millis: " + duration.toMillis());

    // Get the system clock as UTC offset
    final Clock clock = Clock.systemUTC();
    System.out.println(clock.instant());
    System.out.println(clock.millis());

    // Get the local date and local time
    final LocalDate date = LocalDate.now();
    final LocalDate dateFromClock = LocalDate.now(clock);

    System.out.println(date);
    System.out.println(dateFromClock);

    // Get the local date and local time
    final LocalTime time = LocalTime.now();
    final LocalTime timeFromClock = LocalTime.now(clock);

    System.out.println(time);
    System.out.println(timeFromClock);

    // Get the local date/time
    final LocalDateTime datetime = LocalDateTime.now();
    final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);

    System.out.println(datetime);
    System.out.println(datetimeFromClock);

    // Get the zoned date/time
    final ZonedDateTime zonedDatetime = ZonedDateTime.now();
    final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(clock);
    final ZonedDateTime zonedDatetimeFromZones =
        ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

    System.out.println(zonedDatetime);
    System.out.println(zonedDatetimeFromClock);
    System.out.println(zonedDatetimeFromZone);

    // Get duration between two dates
    final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
    final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);

    final Duration durations = Duration.between(from, to);
    System.out.println("Duration in days: " + durations.toDays());
    System.out.println("Duration in hours: " + durations.toHours());
  }
}
