/**
 *
 */
package basics.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Office
 *
 */
public class TestDecimal {

    /**
     * @param args
     */

    public static void main(String[] args) {

	// TODO Auto-generated method stub
	System.out.println("12.5的四舍五入值：" + Math.round(12.5));

	System.out.println("-12.5的四舍五入值：" + Math.round(-12.5));

	BigDecimal d = new BigDecimal(100000); // 存款

	BigDecimal r = new BigDecimal(0.001875 * 3); // 利息

	BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN); // 使用银行家算法

	System.out.println("季利息是：" + i);

    }

}
