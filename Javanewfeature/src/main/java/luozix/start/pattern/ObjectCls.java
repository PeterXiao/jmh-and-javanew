    /** 
	 * Project Name:java11_in_action 
	 * File Name:ObjectCls.java 
	 * Package Name:luozix.start.pattern 
	 * Date:2021年2月27日下午2:40:01 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ObjectCls.java
* @Package luozix.start.pattern
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月27日 下午2:40:01
* @version V1.0  
*/  
	  
	package luozix.start.pattern;  
	/** 
	 * ClassName:ObjectCls <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月27日 下午2:40:01 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import java.io.Serializable;

/**
* @ClassName: ObjectCls
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月27日 下午2:40:01
* @version  
*@since JDK 1.8
*/
public class ObjectCls {

	private static String string = "This is a case";
	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月27日 下午2:40:01.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (string instanceof String str) {

			System.out.println(string);
		} else {

		}

	}

	@SuppressWarnings("preview")
	record Person(String name, int age) implements Serializable {

	}

}
