    /** 
	 * Project Name:java11_in_action 
	 * File Name:IntegerBiFunction.java 
	 * Package Name:luozix.start.lambdas.exams.examples.chapter4 
	 * Date:2021年2月15日上午11:56:11 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: IntegerBiFunction.java
* @Package luozix.start.lambdas.exams.examples.chapter4
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 上午11:56:11
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.examples.chapter4;

	import java.util.function.BinaryOperator;

	/** 
		 * ClassName:IntegerBiFunction <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月15日 上午11:56:11 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: IntegerBiFunction
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 上午11:56:11
* @version  
*@since JDK 1.8
*/
interface IntegerBiFunction extends BinaryOperator<Integer> {

	private void overloadedMethod(BinaryOperator<Integer> Lambda) {
		System.out.print("BinaryOperator");
	}

	private void overloadedMethod(IntegerBiFunction Lambda) {
		System.out.print("IntegerBinaryOperator");
	}

//	default void forEach(Consumer<? super T> action) {
//		for (T t : this) {
//			action.accept(t);
//		}
//	}

}
