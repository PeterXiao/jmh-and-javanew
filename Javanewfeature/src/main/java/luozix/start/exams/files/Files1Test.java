/**
 * 
 */
package luozix.start.exams.files;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author xiaoy
 *
 */
public class Files1Test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		try {
			File file = new File("C:/myfile.txt");
			if (file.createNewFile())
				System.out.println("文件创建成功！");
			else
				System.out.println("出错了，该文件已经存在。");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// File 类的 filename.compareTo (another filename) 方法来比较两个文件路径是否在同一个目录下
		File file1 = new File("C:/File/demo1.txt");
		File file2 = new File("C:/java/demo1.txt");
		if (file1.compareTo(file2) == 0) {
			System.out.println("文件路径一致！");
		} else {
			System.out.println("文件路径不一致！");
		}
		// TODO Auto-generated method stub
		File fileToChange = new File("myjavafile.txt");
		fileToChange.createNewFile();
		Date filetime = new Date(fileToChange.lastModified());
		System.out.println(filetime.toString());
		System.out.println(fileToChange.setLastModified(System.currentTimeMillis()));
		filetime = new Date(fileToChange.lastModified());
		System.out.println(filetime.toString());

		long size = getFileSize("myjavafile.txt");
		System.out.println("java.txt文件大小为: " + size);

		// 旧的文件或目录
		File oldName = new File("./runoob-test.txt");
		// 新的文件或目录
		File newName = new File("./runoob-test-2.txt");
		if (newName.exists()) { // 确保新的文件名不存在
			throw new java.io.IOException("file exists");
		}
		if (oldName.renameTo(newName)) {
			System.out.println("已重命名");
		} else {
			System.out.println("Error");
		}
		// File 类的 file.setReadOnly() 和 file.canWrite() 方法来设置文件只读：
		File file = new File("C:/java.txt");
		System.out.println(file.setReadOnly());
		System.out.println(file.canWrite());

		File file11 = new File("C:/java.txt");
		System.out.println(file11.exists());

		File lfile = null;
		File dir = new File("C:/");
		lfile = File.createTempFile("JavaTemp", ".javatemp", dir);
		System.out.println(lfile.getPath());

		File fileLog = new File("Main.java");
		Long lastModified = fileLog.lastModified();
		Date date = new Date(lastModified);
		System.out.println(date);
	}

	public static long getFileSize(String filename) {
		File file = new File(filename);
		if (!file.exists() || !file.isFile()) {
			System.out.println("文件不存在");
			return -1;
		}
		return file.length();
	}
}
