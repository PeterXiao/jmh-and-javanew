/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:ConcurrentDateTest.java Package
 * Name:spiservice Date:2021年6月14日上午8:36:54 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights
 * Reserved.
 */
/**
 * @Title: ConcurrentDateTest.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年6月14日 上午8:36:54
 * @version V1.0
 */
package spiservice;
/**
 * ClassName:ConcurrentDateTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年6月14日 上午8:36:54 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ConcurrentDateTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年6月14日 上午8:36:54
 * @version
 * @since JDK 1.8
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentDateTest {

  private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

  private static String date1String = "2021-06-14";
  // private static String date2String  = "2013-04-05";

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      new Thread(
              new Runnable() {

                @Override
                public void run() {
                  try {
                    Date date1 = simpleDateFormat.parse(date1String);
                    // String date1S = simpleDateFormat.format(date1);
                    System.out.println(Thread.currentThread().getName() + ":" + date1);
                  } catch (Exception e) {
                    System.out.println("Thread error");
                    // throw new RuntimeException("parse failed", e);
                  }
                }
              })
          .start();
    }
  }
}
