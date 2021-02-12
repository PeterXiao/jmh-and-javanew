/**  
* @Title: Filtering.java
* @Package luozix.start.java8.action.beans.lesson5
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:51:28
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson5;
/**
* @ClassName: Filtering
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:51:28
*
*/

import static java.util.stream.Collectors.toList;
import static luozix.start.java8.action.beans.lesson4.Dish.menu;

import java.util.Arrays;
import java.util.List;

import luozix.start.java8.action.beans.lesson4.Dish;

public class Filtering {

	public static void main(String... args) {

		// Filtering with predicate
		List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());

		vegetarianMenu.forEach(System.out::println);

		// Filtering unique elements
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

		// Truncating a stream
		List<Dish> dishesLimit3 = menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());

		dishesLimit3.forEach(System.out::println);

		// Skipping elements
		List<Dish> dishesSkip2 = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());

		dishesSkip2.forEach(System.out::println);

		List<Dish> dishes = menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2L).collect(toList());
		System.out.println(dishes);

	}
}