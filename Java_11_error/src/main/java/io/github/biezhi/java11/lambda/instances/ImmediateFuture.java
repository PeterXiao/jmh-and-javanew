/**
 *
 */
package io.github.biezhi.java11.lambda.instances;

/**
 * @author LiY
 * @time 下午5:47:25
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A simplification of the {@link Future} interface for cases in which the
 * result is immediately available.
 *
 * @param <V> the result type returned by this Future's {@link #get()} method
 */
@FunctionalInterface
public interface ImmediateFuture<V> extends Future<V> {

	@Override
	default boolean cancel(boolean mayInterruptIfRunning) {
		return false;
	}

	@Override
	default boolean isCancelled() {
		return false;
	}

	@Override
	default boolean isDone() {
		return true;
	}

	@Override
	default V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return get();
	}

}
