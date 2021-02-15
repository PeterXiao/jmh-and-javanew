    /** 
	 * Project Name:java11_in_action 
	 * File Name:lamdbas.java 
	 * Package Name:luozix.start.lambdas 
	 * Date:2021年2月14日下午5:02:56 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: lamdbas.java
* @Package luozix.start.lambdas
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月14日 下午5:02:56
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
* @ClassName: lamdbas
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月14日 下午5:02:56
* @version  
*@since JDK 1.8
*/
public class lamdbas {
	public static void main(String[] args) {
		List<String> collected = new ArrayList<>();
		for (String string : Arrays.asList("a", "b", "hello")) {
			String uppercaseString = string.toUpperCase();
			collected.add(uppercaseString);
		}

		assertEquals(Arrays.asList("A", "B", "HELLO"), collected);

		List<String> collectedstream = Stream.of("a", "b", "hello").map(string -> string.toUpperCase())
				.collect(toList());
		 
		assertEquals(Arrays.asList("A", "B", "HELLO"), collectedstream);
		List<Integer> numbers = asList(1, 2, 3, 4);

		List<Integer> sameOrder = numbers.stream().collect(toList());
		assertEquals(numbers, sameOrder);

		Set<Integer> numbers1 = new HashSet<>(asList(4, 3, 2, 1));

		List<Integer> sameOrder1 = numbers1.stream().collect(toList());

		// 该断言有时会失败 assertEquals(asList(4, 3, 2, 1), sameOrder);
		List<Artist> artists = new ArrayList<>();

		// stream.collect(toCollection(TreeSet::new));

	}

	@Test
	public void testStream() {
		Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));

		List<Integer> sameOrder = numbers.stream().sorted().collect(toList());

		assertEquals(asList(1, 2, 3, 4), sameOrder);
	}

	@Test
	public void tests()
	{
		List<Integer> numbers = asList(1, 2, 3, 4);

		List<Integer> stillOrdered = numbers.stream().map(x -> x + 1).collect(toList());

		// 顺序得到了保留 assertEquals(asList(2, 3, 4, 5), stillOrdered);

		Set<Integer> unordered = new HashSet<>(numbers);

		List<Integer> stillUnordered = unordered.stream().map(x -> x + 1).collect(toList());

		// 顺序得不到保证
		assertThat(stillUnordered, hasItem(2));
		assertThat(stillUnordered, hasItem(3));
		assertThat(stillUnordered, hasItem(4));
		assertThat(stillUnordered, hasItem(5));

	}

//	public Optional<Artist> biggestGroup(Stream<Artist> artists) {
//		Function<Artist, Long> getCount = artist -> artist.getMembers().count();
//		return artists.collect(maxBy(comparing(getCount)));
//	}
//	public double averageNumberOfTracks(List<Album> albums) {
//		return albums.stream().collect(averagingInt(album -> album.getTrackList().size()));
//	}
//	public Optional<Artist> biggestGroup(Stream<Artist> artists) {
//		Function<Artist, Long> getCount = artist -> artist.getMembers().count();
//		return artists.collect(maxBy(comparing(getCount)));
//	}
//
//	public double averageNumberOfTracks(List<Album> albums) {
//		return albums.stream().collect(averagingInt(album -> album.getTrackList().size()));
//	}



}
