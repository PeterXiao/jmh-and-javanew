/**  
* @Title: StreamBasic.java
* @Package luozix.start.java8.action.beans.lesson4
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:21:24
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson4;
/**
* @ClassName: StreamBasic
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:21:24
*
*/

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamBasic {

	public static void main(String... args) {
		// Java 7
		getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

		System.out.println("---");

		// Java 8
		getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

		List<String> threeHighCaloricDishName = Dish.menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
				.limit(3L).collect(toList());
		System.out.println(threeHighCaloricDishName);

		long count = Dish.menu.stream().filter(d -> d.getCalories() > 300).distinct().limit(3L).count();
	}

	public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish d : dishes) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		List<String> lowCaloricDishesName = new ArrayList<>();
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		return lowCaloricDishesName;
	}

	public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
		return dishes.stream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories))
				.map(Dish::getName).collect(toList());
	}
}
