package io.github.biezhi.java11.collections;

import static java.util.Map.entry;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 这个例子中感受一些新版本改(chao)进(xi)的集合 API。
 *
 * @author biezhi
 * @date 2018/7/10
 */
public class Example {

	public static void main(String[] args) {

		// 空列表，数据类型为 Object
		List immutableList = List.of();

		// 创建 List<String>
		var foo = List.of("biezhi", "github", "王爵的技术小黑屋");

		// 空 Map，Key 和 Value 类型都是 Object
		Map emptyImmutableMap = Map.of();

		// 快速创建一个 Map
		var mmp = Map.of(2017, "先赚他一个亿", 2018, "去年的梦想可能有点儿夸张");

		// 使用 Entries 创建一个 Map
		Map<Integer, String> emptyEntryMap = Map.ofEntries(
				entry(20, "装逼"),
				entry(30, "单身"),
				entry(40, "回家种地")
				);

		// 创建一个 Map.Entry
		Map.Entry<String, String> immutableMapEntry = Map.entry("biezhi", "emmmm");
		// 其实和上面的代码片段是一样一样的
		Map.ofEntries(immutableMapEntry);

		// 创建一个空 Set<String>
		Set<String> immutableSet = Set.of();

		// 快速创建一个 Set<String>
		Set<String> bar = Set.of("我", "可能", "是个", "假的", "程序员");

		var javastack = "javastack";

		System.out.println(javastack);

		// 判断字符串是否为空白

		" ".isBlank();                // true

		// 去除首尾空格

		" Javastack ".strip();          // "Javastack"

		// 去除尾部空格

		" Javastack ".stripTrailing();  // " Javastack"

		// 去除首部空格

		" Javastack ".stripLeading();   // "Javastack "

		// 复制字符串

		"Java".repeat(3);             // "JavaJavaJava"

		// 行数统计

		"A\nB\nC".lines().count();    // 3
		//示例1：

		var list = List.of("Java", "Python", "C");

		var copy = List.copyOf(list);

		System.out.println(list == copy);   // true
		//示例2：

		//		var list = new ArrayList<String>();
		//
		//		var copy = List.copyOf(list);
		//
		//		System.out.println(list == copy);   // false

		//		1）增加单个参数构造方法，可为null
		//
		//		Stream.ofNullable(null).count(); // 0
		//		2）增加takeWhile和dropWhile方法

		Stream.of(1, 2, 3, 2, 1)

		.takeWhile(n -> n < 3)

		.collect(Collectors.toList());  // [1, 2]
		//从开始计算，当n <3时就截止。

		//		Stream.of(1, 2, 3, 2, 1)
		//
		//		    .dropWhile(n -> n < 3)
		//
		//		    .collect(Collectors.toList());  // [3, 2, 1]
		Optional.of("javastack").orElseThrow();     // javastack

		Optional.of("javastack").stream().count();  // 1

		Optional.ofNullable(null)

		.or(() -> Optional.of("javastack"))

		.get();   // javastack

		//		var classLoader = ClassLoader.getSystemClassLoader();
		//
		//		var inputStream = classLoader.getResourceAsStream("javastack.txt");
		//
		//		var javastack = File.createTempFile("javastack2", "txt");
		//
		//		try (var outputStream = new FileOutputStream(javastack)) {
		//
		//		    inputStream.transferTo(outputStream);
		//
		//		}

		var request = HttpRequest.newBuilder()

				.uri(URI.create("https://javastack.cn"))

				.GET()

				.build();

		var client = HttpClient.newHttpClient();

		// 同步

		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.body());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		// 异步

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())

		.thenApply(HttpResponse::body)

		.thenAccept(System.out::println);
	}

}
