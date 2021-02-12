package luozix.start.java8.action.beans.lesson5;


import static java.util.stream.Collectors.toList;
import static luozix.start.java8.action.beans.lesson4.Dish.menu;

import java.util.Arrays;
import java.util.List;

import luozix.start.java8.action.beans.lesson4.Dish;

public class Mapping{

    public static void main(String...args){

        // map
        List<String> dishNames = menu.stream()
                                     .map(Dish::getName)
                                     .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                 .flatMap((String line) -> Arrays.stream(line.split("")))
                 .distinct()
                 .forEach(System.out::println);
//        words.stream().map(w->w.split(""))
//        .flatMap(Arrays::stream())
//        .distinct()
//        .collect(Collectors.toList()).forEach(System.out::println);
        

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);

		List<int[]> pairs1 = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
				.collect(toList());
		
		pairs1.stream().forEach(a -> System.out.println(Arrays.toString(a)));

		System.out.println("*******************************");
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
        

    }
}
