/**
 *
 */
package io;

import java.util.Optional;

/**
 * @author LiY
 * @time 下午1:57:47
 */
public class FooWidget {
	private final String data;
	private final Optional<Bar> bar;

	public FooWidget(String data) {
		this(data, Optional.empty());
	}

	public FooWidget(String data, Optional<Bar> bar) {
		this.data = data;
		this.bar = bar;
	}

	public Optional<Bar> getBar() {
		return bar;
	}
}
