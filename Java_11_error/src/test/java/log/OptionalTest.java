/**
 *
 */
package log;

import java.util.Set;

import org.testng.annotations.Test;

/**
 * @author LiY
 * @time 下午10:04:46
 */
import com.google.common.base.Optional;

public class OptionalTest {

	public void testOptional() throws Exception {
		final Optional<Integer> possible = Optional.of(6);
		if (possible.isPresent()) {
			System.out.println("possible isPresent:" + possible.isPresent());
			System.out.println("possible value:" + possible.get());
		}
	}

	@Test
	public void testOptionals() throws Exception {
		final Optional<Integer> possible = Optional.of(6);
		final Optional<Integer> absentOpt = Optional.absent();
		final Optional<Integer> NullableOpt = Optional.fromNullable(null);
		final Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
		if (possible.isPresent()) {
			System.out.println("possible isPresent:" + possible.isPresent());
			System.out.println("possible value:" + possible.get());
		}
		if (absentOpt.isPresent()) {
			System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
			;
		}
		if (NullableOpt.isPresent()) {
			System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent());
			;
		}
		if (NoNullableOpt.isPresent()) {
			System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent());
			;
		}
	}

	@Test
	public void testMethodReturn() {
		final Optional<Long> value = method();
		if (value.isPresent() == true) {
			System.out.println("获得返回值: " + value.get());
		} else {

			System.out.println("获得返回值: " + value.or(-12L));
		}

		System.out.println("获得返回值 orNull: " + value.orNull());

		final Optional<Long> valueNoNull = methodNoNull();
		if (valueNoNull.isPresent() == true) {
			final Set<Long> set = valueNoNull.asSet();
			System.out.println("获得返回值 set 的 size : " + set.size());
			System.out.println("获得返回值: " + valueNoNull.get());
		} else {
			System.out.println("获得返回值: " + valueNoNull.or(-12L));
		}

		System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
	}

	private Optional<Long> method() {
		return Optional.fromNullable(null);
	}

	private Optional<Long> methodNoNull() {
		return Optional.fromNullable(15L);
	}

}