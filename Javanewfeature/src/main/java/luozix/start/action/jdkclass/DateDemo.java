/**
 * 
 */
package luozix.start.action.jdkclass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author xiaoy
 *
 */
public class DateDemo {

	public static void main(String[] args) {
		// 初始化 Date 对象
		Date date = new Date();

		// 使用 toString() 函数显示日期时间
		System.out.println(date.toString());

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println("当前时间为: " + ft.format(dNow));

		// c的使用
		System.out.printf("全部日期和时间信息：%tc%n", date);
		// f的使用
		System.out.printf("年-月-日格式：%tF%n", date);
		// d的使用
		System.out.printf("月/日/年格式：%tD%n", date);
		// r的使用
		System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", date);
		// t的使用
		System.out.printf("HH:MM:SS格式（24时制）：%tT%n", date);
		// R的使用
		System.out.printf("HH:MM格式（24时制）：%tR", date);
		// 使用toString()显示日期和时间
		System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
		// 显示格式化时间
		System.out.printf("%s %tB %<te, %<tY", "Due date:", date);

		// b的使用，月份简称
		String str = String.format(Locale.US, "英文月份简称：%tb", date);
		System.out.println(str);
		System.out.printf("本地月份简称：%tb%n", date);
		// B的使用，月份全称
		str = String.format(Locale.US, "英文月份全称：%tB", date);
		System.out.println(str);
		System.out.printf("本地月份全称：%tB%n", date);
		// a的使用，星期简称
		str = String.format(Locale.US, "英文星期的简称：%ta", date);
		System.out.println(str);
		// A的使用，星期全称
		System.out.printf("本地星期的简称：%tA%n", date);
		// C的使用，年前两位
		System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n", date);
		// y的使用，年后两位
		System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n", date);
		// j的使用，一年的天数
		System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);
		// m的使用，月份
		System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n", date);
		// d的使用，日（二位，不够补零）
		System.out.printf("两位数字的日（不足两位前面补0）：%td%n", date);
		// e的使用，日（一位不补零）
		System.out.printf("月份的日（前面不补0）：%te", date);

	}
}
