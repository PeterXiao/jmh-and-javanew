/**
 *
 */
package basics.pattern.tabledriven;
import java.util.*;

import static java.lang.Double.MAX_VALUE;
/**
 * @author Office
 *
 */
public class TestTableDriven {
	  /** cutoff quantify column in rate table */
    private static final int CUTOFF = 0;

    /** rate column in rate table */
    private static final int RATE = 1;

    /** quantity vs rate table */
    private static final double[][] RATE_TBL = new double[][] { // CUTOFF RATE
    new double[] { 10, 1.50 }, new double[] { 100, 1.00 },
            new double[] { 1000, 0.95 }, new double[] { 2000, 0.94 },
            new double[] { 5000, 0.93 }, new double[] { 10000, 0.92 },
            new double[] { 20000, 0.91 }, new double[] { MAX_VALUE, 0.90 }, };

    /** list driven output tool */
    private static final Formatter printf = new Formatter(System.out);

    /**
     * Program entry point.
     */
    public static void main(String[] argv) {
        double qty;
        double rate;
        for (qty = 5; qty < 100000; qty *= 5) {
            rate = getRate(qty);
            printf.format("Extended cost for %.0f widgets: $%.2f\n", qty, (qty * rate));
        } // print each of several quantities
    } // __________

    /**
     * Return the charge rate for a given volume of product.
     */
    private static double getRate(double qty) {
        for (double[] row : RATE_TBL) {
            if (qty < row[CUTOFF]) {
                return row[RATE]; // === found ===
            } // found quantity range?
        } // scan each row
        throw new RuntimeException("This can't happen");
    } // __________

    public static char statMostRateChar(String str) {
        if (str != null && !"".equals(str)) {
            int charsStat[] = new int[256];
            int charsFirstIdx[] = new int[256];
            int strLen = str.length();

            for (int ch = 0; ch < 256;ch++) {
            charsFirstIdx[ch] = strLen;
            }

            // 統計字符出現的次數
            for (int idx = 0; idx < strLen; idx++) {
                charsStat[str.charAt(idx)]++;
                // 记录字符第一次出现的位置
                if (idx < charsFirstIdx[str.charAt(idx)]) {
                charsFirstIdx[str.charAt(idx)] = idx;
                }
            }

            int mostRateChar = 0;
            for (int ch = 1; ch < 256; ch++) {
            if (charsStat[ch] == 0) {
            continue;
            }
                // 找频率出现最高的字符
            if (charsStat[mostRateChar] < charsStat[ch]) {
                mostRateChar = ch;
                // 出现频率一样时，选择出现在前面的数
                } else if (charsStat[mostRateChar] == charsStat[ch]&&
                charsFirstIdx[mostRateChar] > charsFirstIdx[ch]) {
                mostRateChar = ch;
                }
            }

            return (char) mostRateChar;
        } else {
            return '\0';
        }
    }
}
