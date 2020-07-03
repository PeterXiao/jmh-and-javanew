/**
 *
 */
package cache;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author LiY
 * @time 下午3:44:18
 */
public class Demo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CompletableFuture<Void> subTask = null;
		// The publisher is closed when the try block exits
		try (SubmissionPublisher<Long> pub = new SubmissionPublisher<>()) {
			// Print the buffer size used for each subscriber
			System.out.println("Subscriber Buffer Size: " + pub.getMaxBufferCapacity());
			// Add a subscriber to the publisher. The subscriber prints the published
			// elements
			subTask = pub.consume(System.out::println);
			// Generate and publish five integers
			LongStream.range(1L, 6L).forEach(pub::submit);
		}
		if (subTask != null) {
			try {
				// Wait until the subscriber is complete
				subTask.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			// 当guava cache中不存在，则会调用load方法
			@Override
			public String load(String key) {
				return "找不到数据:" + key;
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder()
				// 写数据1s后重新加载缓存
				.refreshAfterWrite(1L, TimeUnit.SECONDS).build(loader);

		System.out.println("Cache Size: " + cache.size());

		cache.put("test", "test");

		System.out.println(cache.getUnchecked("test"));
		System.out.println(cache.getUnchecked("hello"));
		System.out.println("Cache Size: " + cache.size());

		TimeUnit.SECONDS.sleep(2);

		System.out.println(cache.getUnchecked("test"));
	}

}