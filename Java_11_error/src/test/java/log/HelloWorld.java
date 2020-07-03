/**
 *
 */
package log;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LiY
 * @time 下午2:20:45
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class HelloWorld {
	@Test
	public static void test() {
		final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.info("Hello World");
		final Foo foo = new Foo();
		foo.setVar(5);
		final Collection<String> list = Arrays.asList("stream", "string");
		final List<String> filtered = list.stream().filter(s -> s.startsWith("s")).map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		assertThat(Foo.testMethod());
		final var list1 = new ArrayList<String>();
	}
}
