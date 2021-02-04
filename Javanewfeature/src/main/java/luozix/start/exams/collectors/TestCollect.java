/**  
* @Title: TestCollect.java
* @Package luozix.start.exams.collectors
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午5:16:33
* @version V1.0  
*/
package luozix.start.exams.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* @ClassName: TestCollect
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午5:16:33
*
*/
public class TestCollect {

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
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
		integers.stream().map(x -> x * x).collect(Collectors.toList());

		// 输出: [1,4,9,16,25,36,36]

		integers.stream().map(x -> x * x).collect(Collectors.toSet());

		// 输出: [1,4,9,16,25,36]
		integers.stream().filter(x -> x > 2).collect(Collectors.toCollection(LinkedList::new));

		// 输出: [3,4,5,6,6]
		Long collect = integers.stream().filter(x -> x < 4).collect(Collectors.counting());

		// 输出: 3
		List<String> strings = Arrays.asList("alpha", "beta", "gamma");
		integers.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();

		// 输出: 1

		strings.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();

		// 输出: alpha
		// List<String> strings = Arrays.asList("alpha", "beta", "gamma");
		integers.stream().collect(Collectors.minBy(Comparator.reverseOrder())).get();
		// 输出: 6
		strings.stream().collect(Collectors.minBy(Comparator.reverseOrder())).get();
		// 输出: gamma

		strings.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		// 输出: gamma

		Map<Boolean, List<String>> collect1 = strings.stream().collect(Collectors.partitioningBy(x -> x.length() > 2));
		// 输出: {false=[a], true=[alpha, beta, gamma]}

		List<String> collect2 = strings.stream().collect(Collectors.toUnmodifiableList());
		// 输出: ["alpha","beta","gamma"]

		Set<String> readOnlySet = strings.stream().sorted().collect(Collectors.toUnmodifiableSet());
		// 输出: ["alpha","beta","gamma"]

		String collect3 = strings.stream().distinct().collect(Collectors.joining(","));
		// 输出: alpha,beta,gamma
		String collect4 = strings.stream().map(s -> s.toString()).collect(Collectors.joining(",", "[", "]"));
		// 输出: [alpha,beta,gamma]
		List<Long> longValues = Arrays.asList(100l, 200l, 300l);
		Double d1 = longValues.stream().collect(Collectors.averagingLong(x -> x * 2));
		// 输出: 400.0

		Double d2 = integers.stream().collect(Collectors.averagingInt(x -> x * 2));
		// 输出: 7.714285714285714
		List<Double> doubles = Arrays.asList(1.1, 2.0, 3.0, 4.0, 5.0, 5.0);
		Double d3 = doubles.stream().collect(Collectors.averagingDouble(x -> x));
		// 输出: 3.35

		Map<String, Integer> map = strings.stream().collect(Collectors.toMap(Function.identity(), String::length));
		// 输出: {alpha=5, beta=4, gamma=5}

		List<String> stringss = Arrays.asList("alpha", "beta", "gamma", "beta");
		Map<String, Integer> maps = stringss.stream()
				.collect(Collectors.toMap(Function.identity(), String::length, (i1, i2) -> i1));
		// 输出: {alpha=5, gamma=5, beta=4}

		Integer collect41 = strings.stream().collect(Collectors.summingInt(String::length));
		// 输出: 18

		Integer sum = integers.stream().collect(Collectors.summingInt(x -> x));
		// 输出: 27

		List<Double> doubleValues = Arrays.asList(1.1, 2.0, 3.0, 4.0, 5.0, 5.0);
		Double sumDouble = doubleValues.stream().collect(Collectors.summingDouble(x -> x));
		// 输出: 20.1

		// List<Long> longValues = Arrays.asList(100l,200l,300l);
		Long sumLong = longValues.stream().collect(Collectors.summingLong(x -> x));
		// 输出: 600

		List<Integer> integers1s = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
		IntSummaryStatistics stats = integers1s.stream().collect(Collectors.summarizingInt(x -> x));
		// 输出: IntSummaryStatistics{count=7, sum=27, min=1, average=3.857143, max=6}
//		stats.getAverage(); // 3.857143
//		stats.getMax(); // 6
//		stats.getMin(); // 1
//		stats.getCount(); // 7
//		stats.getSum(); // 27
//		GroupingBy()可以在集合中创建map。
//
//		示例代码：将字符串长度作为键，将该长度的字符串列表作为值
		List<String> strings1ss = Arrays.asList("alpha", "beta", "gamma");
		Map<Integer, List<String>> collects = strings1ss.stream().collect(Collectors.groupingBy(String::length));
		// 输出: {4=[beta, beta], 5=[alpha, gamma]}

		// 示例代码2:指定了map中所需列表的类型（链接列表）。

		List<String> stringsMap = Arrays.asList("alpha", "beta", "gamma");
		Map<Integer, LinkedList<String>> collectmap = stringsMap.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.toCollection(LinkedList::new)));
		// 输出: {4=[beta, beta], 5=[alpha, gamma]}

		System.out.println(collectmap);
	}

}
