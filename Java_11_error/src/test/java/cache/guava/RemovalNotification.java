/**
 *
 */
package cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;

/**
 * @author LiY
 * @time 下午5:35:42
 */
/**
 * 移除监听
 * <p>
 * 通过CacheBuilder.removalListener(RemovalListener)，你可以声明一个监听器，以便缓存项被移除时做一些额外操作。
 * 缓存项被移除时，RemovalListener会获取移除通知[RemovalNotification]，其中包含移除原因[RemovalCause]、键和值。
 *
 *
 */
public class RemovalNotification {

	public static void main(String[] args) {
		CacheLoader<String, String> loader;
		loader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return "找不到: " + key;
			}
		};

		RemovalListener<String, String> listener;
		listener = n -> {
			if (n.wasEvicted()) {
				final String cause = n.getCause().name();
				System.out.println(RemovalCause.SIZE.toString().equals(cause));
			}
		};

		LoadingCache<String, String> cache;
		cache = CacheBuilder.newBuilder().maximumSize(3).removalListener(listener).build(loader);

		cache.getUnchecked("first");
		cache.getUnchecked("second");
		cache.getUnchecked("third");
		cache.getUnchecked("last");

		System.out.println("Cache Size: " + cache.size());
	}

}
