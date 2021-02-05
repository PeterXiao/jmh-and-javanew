/**  
* @Title: Exam.java
* @Package luozix.start.exams.concurrent.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午12:39:59
* @version V1.0  
*/
package luozix.start.exams.concurrent.problems;
/**
* @ClassName: Exam
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午12:39:59
*
*/
public class Exam {

	/**
	 * @param args
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	 */
	// 采用共享内存状态的方式在多个线程间共享数据
	private static int counter = 0;

	public static void main(String[] args) {
		while (counter < 20) {
			new Thread(() -> {
				// 自增写操作
				counter++;
			}).start();
			new Thread(() -> {
				// 自增写操作
				counter++;
			}).start();
			// 只读操作
			System.out.println(counter);
		}
	}

}
