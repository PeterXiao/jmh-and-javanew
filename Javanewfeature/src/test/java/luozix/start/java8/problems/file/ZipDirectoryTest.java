    /** 
	 * Project Name:java11_in_action 
	 * File Name:ZipDirectoryTest.java 
	 * Package Name:luozix.start.java8.problems.file 
	 * Date:2021年2月28日下午8:21:19 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ZipDirectoryTest.java
* @Package luozix.start.java8.problems.file
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:21:19
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.file;  
	/** 
	 * ClassName:ZipDirectoryTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:21:19 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipFile;

import org.junit.jupiter.api.Test;
/**
* @ClassName: ZipDirectoryTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:21:19
* @version  
*@since JDK 1.8
*/
class ZipDirectoryTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.file.ZipDirectory#zipDirectory(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testZipDirectory() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.file.ZipDirectory#zipFile(java.io.File, java.lang.String, java.util.zip.ZipOutputStream)}.
	 */
	@Test
	void testZipFileFileStringZipOutputStream() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.file.ZipDirectory#zipFile(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testZipFileStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link luozix.start.java8.problems.file.ZipDirectory#zipFiles(java.lang.String[], java.lang.String)}.
	 */
	@Test
	void testZipFiles() throws IOException {
		final String[] srcFilenames = { "src/test/resources/somelines.txt", "src/test/resources/someotherlines.txt" };
		final var dst = "src/test/resources/multiple.zip";
		try {
			ZipDirectory.zipFiles(srcFilenames, dst);
			assertTrue(Files.exists(Paths.get(dst)));
		} finally {
			Files.deleteIfExists(new File(dst).toPath());
		}
	}

	@Test
	void testZipFileDirectory() throws IOException {
		final var src = "src/test/resources/dir3";
		final var dst = "src/test/resources/dir3.zip";
		try {
			ZipDirectory.zipDirectory(src, dst);
			assertTrue(Files.exists(Paths.get(dst)));
			var zipFile = new ZipFile(Paths.get(dst).toFile());
			var regularFiles = 0;
			var directories = 0;
			var zipEntries = zipFile.entries();
			while (zipEntries.hasMoreElements()) {
				if (zipEntries.nextElement().isDirectory()) {
					directories++;
				} else {
					regularFiles++;
				}
			}
			assertEquals(4, zipFile.size());
			assertEquals(directories, 2); // The root directory + inner directory
			assertEquals(regularFiles, 2); // Two simple files
			zipFile.close();
		} finally {
			Files.deleteIfExists(new File(dst).toPath());
		}
	}

	@Test()
	void testZipFileDirectoryInvalid() throws IOException {

		final var src = "src/test/resources/dirUnknown";
		final var dst = "src/test/resources/dirUnknown.zip";
		assertThrows(IOException.class, () -> {
			ZipDirectory.zipDirectory(src, dst);
		});
		Files.deleteIfExists(new File(dst).toPath());
	}

	@Test
	void testZipFile() throws IOException {
		final var src = "src/test/resources/somelines.txt";
		final var dst = "src/test/resources/somelines.zip";
		try {
			ZipDirectory.zipFile(src, dst);
			assertTrue(Files.exists(Paths.get(dst)));
		} finally {
			Files.deleteIfExists(new File(dst).toPath());
		}
	}


}
