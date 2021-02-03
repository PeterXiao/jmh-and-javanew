/**
 * 
 */
package luozix.start.exams;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiaoy
 *
 */
public class SimpleDateMainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		String strDAteFormatString = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDAteFormatString);
		System.out.print(simpleDateFormat.format(date));

		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
		// Date date = new Date();// 获取当前时间
		System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）

		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		int dom = cal.get(Calendar.DAY_OF_MONTH);
		int doy = cal.get(Calendar.DAY_OF_YEAR);

		System.out.println("当期时间: " + cal.getTime());
		System.out.println("日期: " + day);
		System.out.println("月份: " + month);
		System.out.println("年份: " + year);
		System.out.println("一周的第几天: " + dow); // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
		System.out.println("一月中的第几天: " + dom);
		System.out.println("一年的第几天: " + doy);

		Long timeStamp = System.currentTimeMillis(); // 获取当前时间戳
		SimpleDateFormat sdfg = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sd = sdfg.format(new Date(Long.parseLong(String.valueOf(timeStamp)))); // 时间戳转换成时间
		System.out.println("格式化结果：" + sd);

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
		String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
		System.out.println("格式化结果：" + sd2);
	}

}
