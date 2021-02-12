/**  
* @Title: BuildingStreams.java
* @Package luozix.start.java8.action.beans.lesson5
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:54:38
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson5;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
* @ClassName: BuildingStreams
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:54:38
*
*/
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

	public static void main(String... args) throws Exception {

		// Stream.of
		Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		// Stream.empty
		Stream<String> emptyStream = Stream.empty();

		// Arrays.stream
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		System.out.println(Arrays.stream(numbers).sum());

		// Stream.iterate
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

		// fibonnaci with iterate
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10)
				.forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0])
				.forEach(System.out::println);

		// random stream of doubles with Stream.generate
		Stream.generate(Math::random).limit(10).forEach(System.out::println);

		// stream of 1s with Stream.generate
		IntStream.generate(() -> 1).limit(5).forEach(System.out::println);

		IntStream.generate(new IntSupplier() {
			@Override
			public int getAsInt() {
				return 2;
			}
		}).limit(5).forEach(System.out::println);

		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			@Override
			public int getAsInt() {
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return this.previous;
			}
		};
		IntStream.generate(fib).limit(10).forEach(System.out::println);

		long uniqueWords = Files.lines(Paths.get("runoob.txt"), Charset.defaultCharset())
				.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();

		System.out.println("There are " + uniqueWords + " unique words in data.txt");

	}
}
