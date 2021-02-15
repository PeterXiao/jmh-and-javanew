/** 
 * Project Name:java11_in_action 
 * File Name:FlatMapStream.java 
 * Package Name:luozix.start.lambdas.exams.examples.chapter3 
 * Date:2021年2月15日上午10:50:20 
 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
 * 
*/
/**  
* @Title: FlatMapStream.java
* @Package luozix.start.lambdas.exams.examples.chapter3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 上午10:50:20
* @version V1.0  
*/

package luozix.start.lambdas.exams.examples.chapter3;

/** 
 * ClassName:FlatMapStream <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2021年2月15日 上午10:50:20 <br/> 
 * @author   xiaoy 
 * @version   
 * @since    JDK 1.8
 * @see       
 */

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import luozix.start.lambdas.exams.examples.chapter1.Track;

/**
 * @ClassName: FlatMapStream
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年2月15日 上午10:50:20
 * @version
 * @since JDK 1.8
 */
public class FlatMapStream {

	/**
	 * @Title: main @Description: TODO(这里用一句话描述这个方法的作用) @param @param args
	 *         设定文件 @return void 返回类型 date: 2021年2月15日 上午10:50:20.<br/>
	 *         @author xiaoy @param args @since JDK 1.8 @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> togetherIntegers = Stream.of(asList(1, 2), asList(3, 4)).flatMap(numbers -> numbers.stream())
				.collect(toList());
		assertEquals(asList(1, 2, 3, 4), togetherIntegers);

		List<Track> tracks = asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378),
				new Track("Time Was", 451));

		Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();

		assertEquals(tracks.get(1), shortestTrack);

		List<Track> tracks1 = asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378),
				new Track("Time Was", 451));

		Track shortestTrack1 = tracks1.get(0);
		for (Track track : tracks1) {
			if (track.getLength() < shortestTrack1.getLength()) {
				shortestTrack1 = track;
			}
		}

		assertEquals(tracks1.get(1), shortestTrack1);

		int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);

		assertEquals(6, count);

		BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
		int countReduce = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);

		// Set<String> origins = album.getMusicians() .filter(artist ->
		// artist.getName().startsWith("The")) .map(artist -> artist.getNationality())
		// .collect(toSet());
//		Set<String> origins = album.getMusicians().filter(artist -> artist.getName().startsWith("The"))
//				.map(artist -> artist.getNationality()).collect(toSet());
	}

}
