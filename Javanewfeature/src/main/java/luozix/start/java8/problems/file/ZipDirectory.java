    /** 
	 * Project Name:java11_in_action 
	 * File Name:ZipDirectory.java 
	 * Package Name:luozix.start.java8.problems.file 
	 * Date:2021年2月28日下午7:29:26 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ZipDirectory.java
* @Package luozix.start.java8.problems.file
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月28日 下午7:29:26
* @version V1.0  
*/  
	  
	package luozix.start.java8.problems.file;  
	/** 
	 * ClassName:ZipDirectory <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月28日 下午7:29:26 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */
	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
* @ClassName: ZipDirectory
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月28日 下午7:29:26
* @version  
*@since JDK 1.8
*/
public class ZipDirectory {

	/**
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* date: 2021年2月28日 下午7:29:26.<br/>
	* @author xiaoy 
	* @param args 
	*@since JDK 1.8
	* @throws
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Zip a complete directory.
	 *
	 * @param srcDirectoryName The path to the directory to be zipped
	 * @param zipFileName      The location and name of the zipped file.
	 * @throws IOException if an I/O error occurs
	 */
	public static void zipDirectory(String srcDirectoryName, String zipFileName) throws IOException {
		var srcDirectory = new File(srcDirectoryName);
		try (var fileOut = new FileOutputStream(zipFileName); var zipOut = new ZipOutputStream(fileOut)) {
			zipFile(srcDirectory, srcDirectory.getName(), zipOut);
		}
	}

	/**
	 * Utility function which either zips a single file, or recursively calls itself
	 * for a directory to traverse down to the files contained within it.
	 *
	 * @param fileToZip The file as a resource
	 * @param fileName  The actual name of the file
	 * @param zipOut    The output stream to which all data is being written
	 */
	public static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
		if (fileToZip.isHidden()) { // Ignore hidden files as standard
			return;
		}
		if (fileToZip.isDirectory()) {
			if (fileName.endsWith("/")) {
				zipOut.putNextEntry(new ZipEntry(fileName)); // To be zipped next
				zipOut.closeEntry();
			} else {
				// Add the "/" mark explicitly to preserve structure while unzipping action is
				// performed
				zipOut.putNextEntry(new ZipEntry(fileName + "/"));
				zipOut.closeEntry();
			}
			var children = fileToZip.listFiles();
			for (var childFile : children) { // Recursively apply function to all children
				zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
			}
			return;
		}
		try (var fis = new FileInputStream(fileToZip) // Start zipping once we know it is a file
		) {
			var zipEntry = new ZipEntry(fileName);
			zipOut.putNextEntry(zipEntry);
			var bytes = new byte[1024];
			var length = 0;
			while ((length = fis.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
		}
	}

	/**
	 * Zip single file.
	 *
	 * @param srcFilename the filename of the source file
	 * @param zipFilename the filename of the destination zip file
	 * @throws IOException if an I/O error occurs
	 */
	public static void zipFile(String srcFilename, String zipFilename) throws IOException {
		var srcFile = new File(srcFilename);
		try (var fileOut = new FileOutputStream(zipFilename);
				var zipOut = new ZipOutputStream(fileOut);
				var fileIn = new FileInputStream(srcFile)) {
			var zipEntry = new ZipEntry(srcFile.getName());
			zipOut.putNextEntry(zipEntry);
			final var bytes = new byte[1024];
			int length;
			while ((length = fileIn.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
		}
	}

	/**
	 * Zip multiples files.
	 *
	 * @param srcFilenames array of source file names
	 * @param zipFilename  the filename of the destination zip file
	 * @throws IOException if an I/O error occurs
	 */
	public static void zipFiles(String[] srcFilenames, String zipFilename) throws IOException {
		try (var fileOut = new FileOutputStream(zipFilename); var zipOut = new ZipOutputStream(fileOut)) {
			for (String srcFilename : srcFilenames) {
				var srcFile = new File(srcFilename);
				try (var fileIn = new FileInputStream(srcFile)) {
					var zipEntry = new ZipEntry(srcFile.getName());
					zipOut.putNextEntry(zipEntry);
					final var bytes = new byte[1024];
					int length;
					while ((length = fileIn.read(bytes)) >= 0) {
						zipOut.write(bytes, 0, length);
					}
				}
			}
		}
	}

}
