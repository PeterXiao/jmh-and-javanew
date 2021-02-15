    /** 
	 * Project Name:java11_in_action 
	 * File Name:RefactorTo.java 
	 * Package Name:luozix.start.lambdas.exams.examples.chapter3 
	 * Date:2021年2月15日上午11:05:05 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: RefactorTo.java
* @Package luozix.start.lambdas.exams.examples.chapter3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 上午11:05:05
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.examples.chapter3;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import luozix.start.lambdas.exams.examples.chapter1.Album;
import luozix.start.lambdas.exams.examples.chapter1.Track;
/** 
	 * ClassName:RefactorTo <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月15日 上午11:05:05 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

/**
* @ClassName: RefactorTo
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 上午11:05:05
* @version  
*@since JDK 1.8
*/
public class RefactorTo {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月15日 上午11:05:05.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Set<String> findLongTracks(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		for (Album album : albums) {
			for (Track track : album.getTrackList()) {
				if (track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			}
		}
		return trackNames;
	}

	public Set<String> findLongTracksStream(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream().forEach(album -> {
			album.getTracks().forEach(track -> {
				if (track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			});
		});
		return trackNames;
	}

	public Set<String> findLongTracksStream01(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream().forEach(album -> {
			album.getTracks().filter(track -> track.getLength() > 60).map(track -> track.getName())
					.forEach(name -> trackNames.add(name));
		});
		return trackNames;
	}

	public Set<String> findLongTracksStream0102(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();

		albums.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60)
				.map(track -> track.getName()).forEach(name -> trackNames.add(name));

		return trackNames;
	}

	public Set<String> findLongTracksStreamEnd(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60)
				.map(track -> track.getName()).collect(toSet());
	}

}
