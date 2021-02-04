/**  
* @Title: CacheLoaderTest.java
* @Package luozix.start.exams.caches.guava
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:14:50
* @version V1.0  
*/
package luozix.start.exams.caches.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
/**
* @ClassName: CacheLoaderTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:14:50
*
*/
public class CacheLoaderTest {
	private final static Logger LOGGER = LoggerFactory.getLogger(CacheLoaderTest.class);
	private LoadingCache<Integer, AtomicLong> loadingCache;
	private final static Integer KEY = 1000;

	private final static LinkedBlockingQueue<Integer> QUEUE = new LinkedBlockingQueue<>(1000);

	private void init() throws InterruptedException {
		loadingCache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS)
				.removalListener(new RemovalListener<Object, Object>() {
					@Override
					public void onRemoval(RemovalNotification<Object, Object> notification) {
						LOGGER.info("删除原因={}，删除 key={},删除 value={}", notification.getCause(), notification.getKey(),
								notification.getValue());
					}
				}).build(new CacheLoader<Integer, AtomicLong>() {
					@Override
					public AtomicLong load(Integer key) throws Exception {
						return new AtomicLong(0);
					}
				});

		for (int i = 10; i < 15; i++) {
			QUEUE.put(i);
		}
	}

	private void checkAlert(Integer integer) {
		try {

			// loadingCache.put(integer,new AtomicLong(integer));

			TimeUnit.SECONDS.sleep(3);

			LOGGER.info("当前缓存值={},缓存大小={}", loadingCache.get(KEY), loadingCache.size());
			LOGGER.info("缓存的所有内容={}", loadingCache.asMap().toString());
			loadingCache.get(KEY).incrementAndGet();

		} catch (ExecutionException e) {
			LOGGER.error("Exception", e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CacheLoaderTest cacheLoaderTest = new CacheLoaderTest();
		cacheLoaderTest.init();

		while (true) {

			try {
				Integer integer = QUEUE.poll(200, TimeUnit.MILLISECONDS);
				if (null == integer) {
					break;
				}
				// TimeUnit.SECONDS.sleep(5);
				cacheLoaderTest.checkAlert(integer);
				LOGGER.info("job running times={}", integer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
