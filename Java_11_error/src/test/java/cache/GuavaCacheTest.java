/**
 *
 */
package cache;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;

/**
 * @author LiY
 * @time 下午3:46:14
 */
public class GuavaCacheTest {

	/**
	 *
	 * guava Cache数据移除： guava做cache时候数据的移除方式，在guava中数据的移除分为被动移除和主动移除两种。
	 * 被动移除数据的方式，guava默认提供了三种方式：
	 * 1.基于大小的移除:看字面意思就知道就是按照缓存的大小来移除，如果即将到达指定的大小，那就会把不常用的键值对从cache中移除。 定义的方式一般为
	 * CacheBuilder.maximumSize(long)，还有一种一种可以算权重的方法，个人认为实际使用中不太用到。就这个常用的来看有几个注意点，
	 * 其一，这个size指的是cache中的条目数，不是内存大小或是其他；
	 * 其二，并不是完全到了指定的size系统才开始移除不常用的数据的，而是接近这个size的时候系统就会开始做移除的动作；
	 * 其三，如果一个键值对已经从缓存中被移除了，你再次请求访问的时候，如果cachebuild是使用cacheloader方式的，那依然还是会从cacheloader中再取一次值，如果这样还没有，就会抛出异常
	 * 2.基于时间的移除：guava提供了两个基于时间移除的方法 expireAfterAccess(long, TimeUnit)
	 * 这个方法是根据某个键值对最后一次访问之后多少时间后移除 expireAfterWrite(long, TimeUnit)
	 * 这个方法是根据某个键值对被创建或值被替换后多少时间移除 3.基于引用的移除： 这种移除方式主要是基于java的垃圾回收机制，根据键或者值的引用关系决定移除
	 * 主动移除数据方式，主动移除有三种方法： 1.单独移除用 Cache.invalidate(key) 2.批量移除用
	 * Cache.invalidateAll(keys) 3.移除所有用 Cache.invalidateAll()
	 * 如果需要在移除数据的时候有所动作还可以定义Removal Listener，但是有点需要注意的是默认Removal
	 * Listener中的行为是和移除动作同步执行的，如果需要改成异步形式，可以考虑使用RemovalListeners.asynchronous(RemovalListener,
	 * Executor)
	 *
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// TODO Auto-generated method stub
		final LoadingCache<Integer, String> localCache = CacheBuilder.newBuilder()
				// 设置并发级别为8，并发级别是指可以同时写缓存的线程数
				.concurrencyLevel(8)
				// 最大容量
				.maximumSize(200000)
				// 初始容量
				.initialCapacity(100000)
				// 写入后5秒过期
				.expireAfterWrite(5, TimeUnit.SECONDS)
				// 统计缓存的命中率
				.recordStats()
				// 设置缓存移除通知
				.removalListener(new RemovalListener<Integer, String>() {

					public void onRemoval1(RemovalNotification<Integer, String> notification) {
						System.out.println(notification.getKey() + " was removed,cause is " + notification.getCause());
					}

					@Override
					public void onRemoval(RemovalNotification<Integer, String> notification) {
						// TODO Auto-generated method stub

					}
				}).build(new CacheLoader<Integer, String>() {

					// 在缓存不存在时，通过CacheLoader自动加载缓存
					@Override
					public String load(Integer key) throws Exception {
						System.out.println("load data:" + key);
						return key + "对应的 value";
					}

				});

		// ------------

		for (int i = 1; i <= 10; i++) {
			System.out.println("key:" + i + ",value:" + localCache.get(i));
			System.out.println("key:" + i + ",value:" + localCache.get(i));
			// 休眠2s
			Thread.sleep(2000);

			// 打印缓存中的命中情况
			System.out.println("cache status:");
			System.out.println(localCache.stats().toString());
		}
	}

	@Test
	public void whenCacheMiss_thenValueIsComputed() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().build(loader);

		assertEquals(0, cache.size());
		assertEquals("HELLO", cache.getUnchecked("hello"));
		assertEquals(1, cache.size());
	}

	@Test
	public void whenCacheReachMaxSize_thenEviction() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};
		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().maximumSize(3).build(loader);

		cache.getUnchecked("first");
		cache.getUnchecked("second");
		cache.getUnchecked("third");
		cache.getUnchecked("forth");
		assertEquals(3, cache.size());
		assertNull(cache.getIfPresent("first"));
		assertEquals("FORTH", cache.getIfPresent("forth"));
	}

	@Test
	public void whenCacheReachMaxWeight_thenEviction() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		Weigher<String, String> weighByLength;
		weighByLength = (key, value) -> value.length();

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().maximumWeight(16).weigher(weighByLength).build(loader);

		cache.getUnchecked("first");
		cache.getUnchecked("second");
		cache.getUnchecked("third");
		cache.getUnchecked("last");
		assertEquals(3, cache.size());
		assertNull(cache.getIfPresent("first"));
		assertEquals("LAST", cache.getIfPresent("last"));
	}

	@Test
	public void whenEntryIdle_thenEviction() throws InterruptedException {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.MILLISECONDS).build(loader);

		cache.getUnchecked("hello");
		assertEquals(1, cache.size());

		cache.getUnchecked("hello");
		Thread.sleep(300);

		cache.getUnchecked("test");
		assertEquals(1, cache.size());
		assertNull(cache.getIfPresent("hello"));
	}

	@Test
	public void whenEntryLiveTimeExpire_thenEviction() throws InterruptedException {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.MILLISECONDS).build(loader);

		cache.getUnchecked("hello");
		assertEquals(1, cache.size());
		Thread.sleep(300);
		cache.getUnchecked("test");
		assertEquals(1, cache.size());
		assertNull(cache.getIfPresent("hello"));
	}

	@Test
	public void whenWeakKeyHasNoRef_thenRemoveFromCache() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().weakKeys().build(loader);
	}

	@Test
	public void whenSoftValue_thenRemoveFromCache() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().softValues().build(loader);
	}

	@Test
	public void whenNullValue_thenOptional() {
		CacheLoader<String, Optional<String>> loader;
		loader = new CacheLoader<String, Optional<String>>() {
			@Override
			public Optional<String> load(String key) {
				return Optional.fromNullable(getSuffix(key));
			}
		};

		LoadingCache<String, Optional<String>> cache;
		cache = CacheBuilder.newBuilder().build(loader);

		assertEquals("txt", cache.getUnchecked("text.txt").get());
		assertFalse(cache.getUnchecked("hello").isPresent());
	}

	private String getSuffix(final String str) {
		final int lastIndex = str.lastIndexOf('.');
		if (lastIndex == -1) {
			return null;
		}
		return str.substring(lastIndex + 1);
	}

	@Test
	public void whenLiveTimeEnd_thenRefresh() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES).build(loader);
	}

	@Test
	public void whenPreloadCache_thenUsePutAll() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().build(loader);

		final Map<String, String> map = new HashMap<String, String>();
		map.put("first", "FIRST");
		map.put("second", "SECOND");
		cache.putAll(map);

		assertEquals(2, cache.size());
	}

	@Test
	public void whenEntryRemovedFromCache_thenNotify() {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(final String key) {
				return key.toUpperCase();
			}
		};

		RemovalListener<String, String> listener;
		listener = n -> {
			if (n.wasEvicted()) {
				final String cause = n.getCause().name();
				assertEquals(RemovalCause.SIZE.toString(), cause);
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().maximumSize(3).removalListener(listener).build(loader);

		cache.getUnchecked("first");
		cache.getUnchecked("second");
		cache.getUnchecked("third");
		cache.getUnchecked("last");
		assertEquals(3, cache.size());
	}

}
