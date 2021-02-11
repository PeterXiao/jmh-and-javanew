/**  
* @Title: FilteringApples.java
* @Package luozix.start.java8.action.beans.lesson02
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:31:01
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson02;
/**
* @ClassName: FilteringApples
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:31:01
*
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilteringApples {

	public static void main(String... args) {

		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println(redApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);

		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple a) {
				return a.getColor().equals("red");
			}
		});
		System.out.println(redApples2);
		System.out.println("**************************");
		prettyPrintApple(inventory, new AppleFancyFormatter());
		prettyPrintApple(inventory, new AppleSimpleFormatter());

		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());

			}
		});
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
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

	interface ApplePredicate {
		public boolean test(Apple a);
	}

	static class AppleWeightPredicate implements ApplePredicate {
		@Override
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}

	static class AppleColorPredicate implements ApplePredicate {
		@Override
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate {
		@Override
		public boolean test(Apple apple) {
			return "red".equals(apple.getColor()) && apple.getWeight() > 150;
		}
	}

	interface AppleFormatter {
		String accept(Apple a);
	}

	static class AppleFancyFormatter implements AppleFormatter {

		/*
		 * (非 Javadoc) <p>Title: accept</p> <p>Description: </p>
		 * 
		 * @param a
		 * 
		 * @return
		 * 
		 * @see luozix.start.java8.action.beans.lesson02.FilteringApples.AppleFormatter#
		 * accept(luozix.start.java8.action.beans.lesson02.FilteringApples.Apple)
		 */
		@Override
		public String accept(Apple a) {
			// TODO Auto-generated method stub
			String chacteristic = a.getWeight() > 150 ? "heavy" : "light";

			return "A" + chacteristic + " " + a.getColor() + " apple";
		}
	}

	static class AppleSimpleFormatter implements AppleFormatter {

		/*
		 * (非 Javadoc) <p>Title: accept</p> <p>Description: </p>
		 * 
		 * @param a
		 * 
		 * @return
		 * 
		 * @see luozix.start.java8.action.beans.lesson02.FilteringApples.AppleFormatter#
		 * accept(luozix.start.java8.action.beans.lesson02.FilteringApples.Apple)
		 */
		@Override
		public String accept(Apple a) {
			// TODO Auto-generated method stub

			return "An Apple of " + a.getWeight() + " g";
		}

	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String ouString = formatter.accept(apple);
			System.out.println(ouString);

		}
	}
}
