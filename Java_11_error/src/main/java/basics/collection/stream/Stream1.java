/**
 *
 */
package basics.collection.stream;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Office
 *
 */
public class Stream1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList(Arrays.asList("one", "two", " "));
		class State {
		    boolean s;
		}
		final State state = new State();
		Stream<String> sl = l.stream().map(e -> {
		    if (state.s)
		        return "OK";
		    else {
		        state.s = true;
		        return e;
		    }
		});
		sl.forEach(System.out::println);

//		Stream<String> stream =l.stream();
//		Pattern pattern = null ;
//		//		ArrayList<String> results = new ArrayList<>();
////		Stream<String> stream;
////		stream.filter(s -> pattern.matcher(s).matches())
////		      .forEach(s -> results.add(s));  // 副作用代码
//		List<String>results =
//			    stream .filter(s -> pattern.matcher(s).matches())
//			          .collect(Collectors.toList());  // No side-effects!

		Stream.of(1, 2, 3, 2, 1).dropWhile(n -> n < 3).collect(Collectors.toList()); // [3, 2, 1]

		Stream.of(1, 2, 3, 2, 1).takeWhile(n -> n < 3).collect(Collectors.toList()); // [1, 2]

		Optional.of("foo").orElseThrow(); // foo
		Optional.of("foo").stream().count(); // 1
		Optional.ofNullable(null).or(() -> Optional.of("fallback")).get();
//		Stream<String> fizzBuzz =
//			   zip(
//			      IntStream.range(0, 101).boxed(),
//			      zip(
//			         cycle(Stream.of("fizz", "", "")),
//			         cycle(Stream.of("buzz, "", "", "", "")),
//			         String::concat
//			      ),
//			      (i, string) -> string.isEmpty() ? i.toString() :: string
//			   );
//			fizzBuzz.skip(1).forEach(System.out::println);

	}

}
