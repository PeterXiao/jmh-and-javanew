/**  
* @Title: StreamTest01.java
* @Package luozix.start.java8.action.beans.lesson5
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:45:59
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson5;

import java.util.Arrays;
import java.util.List;

/**
* @ClassName: StreamTest01
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:45:59
*
*/
public class StreamTest01 {

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

//		List<Dish> vegetarianDishes = Dish.menu.stream().filter(Dish::isVegetarian)
//				.collect(toList);

		List<Integer> numbersIntegers = Arrays.asList(1, 2, 3, 1, 2, 3, 1, 3, 4, 3);
		numbersIntegers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

	}

}
