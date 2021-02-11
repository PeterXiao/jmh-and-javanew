/**  
* @Title: Sorting.java
* @Package luozix.start.java8.action.beans.lesson3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午5:41:39
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson3;
/**
* @ClassName: Sorting
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午5:41:39
*
*/

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Sorting {

	public static void main(String... args) {

		// 1
		List<Apple> inventory = new ArrayList<>();
		inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red")));

		// [Apple{color='green', weight=80}, Apple{color='red', weight=120},
		// Apple{color='green', weight=155}]
		inventory.sort(new AppleComparator());
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(30, "green"));

		// 2
		// [Apple{color='green', weight=30}, Apple{color='green', weight=80},
		// Apple{color='green', weight=155}]
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(20, "red"));

		// 3
		// [Apple{color='red', weight=20}, Apple{color='green', weight=30},
		// Apple{color='green', weight=155}]
		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(10, "red"));

		// 4
		// [Apple{color='red', weight=10}, Apple{color='red', weight=20},
		// Apple{color='green', weight=155}]
		inventory.sort(comparing(Apple::getWeight));
		System.out.println(inventory);
		inventory.sort(comparing(Apple::getWeight).reversed()); // 重量逆序
		System.out.println(inventory);
		// 比较器链
//		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
		
		// Predicate<Apple> notRedApplePredicate = redApple.negate();

		Predicate<String> nonEmptyPredicate = (String s) -> (s.isEmpty());
		List listofStrings = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			listofStrings.add(i);
		}
		List<String> nonEmptyList = filter(listofStrings, nonEmptyPredicate);

		List<Integer> weightsIntegers = Arrays.asList(7, 3, 4, 10);

		List<Apple> apples = map(weightsIntegers, Apple::new);
		
		System.out.println(apples);

//		BiFunction<String, Integer, Apple> c3 = Apple::new;
		// （color,weight）-> new Apple(color,weight);
//		Apple c3 = c3.apply("green",110);


	}

	public static class Apple {
		private Integer weight = 0;
		private String color = "";

		public Apple(Integer weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public Apple(Integer weight) {
			this.weight = weight;

		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
		}
	}

	static class AppleComparator implements Comparator<Apple> {
		@Override
		public int compare(Apple a1, Apple a2) {
			return a1.getWeight().compareTo(a2.getWeight());
		}
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> resultList = new ArrayList<>();
		for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
			T t = (T) iterator.next();
			if (p.test(t)) {
				resultList.add(t);
			}

		}
		return resultList;
	}

	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
		List<Apple> resultApples = new ArrayList<>();
		for (Integer e : list) {
			resultApples.add(f.apply(e));
		}

		return resultApples;
	}
}

//static Map<String, Function<Integer,Fruit>> map = new HashMap<>();
//static {
//	  map.put("apple", Apple::new);
//	  map.put("orange", Orange::new);
//	  //etc...
//	  
//}
//
//
//public static Fruit giveMeFruit(String fruit,Integer weight) {
//	return map.get(fruit.toLowerCase())
//			.apply(weight);
//	
//}