/**
 *
 */
package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
/**
 * @author LiY
 *
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.jupiter.api.Test;

public class CacheDemo {
	/**
	 * 缓存器,这里假设需要存储1000左右个缓存对象，按照默认的负载因子0.75，则容量=750，大概估计每一个节点链表长度为5个
	 * 那么数组长度大概为：150,又有雨设置map大小一般为2的指数，则最近的数字为：128
	 */
	private final Map<String, Object> map = new HashMap<>(128);
	private final ReadWriteLock rwl = new ReentrantReadWriteLock();

	public static void main(String[] args) throws IOException {
		final BufferedReader reader1 = new BufferedReader(new FileReader("./README.md"));
		try (reader1) {
			while (reader1.ready()) {
				System.out.println(reader1.readLine());
			}
		}

		final var list = new ArrayList<String>(); // 自动推断 ArrayList<String>
		final var stream = list.stream(); // 自动推断 Stream<String>

		final var newList = List.of("hello", "biezhi");
		newList.forEach(System.out::println);

		final String fileName = "./pom.xml";

		final var path = Paths.get(fileName);
		final var bytes = Files.readAllBytes(path);

		System.out.println("字节数组: " + bytes);

		for (final var b : bytes) {
			// TODO
		}

		try (var foo = new FileInputStream(new File(""))) {
			System.out.println(foo);
		} catch (final Exception e) {
			// ignore
		}

	}

	@Test
	public void testFiles() throws IOException {
		final String text = "Hello biezhi.";

		// 写入文本
		Files.writeString(Paths.get("hello.txt"), text);

		// 读取文本
		final String readText = Files.readString(Paths.get("hello.txt"));
		System.out.println(text.equals(readText));

		// 删除文本
		Files.delete(Paths.get("hello.txt"));

		final long day = TimeUnit.DAYS.convert(Duration.ofHours(24));
		System.out.println(day == 1);

		// 1 天
		System.out.println(TimeUnit.DAYS.convert(Duration.ofHours(26)));

		// 1 分钟
		System.out.println(TimeUnit.MINUTES.convert(Duration.ofSeconds(60)));
	}

	public Object get(String id) {
		Object value = null;
		rwl.readLock().lock();// 首先开启读锁，从缓存中去取
		try {
			if (map.get(id) == null) { // 如果缓存中没有释放读锁，上写锁
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if (value == null) { // 防止多写线程重复查询赋值
						value = "redis-value"; // 此时可以去数据库中查找，这里简单的模拟一下
					}
					rwl.readLock().lock(); // 加读锁降级写锁,不明白的可以查看上面锁降级的原理与保持读取数据原子性的讲解
				} finally {
					rwl.writeLock().unlock(); // 释放写锁
				}
			}
		} finally {
			rwl.readLock().unlock(); // 最后释放读锁
		}
		return value;
	}
}