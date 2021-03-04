/**
 * Project Name:java11_in_action File Name:FinancialUtil.java Package Name:luozix.start.util.common
 * Date:2021年3月4日下午3:11:15 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: FinancialUtil.java @Package luozix.start.util.common @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:11:15
 * @version V1.0
 */
package luozix.start.util.common;

import java.math.BigDecimal;

/**
 * ClassName:FinancialUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:11:15 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: FinancialUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:11:15
 * @version
 * @since JDK 1.8
 */
public class FinancialUtil {

  /*
  todo
  金额数字转大写
   */

  private static String[] unitStrArray = {"", "拾", "佰", "仟"};
  private static String[] numStrArray = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

  private static String getRMBIntPart(double dNum) {
    String rMBIntPart = "";
    int i, weiShu;
    int intNum = (int) dNum;
    int yiNum = intNum / 100000000;
    int wanNum = (intNum - (yiNum * 100000000)) / 10000;
    int yuanNum = intNum - (yiNum * 100000000) - (wanNum * 10000);

    // 分3部分处理数字，每部分加上亿，万，元
    // yi
    if (yiNum != 0) {
      rMBIntPart = rMBIntPart + numStrArray[yiNum] + "亿";
    }

    // wan
    if (wanNum != 0) {
      for (i = 3; i >= 0; i--) {
        weiShu = wanNum / (int) Math.pow(10, i);
        if (weiShu == 0) {
          rMBIntPart = rMBIntPart + numStrArray[weiShu];
        } else {
          rMBIntPart = rMBIntPart + numStrArray[weiShu] + unitStrArray[i];
        }
        wanNum = wanNum - (weiShu * (int) Math.pow(10, i));
      }
      // 去除重复的零
      while (rMBIntPart.contains("零零")) {
        rMBIntPart = rMBIntPart.replaceAll("零零", "零");
      }
      // 去掉结尾的零
      if (rMBIntPart.endsWith("零")) {
        rMBIntPart = rMBIntPart.substring(0, rMBIntPart.length() - 1);
      }
      rMBIntPart = rMBIntPart + "万";
    }

    // yuan
    if (yuanNum != 0) {
      for (i = 3; i >= 0; i--) {
        weiShu = yuanNum / (int) Math.pow(10, i);
        if (weiShu == 0) {
          rMBIntPart = rMBIntPart + numStrArray[weiShu];
        } else {
          rMBIntPart = rMBIntPart + numStrArray[weiShu] + unitStrArray[i];
        }
        yuanNum = yuanNum - (weiShu * (int) Math.pow(10, i));
      }
      // 去除重复的零
      while (rMBIntPart.contains("零零")) {
        rMBIntPart = rMBIntPart.replaceAll("零零", "零");
      }
      // 去掉结尾的零
      if (rMBIntPart.endsWith("零")) {
        rMBIntPart = rMBIntPart.substring(0, rMBIntPart.length() - 1);
      }
      rMBIntPart = rMBIntPart + "元";
    }

    // 去掉总字符串开头的零
    if (rMBIntPart.startsWith("零")) {
      rMBIntPart = rMBIntPart.substring(1, rMBIntPart.length());
    }

    return rMBIntPart;
  }

  private static String getRMBDecPart(double dNum) {
    String rMBDecPart;
    double xiaoShu = dNum - Math.floor(dNum);
    // String转BigDecimal再转Double可提高精度
    String temp = Double.toString(xiaoShu);
    BigDecimal bDecimal = new BigDecimal(temp);
    xiaoShu = bDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    if (xiaoShu == 0) {
      rMBDecPart = "整";
      return rMBDecPart;
    }
    rMBDecPart = numStrArray[(int) ((xiaoShu * 100) / 10)] + "角";
    int fen = (int) ((xiaoShu * 100) - ((int) (xiaoShu * 100) / 10 * 10));
    if (fen != 0) {
      rMBDecPart =
          rMBDecPart
              + numStrArray[(int) ((xiaoShu * 100) - ((int) (xiaoShu * 100) / 10 * 10))]
              + "分";
    }
    return rMBDecPart;
  }

  public static String numToRMB(double num) throws NumberFormatException {
    return "人民币" + getRMBIntPart(num) + getRMBDecPart(num);
  }

  public static String numToRMB(String text) throws NumberFormatException {
    BigDecimal bDecimal = new BigDecimal(text);
    double num = bDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    return numToRMB(num);
  }
}
