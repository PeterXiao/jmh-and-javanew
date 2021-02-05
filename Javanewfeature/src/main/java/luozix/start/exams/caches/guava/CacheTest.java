/**  
* @Title: CacheTest.java
* @Package luozix.start.exams.caches.guava
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午9:37:41
* @version V1.0  
*/
package luozix.start.exams.caches.guava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
* @ClassName: CacheTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午9:37:41
*
*/
public class CacheTest {

	/**
	 * @param args
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoadingCache<Integer, String> numberTranlation = CacheBuilder.newBuilder().maximumSize(10) // 最大能缓存的容量
				.expireAfterAccess(1, TimeUnit.DAYS) // 过期策略：1天没被访问后过期
				.recordStats() // 开启统计功能
				.build(new CacheLoader<Integer, String>() {

					@Override
					public String load(Integer key) throws Exception {
						// TODO Auto-generated method stub
						return new AtomicLong(0).toString();
					}
//					@Override
//					public String load(Integer integer) throws Exception {
//						return NumberTranslationApi.translation(integer);
//					}
				});
	}

}
