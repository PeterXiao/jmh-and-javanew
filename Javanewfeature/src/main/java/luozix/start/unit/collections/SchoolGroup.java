/**
 * Project Name:java11_in_action File Name:SchoolGroup.java Package
 * Name:luozix.start.unit.collections Date:2021年3月7日下午8:12:10 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: SchoolGroup.java @Package luozix.start.unit.collections @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月7日 下午8:12:10
 * @version V1.0
 */
package luozix.start.unit.collections;
/**
 * ClassName:SchoolGroup <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月7日 下午8:12:10 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: SchoolGroup @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月7日 下午8:12:10
 * @version
 * @since JDK 1.8
 */
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Random;
import java.util.stream.IntStream;

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.collector.Collectors2;
import org.eclipse.collections.impl.factory.Lists;

/** On Halloween, three different SchoolGroups go trick or treating at different times. */
public class SchoolGroup {
  public static final ZoneId NEW_YORK = ZoneId.of("America/New_York");
  private static final LocalDate HALLOWEEN = LocalDate.of(2018, Month.OCTOBER, 31);
  private static final LocalTime ELEMENTARY_SCHOOL_START = LocalTime.NOON.plus(Duration.ofHours(3));
  private static final LocalTime MIDDLE_SCHOOL_START =
      ELEMENTARY_SCHOOL_START.plus(Duration.ofHours(2));
  private static final LocalTime HIGH_SCHOOL_START = MIDDLE_SCHOOL_START.plus(Duration.ofHours(2));
  private static final long CANDY_COUNT = 250L;

  private static final SchoolGroup ELEMENTARY_SCHOOL =
      new SchoolGroup(HALLOWEEN.atTime(ELEMENTARY_SCHOOL_START), CANDY_COUNT);
  private static final SchoolGroup MIDDLE_SCHOOL =
      new SchoolGroup(HALLOWEEN.atTime(MIDDLE_SCHOOL_START), CANDY_COUNT);
  private static final SchoolGroup HIGH_SCHOOL =
      new SchoolGroup(HALLOWEEN.atTime(HIGH_SCHOOL_START), CANDY_COUNT);

  private LocalDateTime time;
  private long candyCount;

  private SchoolGroup(LocalDateTime time, long candyCount) {
    this.time = time;
    this.candyCount = candyCount;
  }

  public static ImmutableList<SchoolGroup> all() {
    return Lists.immutable.with(ELEMENTARY_SCHOOL, MIDDLE_SCHOOL, HIGH_SCHOOL);
  }

  public Bag<Candy> trickOrTreat() {
    IntStream limit =
        new Random(time.atZone(NEW_YORK).toEpochSecond())
            .ints(0, Candy.values().length - 1)
            .limit(candyCount);
    return limit.mapToObj(i -> Candy.values()[i]).collect(Collectors2.toBag());
  }
}
