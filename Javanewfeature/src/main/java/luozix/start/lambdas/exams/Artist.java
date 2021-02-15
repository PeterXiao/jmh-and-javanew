    /** 
	 * Project Name:java11_in_action 
	 * File Name:Artist.java 
	 * Package Name:luozix.start.lambdas 
	 * Date:2021年2月14日下午3:54:11 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Artist.java
* @Package luozix.start.lambdas
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月14日 下午3:54:11
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams;  
	/** 
	 * ClassName:Artist <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月14日 下午3:54:11 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import static java.util.stream.Collectors.toList;

	/**
	* @ClassName: Artist
	* @Description: TODO(这里用一句话描述这个类的作用)
	* @author xiaoyulong xiaoyulong07@outlook.com
	* @date 2021年2月14日 下午3:54:11
	* @version  
	*@since JDK 1.8
	*/
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Objects;
	import java.util.stream.Stream;

	public final class Artist {

		private String name;
		private List<Artist> members;
		private String nationality;

		public Artist(String name, String nationality) {
			this(name, Collections.emptyList(), nationality);
		}

		public Artist(String name, List<Artist> members, String nationality) {
			Objects.requireNonNull(name);
			Objects.requireNonNull(members);
			Objects.requireNonNull(nationality);
			this.name = name;
			this.members = new ArrayList<>(members);
			this.nationality = nationality;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the members
		 */
		public Stream<Artist> getMembers() {
			return members.stream();
		}

		/**
		 * @return the nationality
		 */
		public String getNationality() {
			return nationality;
		}

		public boolean isSolo() {
			return members.isEmpty();
		}

		public boolean isFrom(String nationality) {
			return this.nationality.equals(nationality);
		}

		@Override
		public String toString() {
			return getName();
		}

		public Artist copy() {
			List<Artist> members = getMembers().map(Artist::copy).collect(toList());
			return new Artist(name, members, nationality);
		}

	}
