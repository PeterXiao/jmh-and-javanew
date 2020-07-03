/**
 *
 */
package basics.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

/**
 * @author Office
 *
 */
public class TestCache {
	@Test
	void cacheExposesMetricsForHitMissAndEviction() throws Exception {
		// Run cleanup in same thread, to remove async behavior with evictions
		final Cache<String, String> cache = Caffeine.newBuilder().maximumSize(2).recordStats().executor(Runnable::run)
				.build();
		// CaffeineCacheMetrics.monitor(registry, cache, "c", userTags);

		cache.getIfPresent("user1");
		cache.getIfPresent("user1");
		cache.put("user1", "First User");
		cache.getIfPresent("user1");

		// Add to cache to trigger eviction.
		cache.put("user2", "Second User");
		cache.put("user3", "Third User");
		cache.put("user4", "Fourth User");

		// assertThat(registry.mustFind("c.requests").tags("result",
		// "hit").tags(userTags).functionCounter().count()).isEqualTo(1.0);
		// assertThat(registry.mustFind("c.requests").tags("result",
		// "miss").tags(userTags).functionCounter().count()).isEqualTo(2.0);
		// assertThat(registry.mustFind("c.evictions").tags(userTags).functionCounter().count()).isEqualTo(2.0);
	}

	private final int[] cache = new int[1000];

	public TestCache() {
		// n de 1 = 1;
		cache[1] = 1;
	}

	public int fibonacciDe(int n) {

		if (cache[n] != 0) {
			return cache[n];
		}

		// n de 0 = 0
		if (n <= 0) {
			return 0;
		}

		final int result = fibonacciDe(n - 1) + fibonacciDe(n - 2);
		cache[n] = result;
		return result;
	}

	LoadingCache<String, String> build = Caffeine.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS).build(key -> "");

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * LoadingCache<Key, Graph> graphs = Caffeine.newBuilder() .maximumSize(10_000)
		 * .expireAfterWrite(5, TimeUnit.MINUTES) .refreshAfterWrite(1,
		 * TimeUnit.MINUTES) .build(key -> createExpensiveGraph(key));
		 */

		/*
		 * System.out.println("Enter Fibonacci index: "); Scanner sc = new
		 * Scanner(System.in); int index = sc.nextInt(); sc.close();
		 *
		 * System.out.println(fibonacci(index));
		 */

		String inputLine = "";

		final InputStreamReader converter = new InputStreamReader(System.in);
		final BufferedReader in = new BufferedReader(converter);
		final TestCache fib = new TestCache();

		while (!inputLine.equals("sair")) {
			System.out.println("Informe o valor de n para obter o seu Fibonacci ou \"sair\" para finalizar: ");
			inputLine = in.readLine();

			if (!inputLine.equals("sair")) {
				final int value = Integer.parseInt(inputLine);
				final long begin = System.nanoTime();
				System.out.print("Fibonacci de " + inputLine + " é: " + fib.fibonacciDe(value) + "\n");
				final long end = System.currentTimeMillis();
				System.out.print("Tempo " + (end - begin) + "\n");
			}
		}

	}

	private static long fibonacci(int index) {

		long result = 0;
		final long[] fibCache = new long[200];

		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else if (fibCache[index] != 0) {
			return fibCache[index];
		} else {
			result = fibonacci(index - 1) + fibonacci(index - 2);
			fibCache[index] = result;
			return result;
		}
	}

}
