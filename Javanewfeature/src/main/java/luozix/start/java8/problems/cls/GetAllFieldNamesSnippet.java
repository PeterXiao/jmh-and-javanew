    /** 
	 * Project Name:java11_in_action 
	 * File Name:GetAllFieldNamesSnippet.java 
	 * Package Name:luozix.start.java8.problems.cls 
	 * Date:2021年2月28日下午6:36:41 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: GetAllFieldNamesSnippet.java
* @Package luozix.start.java8.problems.cls
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:36:41
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.cls;

	import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

	/** 
		 * ClassName:GetAllFieldNamesSnippet <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午6:36:41 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: GetAllFieldNamesSnippet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:36:41
* @version  
*@since JDK 1.8
*/
public class GetAllFieldNamesSnippet {

	/**
	 * Print all declared field names of the class or the interface the class
	 * extends.
	 *
	 * @param clazz Tested class
	 * @return list of names of all fields
	 */
	public static List<String> getAllFieldNames(final Class<?> clazz) {
		var fields = new ArrayList<String>();
		var currentClazz = clazz;
		while (currentClazz != null) {
			fields.addAll(Arrays.stream(currentClazz.getDeclaredFields()).filter(field -> !field.isSynthetic())
					.map(Field::getName).collect(Collectors.toList()));
			currentClazz = currentClazz.getSuperclass();
		}
		return fields;
	}

	/**
	 * Print all declared methods of the class.
	 * 
	 * @param cls Tested class
	 * @return list of methods name
	 */
	public static List<String> getAllMethods(final Class<?> cls) {
		return Arrays.stream(cls.getDeclaredMethods()).map(Method::getName).collect(Collectors.toList());
	}

	/**
	 * Print all declared public field names of the class or the interface the class
	 * extends.
	 *
	 * @param clazz Tested class
	 * @return list of name of public fields
	 */
	public static List<String> getAllPublicFieldNames(final Class<?> clazz) {
		return Arrays.stream(clazz.getFields()).map(Field::getName).collect(Collectors.toList());
	}

}
