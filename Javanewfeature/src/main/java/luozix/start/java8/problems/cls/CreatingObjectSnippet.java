    /** 
	 * Project Name:java11_in_action 
	 * File Name:CreatingObjectSnippet.java 
	 * Package Name:luozix.start.java8.problems.cls 
	 * Date:2021年2月28日下午6:35:31 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: CreatingObjectSnippet.java
* @Package luozix.start.java8.problems.cls
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:35:31
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.cls;

	import java.lang.reflect.InvocationTargetException;

	/** 
		 * ClassName:CreatingObjectSnippet <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午6:35:31 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: CreatingObjectSnippet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:35:31
* @version  
*@since JDK 1.8
*/
public class CreatingObjectSnippet {

	/**
	 * Create object using reflection.
	 *
	 * @param cls fully qualified name of class includes the package name as String
	 * @return object
	 * @throws NoSuchMethodException     if a method that does not exist at runtime.
	 * @throws IllegalAccessException
	 *                                   <p>
	 *                                   if an currently executing method does not
	 *                                   have access to the definition of the
	 *                                   specified class, field, method or
	 *                                   constructor
	 *                                   </p>
	 * @throws InvocationTargetException
	 *                                   <p>
	 *                                   InvocationTargetException is a checked
	 *                                   exception that wraps an exception thrown by
	 *                                   an invoked method or constructor.
	 *                                   </p>
	 * @throws InstantiationException
	 *                                   <p>
	 *                                   when an method tries to create an instance
	 *                                   of a class using the newInstance method in
	 *                                   class Class.
	 *                                   </p>
	 * @throws ClassNotFoundException
	 *                                   <p>
	 *                                   when an application tries to load in a
	 *                                   class through its string name.
	 *                                   </p>
	 */
	public static Object createObject(String cls) throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException, ClassNotFoundException {
		var objectClass = Class.forName(cls);
		var objectConstructor = objectClass.getConstructor();
		return objectConstructor.newInstance();
	}
}
