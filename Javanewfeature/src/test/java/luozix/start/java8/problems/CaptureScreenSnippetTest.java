    /** 
	 * Project Name:java11_in_action 
	 * File Name:CaptureScreenSnippetTest.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午8:15:32 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: CaptureScreenSnippetTest.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午8:15:32
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;  
	/** 
	 * ClassName:CaptureScreenSnippetTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午8:15:32 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

	import static org.junit.jupiter.api.Assertions.assertTrue;

	import java.awt.AWTException;
	import java.awt.HeadlessException;
	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;

import org.junit.jupiter.api.Test;

/**
* @ClassName: CaptureScreenSnippetTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午8:15:32
* @version  
*@since JDK 1.8
*/
class CaptureScreenSnippetTest {

	/**
	 * Test method for {@link luozix.start.java8.problems.CaptureScreenSnippet#captureScreen(java.lang.String)}.
	 */
	@Test
	void testCaptureScreen() throws IOException, AWTException {
		final var filename = "src/test/resources/screenshot.png";
		try {
			CaptureScreenSnippet.captureScreen(filename);
			var f = new File(filename);
			assertTrue(f.exists() && !f.isDirectory());
		} catch (HeadlessException e) {
			// the test runs on a computer without a screen, it is ok to fail
		} finally {
			Files.deleteIfExists(new File(filename).toPath());
		}
	}

}
