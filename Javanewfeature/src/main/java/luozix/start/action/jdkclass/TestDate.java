/**
 * 
 */
package luozix.start.action.jdkclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiaoy
 *
 */
public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

		String input = args.length == 0 ? "1818-11-11" : args[0];

		System.out.print(input + " Parses as ");

		Date t;

		try {
			t = ft.parse(input);
			System.out.println(t);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
		}

		try {
			System.out.println(new Date() + "\n");
			Thread.sleep(1000 * 3); // 休眠3秒
			System.out.println(new Date() + "\n");
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}

		try {
			long start = System.currentTimeMillis();
			System.out.println(new Date() + "\n");
			Thread.sleep(5 * 60 * 10);
			System.out.println(new Date() + "\n");
			long end = System.currentTimeMillis();
			long diff = end - start;
			System.out.println("Difference is : " + diff);
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}

		Calendar c1 = Calendar.getInstance();
		// 获得年份
		int year = c1.get(Calendar.YEAR);
		// 获得月份
		int month = c1.get(Calendar.MONTH) + 1;
		// 获得日期
		int date = c1.get(Calendar.DATE);
		// 获得小时
		int hour = c1.get(Calendar.HOUR_OF_DAY);
		// 获得分钟
		int minute = c1.get(Calendar.MINUTE);
		// 获得秒
		int second = c1.get(Calendar.SECOND);
		// 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
		int day = c1.get(Calendar.DAY_OF_WEEK);
	}

}
