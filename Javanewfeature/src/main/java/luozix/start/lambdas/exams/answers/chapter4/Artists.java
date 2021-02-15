    /** 
	 * Project Name:java11_in_action 
	 * File Name:Artists.java 
	 * Package Name:luozix.start.lambdas.exams.answers.chapter4 
	 * Date:2021年2月15日下午12:58:43 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Artists.java
* @Package luozix.start.lambdas.exams.answers.chapter4
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 下午12:58:43
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.answers.chapter4;  
	/** 
	 * ClassName:Artists <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月15日 下午12:58:43 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import java.util.List;

	import luozix.start.lambdas.exams.examples.chapter1.Artist;

/**
* @ClassName: Artists
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 下午12:58:43
* @version  
*@since JDK 1.8
*/
public class Artists {

	private List<Artist> artists;

	public Artists(List<Artist> artists) {
		this.artists = artists;
	}

	public Artist getArtist(int index) {
		if (index < 0 || index >= artists.size()) {
			indexException(index);
		}
		return artists.get(index);
	}

	private void indexException(int index) {
		throw new IllegalArgumentException(index + "doesn't correspond to an Artist");
	}

	public String getArtistName(int index) {
		try {
			Artist artist = getArtist(index);
			return artist.getName();
		} catch (IllegalArgumentException e) {
			return "unknown";
		}
	}

}