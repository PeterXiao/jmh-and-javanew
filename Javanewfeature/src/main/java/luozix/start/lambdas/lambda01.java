    /** 
	 * Project Name:java11_in_action 
	 * File Name:lambda01.java 
	 * Package Name:luozix.start.lambdas 
	 * Date:2021年2月14日下午3:06:08 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: lambda01.java
* @Package luozix.start.lambdas
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月14日 下午3:06:08
* @version V1.0  
*/  
	  
	package luozix.start.lambdas;

	import java.util.function.BinaryOperator;

	/** 
		 * ClassName:lambda01 <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月14日 下午3:06:08 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: lambda01
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月14日 下午3:06:08
* @version  
*@since JDK 1.8
*/
public class lambda01 {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月14日 下午3:06:08.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable noArguamaneRunnable = () -> System.out.println("Hello world!");

		Runnable noArguamane = () -> {
			System.out.println(" ");
			System.out.print(" world");
		};

		BinaryOperator<Long> addBinaryOperator = (x, y) -> x + y;
		BinaryOperator<Long> addEOperator = (Long x, Long y) -> x + y;
	}

}
