/**  
* @Title: TestCunsumer.java
* @Package luozix.start.java8.action.beans.lesson3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午7:10:26
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson3;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @ClassName: TestCunsumer
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午7:10:26
*
*/
public class TestCunsumer {

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
		forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));

		List<Integer> list = map(
			 Arrays.asList("lambdas","in","action"),
			 (String s) -> s.length()
		);
		
		System.out.println(list.toString());

		IntPredicate evenNumbersIntPredicate = (int i) -> i % 2 == 0;

		evenNumbersIntPredicate.test(1000); // 无装箱

		Predicate<Integer> oddPredicate = (Integer i) -> i % 2 == 1;

		oddPredicate.test(1000);

		System.out.println(oddPredicate.test(1000));

		BufferedReaderProcessor processor = (BufferedReader br) -> br.readLine();
		
//		Fuction<BufferedReader, String> f = (BufferedReader b)->
//		{
//			try {
//				return b.readLine();
//			}catch(IOException e) {
//				throw new RuntimeException(e);
//			}
//		}
		int portNumber = 1337;
		Runnable runnable = () -> System.out.println(portNumber);
		List<String> strings = Arrays.asList("a", "b", "A", "B");
		strings.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(strings);
		strings.sort(String::compareToIgnoreCase);

		// Supplier<Apple> cSupplier = Apple::new;

//		Function<Integer,Apple> cFunction = Apple::new;
//		Apple a2 = cFunction.apply(110);

		List<Integer> weightsIntegers = Arrays.asList(7, 3, 4, 10);
		// List<Apple> apples = map(weightsIntegers, Apple::new);


	}

	public static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for (T i : list) {
			consumer.accept(i);
		}

	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> resultList = new ArrayList<>();
		for (T s : list) {
			resultList.add(f.apply(s));
		}

		return resultList;
	}

	@FunctionalInterface
	interface Function<T, R> {
		R apply(T t);
	}

	interface IntPredicate {
		boolean test(int t);
	}
}


