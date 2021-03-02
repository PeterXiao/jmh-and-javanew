/**
 * Project Name:java11_in_action File Name:TimeExample.java Package Name:luozix.start.java11
 * Date:2021年3月2日下午6:17:10 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: TimeExample.java @Package luozix.start.java11 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午6:17:10
 * @version V1.0
 */
package luozix.start.java11;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:TimeExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:17:10 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: TimeExample @Description: Time convert
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午6:17:10
 * @version
 * @since JDK 1.8
 */
public class TimeExample {

  /**
  * @Title: main
  * @Description: TODO(这里用一句话描述这个方法的作用)
  * @param @param args    设定文件
  * @return void    返回类型
  * date: 2021年3月2日 下午6:17:10.<br/>
  * @author xiaoy 
  * @param args 
  *@since JDK 1.8
  * @throws
  */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    long day = TimeUnit.DAYS.convert(Duration.ofHours(24));
    System.out.println(day == 1);

    // 1 天
    System.out.println(TimeUnit.DAYS.convert(Duration.ofHours(26)));

    // 1 分钟
    System.out.println(TimeUnit.MINUTES.convert(Duration.ofSeconds(60)));
  }

}
