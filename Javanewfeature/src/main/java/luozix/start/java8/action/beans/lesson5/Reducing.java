package luozix.start.java8.action.beans.lesson5;

import static luozix.start.java8.action.beans.lesson4.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import luozix.start.java8.action.beans.lesson4.Dish;

public class Reducing{

    public static void main(String...args){

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                           .map(Dish::getCalories)
                           .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);

		sum = numbers.parallelStream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
    }
}
