/**  
* @Title: StreamVsCollection.java
* @Package luozix.start.java8.action.beans.lesson4
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:22:06
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson4;
/**
* @ClassName: StreamVsCollection
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 上午9:22:06
*
*/
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {

	public static void main(String... args) {
		List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
		Stream<String> s = names.stream();
		s.forEach(System.out::println);
		// uncommenting this line will result in an IllegalStateException
		// because streams can be consumed only once 和迭代器一样只能消费一次
		// stream可以看作时间分布的一组值，otherwise，collectio 则是空间分布（逻辑内存）的一组值
		// s.forEach(System.out::println);
		// 显式迭代
		for (Iterator iterator = names.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();

		}
		for (String string : names) {

		}

		System.out.println("**************************");
		Stream<String> spStream = names.parallelStream();
		spStream.forEach(System.out::println);

	}
}