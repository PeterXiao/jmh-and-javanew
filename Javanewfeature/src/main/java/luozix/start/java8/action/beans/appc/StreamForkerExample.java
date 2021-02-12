/**  
* @Title: StreamForkerExample.java
* @Package luozix.start.java8.action.beans.appc
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:27:37
* @version V1.0  
*/
package luozix.start.java8.action.beans.appc;
/**
* @ClassName: StreamForkerExample
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:27:37
*
*/

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static luozix.start.java8.action.beans.lesson6.Dish.menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import luozix.start.java8.action.beans.lesson6.Dish;
public class StreamForkerExample {

	public static void main(String[] args) throws Exception {
		processMenu();
	}

	private static void processMenu() {
		Stream<Dish> menuStream = menu.stream();

		StreamForker.Results results = new StreamForker<Dish>(menuStream)
				.fork("shortMenu", s -> s.map(Dish::getName).collect(joining(", ")))
				.fork("totalCalories", s -> s.mapToInt(Dish::getCalories).sum())
				.fork("mostCaloricDish",
						s -> s.collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get())
				.fork("dishesByType", s -> s.collect(groupingBy(Dish::getType))).getResults();

		String shortMeny = results.get("shortMenu");
		int totalCalories = results.get("totalCalories");
		Dish mostCaloricDish = results.get("mostCaloricDish");
		Map<Dish.Type, List<Dish>> dishesByType = results.get("dishesByType");

		System.out.println("Short menu: " + shortMeny);
		System.out.println("Total calories: " + totalCalories);
		System.out.println("Most caloric dish: " + mostCaloricDish);
		System.out.println("Dishes by type: " + dishesByType);
	}
}
