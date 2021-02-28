    /** 
	 * Project Name:java11_in_action 
	 * File Name:HttpSnippet.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午6:21:12 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: HttpSnippet.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:21:12
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;

	import java.io.IOException;
	import java.net.URI;
	import java.net.URLEncoder;
	import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.StringJoiner;

	/** 
		 * ClassName:HttpSnippet <br/> 
		 * Function: TODO ADD FUNCTION. <br/> 
		 * Reason:   TODO ADD REASON. <br/> 
		 * Date:     2021年2月28日 下午6:21:12 <br/> 
		 * @author   xiaoy 
		 * @version   
		 * @since    JDK 1.8
		 * @see       
		 */

/**
* @ClassName: HttpSnippet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:21:12
* @version  
*@since JDK 1.8
*/
public class HttpSnippet {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月28日 下午6:21:12.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Performs HTTP GET request.
	 *
	 * @param uri the URI of the connection
	 * @return response object
	 * @throws Exception i/o error, interruption error, etc
	 */
	public static HttpResponse<String> httpGet(String uri) throws Exception {
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
		return client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	/**
	 * Performs HTTP POST request. Credits
	 * https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java
	 *
	 * @param address   the URL of the connection in String format, like
	 *                  "http://www.google.com"
	 * @param arguments the body of the POST request, as a HashMap
	 * @return response object
	 * @throws IOException          if an I/O error occurs
	 * @throws InterruptedException if the operation is interrupted
	 */
	public static HttpResponse<String> httpPost(String address, HashMap<String, String> arguments)
			throws IOException, InterruptedException {
		var sj = new StringJoiner("&");
		for (var entry : arguments.entrySet()) {
			sj.add(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "="
					+ URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
		}

		var out = sj.toString().getBytes(StandardCharsets.UTF_8);
		var request = HttpRequest.newBuilder().uri(URI.create(address))
				.headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				.POST(HttpRequest.BodyPublishers.ofByteArray(out)).build();

		return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	}

}
