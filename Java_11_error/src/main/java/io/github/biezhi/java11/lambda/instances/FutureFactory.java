/**
 *
 */
package io.github.biezhi.java11.lambda.instances;

import java.util.concurrent.Future;

/**
 * Creates instances of {@link Future}.
 */
public class FutureFactory {

	private FutureFactory() {
		// private constructor for utility class
	}

	/**
	 * Creates a new future with the default result.
	 *
	 * @return a new {@link Future}
	 */
	public static Future<Integer> createWithDefaultResult() {
		final ImmediateFuture<Integer> immediateFuture = () -> 0;
		return immediateFuture;
	}

	/**
	 * Creates a new future which returns a random result on each
	 * {@link Future#get() get()}.
	 *
	 * @return a new {@link Future}
	 */
	public static Future<Integer> createWithRandomResult() {
		final ImmediateFuture<Integer> immediateFuture = () -> (int) Math.random() * 10;
		return immediateFuture;
	}

	/**
	 * Creates a new future with the specified result.
	 *
	 * @param result the {@link Future#get() result} of the returned future
	 * @return a new {@link Future}
	 */
	public static Future<Integer> createWithResult(Integer result) {
		final ImmediateFuture<Integer> immediateFuture = () -> result;
		return immediateFuture;
	}

}
