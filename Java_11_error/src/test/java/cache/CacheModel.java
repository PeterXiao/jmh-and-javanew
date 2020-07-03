/**
 *
 */
package cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheModel {
	public Student getStudent(Integer key) {
		System.out.println("load student " + key);
		final Student student = new Student();
		student.setId(key);
		student.setName("name " + key);
		return student;
	}

	// load Method
	public void loadCacheA() throws Exception {
		final LoadingCache<Integer, Student> studentCache = CacheBuilder.newBuilder().concurrencyLevel(8)
				.expireAfterWrite(8, TimeUnit.SECONDS).refreshAfterWrite(1, TimeUnit.SECONDS).initialCapacity(10)
				.maximumSize(100).recordStats()
				.removalListener(notification -> System.out
						.println(notification.getKey() + " was removed, cause is " + notification))
				.build(new CacheLoader<Integer, Student>() {
					@Override
					public Student load(Integer key) throws Exception {
						return getStudent(key);
					}
				});

		for (int i = 0; i < 20; i++) {
			final Student student = studentCache.get(1);
			System.out.println(student);
			TimeUnit.SECONDS.sleep(1);
		}

		System.out.println("cache stats:");
		System.out.println(studentCache.stats().toString());

	}

	// call back Method
	public void loadCacheB(final Integer key) throws Exception {
		final Cache<Integer, Student> cache = CacheBuilder.newBuilder().maximumSize(1000).recordStats()
				.expireAfterWrite(8, TimeUnit.SECONDS).build();

		for (int i = 0; i < 20; i++) {
			System.out.println(cache.get(key, () -> getStudent(key)));
			TimeUnit.SECONDS.sleep(1);
		}

		System.out.println("cache stats:");
		System.out.println(cache.stats().toString());
	}

	public static void main(String[] args) throws Exception {
		final CacheModel cache = new CacheModel();
		cache.loadCacheB(2);
	}

}