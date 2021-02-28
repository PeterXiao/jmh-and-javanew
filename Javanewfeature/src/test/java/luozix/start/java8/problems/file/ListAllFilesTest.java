    /** 
	 * Project Name:java11_in_action 
	 * File Name:ListAllFilesTest.java 
	 * Package Name:luozix.start.java8.problems.file 
	 * Date:2021年2月28日下午8:21:06 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ListAllFilesTest.java
* @Package luozix.start.java8.problems.file
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:21:06
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.file;  
	/** 
	 * ClassName:ListAllFilesTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:21:06 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
/**
* @ClassName: ListAllFilesTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:21:06
* @version  
*@since JDK 1.8
*/
class ListAllFilesTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.file.ListAllFiles#listAllFiles(java.lang.String)}.
	 */
	@Test
	void testListAllFiles() {
		var files = ListAllFiles.listAllFiles("src/test/resources");
		assertEquals(6, files.size());
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.file.ListAllFiles#listDirectories(java.lang.String)}.
	 */
	@Test
	void testListDirectories() {
		var files = ListAllFiles.listDirectories("src/test/resources");
		assertTrue(Arrays.stream(files).allMatch(File::isDirectory));
		assertTrue(Arrays.asList(files).contains(new File("src/test/resources/dir1")));
		assertTrue(Arrays.asList(files).contains(new File("src/test/resources/dir2")));
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.file.ListAllFiles#listFilesInDirectory(java.io.File)}.
	 */
	@Test
	void testListFilesInDirectory() {
		var files = ListAllFiles.listFilesInDirectory(new File("src/test/resources"));
		assertEquals(2, files.length);
		var filenames = new HashSet<>(Arrays.asList(files[0].toString(), files[1].toString()));
		assertTrue(filenames.contains("src/test/resources/somelines.txt"));
		assertTrue(filenames.contains("src/test/resources/someotherlines.txt"));
	}

	/**
	 * Test method for
	 * {@link luozix.start.java8.problems.file.ListAllFiles#readLines(java.lang.String)}.
	 * 
	 * @throws IOException
	 */
	@Test
	void testReadLines() throws IOException {
		var somelines = ListAllFiles.readLines("src/test/resources/somelines.txt");
		assertEquals(3, somelines.size());
		assertEquals("foo", somelines.get(0));
		assertEquals("bar", somelines.get(1));
		assertEquals("baz", somelines.get(2));
		assertThrows(IOException.class, () -> ListAllFiles.readLines("some/nonexistent/filename.txt"));
	}

}
