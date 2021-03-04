/**
 * Project Name:java11_in_action File Name:Sample.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.venkat.delegating Date:2021年3月4日下午6:14:10 Copyright
 * (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Sample.java @Package
 * luozix.start.pattern.lambdasGofPattern.venkat.delegating @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:14:10
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.venkat.delegating;
/**
 * ClassName:Sample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:14:10 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.function.Function;

class CalculateNAV {
  private Function<String, Double> _priceFinder;

  public CalculateNAV(Function<String, Double> priceFinder) {
    _priceFinder = priceFinder;
  }

  public double compute(String ticker, int stocks) {
    return stocks * _priceFinder.apply(ticker);
  }
}

class StockFetcher {
  public static double getStockPrice(String ticker) {
    System.out.println("Do real work and get the stock price...");
    return 35.55;
  }
}

public class Sample {
  public static void main(String[] args) {

    // In test case
    CalculateNAV calculateNAV = new CalculateNAV(ticker -> 33.33);

    // assert
    System.out.println(calculateNAV.compute("ORCL", 100));

    // In production
    CalculateNAV calculateNAV2 = new CalculateNAV(StockFetcher::getStockPrice);
    System.out.println(calculateNAV2.compute("ORCL", 100));
  }
}
