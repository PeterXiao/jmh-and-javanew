    /** 
	 * Project Name:java11_in_action 
	 * File Name:Performance.java 
	 * Package Name:luozix.start.lambdas.exams.examples.chapter1.answers.chapter4 
	 * Date:2021年2月15日下午12:55:54 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Performance.java
* @Package luozix.start.lambdas.exams.examples.chapter1.answers.chapter4
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 下午12:55:54
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.examples.chapter1.answers.chapter4;  
	/** 
	 * ClassName:Performance <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月15日 下午12:55:54 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import java.util.stream.Stream;

import luozix.start.lambdas.exams.examples.chapter1.Artist;

/**
* @ClassName: Performance
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 下午12:55:54
* @version  
*@since JDK 1.8
*/
/** 该接口表示艺术家的演出——专辑或演唱会 */
public interface  Performance {
	  public String getName(); 
	  
	  public Stream<Artist> getMusicians(); 
}
