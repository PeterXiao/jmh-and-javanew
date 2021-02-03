/**
 * 
 */
package luozix.start.exams.files.dirs;

import java.io.File;
import java.io.FileFilter;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xiaoy
 *
 */
public class ListDirTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("./");
		File[] files = dir.listFiles(file -> file.isDirectory());
		Stream.of(Optional.ofNullable(files).orElse(new File[] {})).map(File::getName).forEach(System.out::println);
		File file = new File("Desktop");
		getAllDirectory(file);

		File dirlist = new File("F:");
		File[] fileslist = dirlist.listFiles();
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		fileslist = dirlist.listFiles(fileFilter);
		System.out.println(fileslist.length);
		if (fileslist.length == 0) {
			System.out.println("目录不存在或它不是一个目录");
		} else {
			for (int i = 0; i < fileslist.length; i++) {
				File filename = fileslist[i];
				System.out.println(filename.toString());
			}
		}
	}

	public static void getAllDirectory(File file) {
		// 创建过滤器
		File[] f = file.listFiles(new GetAllDirectory());
		for (File f1 : f) {
			System.out.println(f1);
			// 判断目录是否为空
			if (f1.length() != 0)
				getAllDirectory(f1);
		}
	}

	public static void filesInDirList(String dirname) {
		File dir = new File(dirname);
		String[] children = dir.list();
		if (children == null) {
			System.out.println("目录不存在或它不是一个目录");
		} else {
			for (int i = 0; i < children.length; i++) {
				String filename = children[i];
				System.out.println(filename);
			}
		}
	}
}

class GetAllDirectory implements FileFilter {
	@Override
	public boolean accept(File pathname) {
		// 去除所有非文件夹
		if (pathname.isDirectory()) {
			return true;
		}
		return false;
	}

}
