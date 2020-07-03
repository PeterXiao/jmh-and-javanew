/**
 *
 */
package basics.Strings;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Office
 *
 */
public class randomStringGenerator {

    public static void main(String[] args) {
    	ArrayList<String> list = new ArrayList<String>() {{
    	    add("A");
    	    add("B");
    	    add("C");
    	}};

    	//List<String> list1 = ["A", "B", "C"];
    	List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");

    	List<String> places1 = Collections.singletonList("Buenos Aires");

    	//ArrayList<String> places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));

    	List<String> strings = List.of("foo", "bar", "baz");

        System.out.println(generateString());
        outerloop:
            for (int i=0; i < 5; i++) {
                for (int j=0; j < 5; j++) {
                    if (i * j > 6) {
                        System.out.println("Breaking");
                        break outerloop;
                    }
                    System.out.println(i + " " + j);
                }
            }
            System.out.println("Done");

            int[] ints = new int[] {1, 2, 3, 4, 5};
            System.out.println(IntStream.of(ints).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
            System.out.println(IntStream.of(ints).boxed().map(Object::toString).collect(Collectors.joining(", ")));
            System.out.println(Arrays.toString(ints));

            String[] strs = new String[] {"John", "Mary", "Bob"};
            System.out.println(Stream.of(strs).collect(Collectors.joining(", ")));
            System.out.println(String.join(", ", strs));
            System.out.println(Arrays.toString(strs));

//            DayOfWeek [] days = { "FRIDAY", "MONDAY", "TUESDAY" };
//            System.out.println(Stream.of(days).map(Object::toString).collect(Collectors.joining(", ")));
//            System.out.println(Arrays.toString(days));
//
//            // These options are not the same as each item is printed on a new line:
//            IntStream.of(ints).forEach(System.out::println);
//            Stream.of(strs).forEach(System.out::println);
//            Stream.of(days).forEach(System.out::println);
            List<String> stringList = Pattern.compile("-")
                    .splitAsStream("004-034556")
                    .collect(Collectors.toList());

            stringList.forEach(s -> System.out.println(s));
    }

    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "uuid = " + uuid;
    }

    /**
     * A common method for all enums since they can't have another base class
     * @param <T> Enum type
     * @param c enum type. All enums must be all caps.
     * @param string case insensitive
     * @return corresponding enum, or null
     */
    public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
        if( c != null && string != null ) {
            try {
                return Enum.valueOf(c, string.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {
            }
        }
        return null;
    }
    public static MyEnum fromString(String name) {
        return getEnumFromString(MyEnum.class, name);
    }
}