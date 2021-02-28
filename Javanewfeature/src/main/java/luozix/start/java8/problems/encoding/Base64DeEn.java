    /** 
	 * Project Name:java11_in_action 
	 * File Name:Base64.java 
	 * Package Name:luozix.start.java8.problems.encoding 
	 * Date:2021年2月28日下午6:16:34 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: Base64.java
* @Package luozix.start.java8.problems.encoding
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:16:34
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.encoding;

	import java.util.Base64;

	/** 
		 * ClassName:Base64 <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午6:16:34 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: Base64
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:16:34
* @version  
*@since JDK 1.8
*/
public class Base64DeEn {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月28日 下午6:16:34.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Decodes a Base64 encoded string to the actual representation.
	 *
	 * @param input base64 encoded string
	 * @return decoded string
	 */
	public static String decodeBase64(String input) {
		return new String(Base64.getDecoder().decode(input.getBytes()));
	}

	/**
	 * Encodes the input string to a Base64 encoded string.
	 *
	 * @param input string to be encoded
	 * @return base64 encoded string
	 */
	public static String encodeBase64(String input) {
		return Base64.getEncoder().encodeToString(input.getBytes());
	}
}
