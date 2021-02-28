    /** 
	 * Project Name:java11_in_action 
	 * File Name:CaptureScreenSnippet.java 
	 * Package Name:luozix.start.java8.problems 
	 * Date:2021年2月28日下午6:19:27 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: CaptureScreenSnippet.java
* @Package luozix.start.java8.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午6:19:27
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems;  
	/** 
	 * ClassName:CaptureScreenSnippet <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午6:19:27 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

/**
* @ClassName: CaptureScreenSnippet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午6:19:27
* @version  
*@since JDK 1.8
*/
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * 30 Seconds of Java code library
 *
 */
public class CaptureScreenSnippet {
	/**
	 * Capture screenshot and save it to PNG file. Credits:
	 * https://viralpatel.net/blogs/how-to-take-screen-shots-in-java-taking-screenshots-java/
	 *
	 * @param filename the name of the file
	 * @throws AWTException if the platform configuration does not allow low-level
	 *                      input control
	 * @throws IOException  if an I/O error occurs
	 */
	public static void captureScreen(String filename) throws AWTException, IOException {
		var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		var screenRectangle = new Rectangle(screenSize);
		var robot = new Robot();
		var image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(filename));
	}
}
