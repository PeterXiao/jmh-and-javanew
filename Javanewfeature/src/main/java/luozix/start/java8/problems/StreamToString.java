    /** 
	 * Project Name:java11_in_action 
	 * File Name:StreamToString.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午6:39:05 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: StreamToString.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:39:05
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

	/** 
		 * ClassName:StreamToString <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午6:39:05 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: StreamToString
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:39:05
* @version  
*@since JDK 1.8
*/
public class StreamToString {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月28日 下午6:39:05.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Convert InputStream to String.
	 *
	 * @param inputStream InputStream to convert
	 * @return String
	 * @throws IOException if an I/O error occurs
	 */
	public static String inputStreamToString(InputStream inputStream) throws IOException {
		try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
			var stringBuilder = new StringBuilder();
			var data = reader.read();

			while (data != -1) {
				stringBuilder.append((char) data);
				data = reader.read();
			}
			return stringBuilder.toString();
		}
	}

	/**
	 * Read file using stream and return list of string lines.
	 *
	 * @param fileName file to read
	 * @throws FileNotFoundException if an I/O error occurs
	 */
	public static List<String> readFile(String fileName) throws FileNotFoundException {
		try (Stream<String> stream = new BufferedReader(new FileReader(fileName)).lines()) {
			return stream.collect(Collectors.toList());
		}
	}

}
