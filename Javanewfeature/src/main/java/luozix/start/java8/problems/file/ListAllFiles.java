    /** 
	 * Project Name:java11_in_action 
	 * File Name:ListAllFiles.java 
	 * Package Name:luozix.start.java8.problems.file 
	 * Date:2021年2月28日下午7:25:23 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ListAllFiles.java
* @Package luozix.start.java8.problems.file
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:25:23
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.file;  
	/** 
	 * ClassName:ListAllFiles <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午7:25:23 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
* @ClassName: ListAllFiles
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:25:23
* @version  
*@since JDK 1.8
*/
public class ListAllFiles {

	/**
	 * Recursively list all the files in directory.
	 *
	 * @param path the path to start the search from
	 * @return list of all files
	 */
	public static List<File> listAllFiles(String path) {
		var all = new ArrayList<File>();
		var list = new File(path).listFiles();
		if (list != null) { // In case of access error, list is null
			for (var f : list) {
				if (f.isDirectory()) {
					all.addAll(listAllFiles(f.getAbsolutePath()));
				} else {
					all.add(f.getAbsoluteFile());
				}
			}
		}
		return all;
	}

	/**
	 * List directories.
	 *
	 * @param path the path where to look
	 * @return array of File
	 */
	public static File[] listDirectories(String path) {
		return new File(path).listFiles(File::isDirectory);
	}

	/**
	 * List files in directory.
	 *
	 * @param folder the path where to look
	 * @return array of File
	 */
	public static File[] listFilesInDirectory(File folder) {
		return folder.listFiles(File::isFile);
	}

	/**
	 * Read file as list of strings.
	 *
	 * @param filename the filename to read from
	 * @return list of strings
	 * @throws IOException if an I/O error occurs
	 */
	public static List<String> readLines(String filename) throws IOException {
		return Files.readAllLines(Paths.get(filename));
	}

}

