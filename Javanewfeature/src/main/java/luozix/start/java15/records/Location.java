    /** 
	 * Project Name:java11_in_action 
	 * File Name:Location.java 
	 * Package Name:luozix.start.java15.records 
	 * Date:2021年3月1日上午10:18:20 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Location.java
* @Package luozix.start.java15.records
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月1日 上午10:18:20
* @version V1.0  
*/  
	  
	package luozix.start.java15.records;

	import java.io.Serializable;

	/** 
			 * ClassName:Location <br/> 
			 * Function: TODO ADD FUNCTION. <br/> 
			 * Reason:   TODO ADD REASON. <br/> 
			 * Date:     2021年3月1日 上午10:18:20 <br/> 
			 * @author   xiaoy 
			 * @version   
			 * @since    JDK 16
			 * @see       
			 */

/**
* @ClassName: Location
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月1日 上午10:18:20
* @version  
*@since JDK 16
*/

interface City {
	String city();
}

public record Location(String city, String country) implements City, Comparable, Serializable {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public Location(String city, String country) {
		// TODO Auto-generated constructor stub

		java.util.Objects.requireNonNull(city);

		java.util.Objects.requireNonNull(country);

		this.city = city;

		this.country = country;
	}

	/*
	 * (非 Javadoc) <p>Title: compareTo</p> <p>Description: </p>
	 * 
	 * @param o
	 * 
	 * @return
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
