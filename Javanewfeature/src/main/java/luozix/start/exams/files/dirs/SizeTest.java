/**
 * 
 */
package luozix.start.exams.files.dirs;

/**
 * @author xiaoy
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class SizeTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long size = FileUtils.sizeOfDirectory(new File("C:/test"));
		System.out.println("Size: " + size + " bytes");

		File dir = new File("../java");
		String[] children = dir.list();
		if (children == null) {
			System.out.println("该目录不存在");
		} else {
			for (int i = 0; i < children.length; i++) {
				String filename = children[i];
				System.out.println(filename);
			}
		}

		File file = new File("C:/File/demo.txt");
		String strParentDirectory = file.getParent();
		System.out.println("文件的上级目录为 : " + strParentDirectory);

		File file1 = new File("C://FileIO//demo.txt");
		System.out.println("最后修改时间：" + new Date(file1.lastModified()));

		showDir(1, new File("d:\\Java"));
	}

	static void showDir(int indent, File file) throws IOException {
		for (int i = 0; i < indent; i++)
			System.out.print('-');
		System.out.println(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++)
				showDir(indent + 4, files[i]);
		}
	}

	/**
	 * 使用 java 8 lambda 表达式，打印目录结构
	 * 
	 * @param indent
	 * @param file
	 */
	public static void printDir(int indent, File file) {
		Stream.generate(() -> '-').limit(indent).forEach(System.out::print);// 打印缩进字符"-"
		System.out.println(file.getName());
		if (file.isDirectory()) {
			Arrays.asList(file.listFiles()).forEach(file2 -> printDir(indent + 2, file2));
		}
	}

	/**
	 * * 1、使用 java 8 lambda 表达式，打印目录结构 * 2、移除目录判断：file.isDirectory() * @param indent
	 * * @param file
	 */
	public static void printDirs(int indent, File file) {
		// 打印缩进字符"-"
		Stream.generate(() -> '-').limit(indent).forEach(System.out::print);
		// 打印目录或文件名称
		System.out.println(file.getName());
		// 打印下级目录或文件名称
		Stream.of(Optional.ofNullable(file.listFiles()).orElse(new File[] {}))
				.forEach(file2 -> printDir(indent + 2, file2));
	}
}
