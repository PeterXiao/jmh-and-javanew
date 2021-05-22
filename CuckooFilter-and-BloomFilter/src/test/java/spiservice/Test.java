/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:Test.java Package Name:spiservice Date :
 * 2021年5月9日下午7:56:26 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Test.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月9日 下午7:56:26
 * @version V1.0
 */
package spiservice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:Test <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月9日 下午7:56:26 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Test @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月9日 下午7:56:26
 * @version
 * @since JDK 1.8
 */
// private  static AtomicInteger num=new AtomicInteger(0);

public class Test {
  private static AtomicInteger num = new AtomicInteger(0);

  public static void add() {
    num.getAndIncrement();
  }

  public static void main(String[] args) throws InterruptedException {
    new Thread(
            () -> {
              while (num.get() == 0) {}
              ;
            })
        .start();
    TimeUnit.SECONDS.sleep(2);

    for (int i = 0; i < 20; i++) {
      new Thread(
              () -> {
                for (int j = 0; j < 1000; j++) {
                  add();
                }
              })
          .start();
    }
    TimeUnit.SECONDS.sleep(10);
    System.out.println(num);
  }
}
