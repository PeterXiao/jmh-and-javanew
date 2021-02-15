    /** 
	 * Project Name:java11_in_action 
	 * File Name:ActionListener.java 
	 * Package Name:luozix.start.lambdas 
	 * Date:2021年2月14日下午3:46:31 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ActionListener.java
* @Package luozix.start.lambdas
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月14日 下午3:46:31
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams;  
	/** 
	 * ClassName:ActionListener <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月14日 下午3:46:31 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import com.sun.jdi.event.Event;

/**
* @ClassName: ActionListener
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月14日 下午3:46:31
* @version  
*@since JDK 1.8
*/
	public interface ActionListener extends Event {
		public void actionPerformed(ActionListener aListener);
}
