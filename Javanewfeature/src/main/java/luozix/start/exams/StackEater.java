/**  
* @Title: StackEater.java
* @Package luozix.start.exams
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 上午10:10:09
* @version V1.0  
*/
package luozix.start.exams;
/**
* @ClassName: StackEater
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 上午10:10:09
*
*/

public class StackEater {

	public static void main(String[] args) {

		StackEater.makeException();

	}

	public static void makeException() {

//循环 N 次, 只为每次都发生空指针异常

		for (int i = 0; i < 1000000000; i++) {

			try {

				Object obj = createObject();

				System.out.println(obj.hashCode());

			} catch (Exception e) {// 打印出错栈

				e.printStackTrace();

			}

		}

	}

public static Object createObject() {

	return null;// 为了创造空指针异常, 返回一个空对象,

}

}
