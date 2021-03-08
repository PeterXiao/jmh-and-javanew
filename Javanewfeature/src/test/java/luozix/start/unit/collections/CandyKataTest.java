/**
 * Project Name:java11_in_action File Name:CandyKataTest.java Package
 * Name:luozix.start.unit.collections Date:2021年3月7日下午8:15:43 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: CandyKataTest.java @Package luozix.start.unit.collections @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月7日 下午8:15:43
 * @version V1.0
 */
package luozix.start.unit.collections;
/**
 * ClassName:CandyKataTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月7日 下午8:15:43 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CandyKataTest {
  @Test
  @Tag("KATA")
  public void topCandy() {
    MutableList<Bag<Candy>> bagsOfCandy = collectBagsOfCandy();

    // Hint: Flatten the Bags of Candy into a single Bag
    Bag<Candy> bigBagOfCandy = null;

    // Hint: Find the top occurrence in the bag and convert that to a set.
    MutableSet<Candy> mostCommon = null;

    var expectedSet = Sets.mutable.with(Candy.REESES_PIECES);
    Assertions.assertEquals(expectedSet, mostCommon);
  }

  @Test
  @Tag("KATA")
  public void commonInTop10() {
    MutableList<Bag<Candy>> bagsOfCandy = collectBagsOfCandy();

    // Hint: Find the top 10 occurrences of Candy in each of the bags and intersect them.
    MutableSet<Candy> commonInTop10 = null;

    var expectedSet = Sets.mutable.with(Candy.REESES_PIECES, Candy.CRUNCH);
    Assertions.assertEquals(expectedSet, commonInTop10);
  }

  private MutableList<Bag<Candy>> collectBagsOfCandy() {
    return SchoolGroup.all().collect(SchoolGroup::trickOrTreat).toList();
  }
}
