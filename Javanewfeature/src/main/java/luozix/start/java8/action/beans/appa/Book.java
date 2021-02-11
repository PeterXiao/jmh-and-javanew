/**  
* @Title: Book.java
* @Package luozix.start.java8.action.beans.appa
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午1:25:10
* @version V1.0  
*/
package luozix.start.java8.action.beans.appa;

import java.util.Arrays;

/**
* @ClassName: Book
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午1:25:10
*
*/
@Auther(name = "Raoul")
@Auther(name = "Mario")
@Auther(name = "Alan")
public class Book {

	/**
	 * @param args
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Auther[] authers = Book.class.getAnnotationsByType(Auther.class);
		Arrays.asList(authers).stream().forEach(a -> {
			System.out.println(a.name());
		});
	}

}
