/**
 * 
 */
package luozix.start.alg;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import junit.framework.Assert;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author xiaoy
 *
 */
public class LinkTestTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(HeapOOM.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
						throws Throwable {
					return methodProxy.invoke(o, objects);
				}
			});
			enhancer.create();

		}
	}

	@Test
	public void test() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		map.put("5", 5);
		System.out.println(map.toString());

	}

	@Test
	public void guavaTest() {
		long star = System.currentTimeMillis();
		BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);

		for (int i = 0; i < 10000000; i++) {
			filter.put(i);
		}

		Assert.assertTrue(filter.mightContain(1));
		Assert.assertTrue(filter.mightContain(2));
		Assert.assertTrue(filter.mightContain(3));
		Assert.assertFalse(filter.mightContain(10000000));
		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - star));
	}
}
