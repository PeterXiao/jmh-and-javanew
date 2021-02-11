/**  
* @Title: StreamIOFile.java
* @Package luozix.start.streamxs.action
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午6:43:17
* @version V1.0  
*/
package luozix.start.streamxs.action;

import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;
/**
* @ClassName: StreamIOFile
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午6:43:17
*
*/
public class StreamIOFile {

	/**
	 * @throws IOException @param args @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param args 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<String> fileLines = Files.readAllLines(get("huge.txt"));
		String fileStats = fileLines.parallelStream().flatMap(line -> Stream.of(line.split("\\s+")))
				.filter(word -> !"dumb".equalsIgnoreCase(word)).collect(groupingBy(word -> word.charAt(0), counting()))
				.entrySet().parallelStream().map(letterStats -> letterStats.getKey() + ":" + letterStats.getValue())
				.collect(joining("\n"));
		System.out.println(fileStats);
	}

}
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//class User {
//	String name;
//	String surName;
//	List<ContactInfo> contacts;
//}