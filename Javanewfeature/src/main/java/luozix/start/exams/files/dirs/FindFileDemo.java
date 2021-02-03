/**
 * 
 */
package luozix.start.exams.files.dirs;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xiaoy
 *
 */
public class FindFileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("./");
		findFile4Prefix(dir, "f");

		File dir1 = new File("C:");
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("b");
			}
		};
		String[] children = dir1.list(filter);
		if (children == null) {
			System.out.println("目录不存在或它不是一个目录");
		} else {
			for (int i = 0; i < children.length; i++) {
				String filename = children[i];
				System.out.println(filename);
			}
		}

		File[] roots = File.listRoots();
		System.out.println("系统所有根目录：");
		for (int i = 0; i < roots.length; i++) {
			System.out.println(roots[i].toString());
		}

		String curDir = System.getProperty("user.dir");
		System.out.println("你当前的工作目录为 :" + curDir);

		System.out.println("遍历目录");
		File dir11 = new File(curDir); // 要遍历的目录 "/www/java"
		visitAllDirsAndFiles(dir11);
	}

	/**
	 * * 在指定目录中，查找指定前缀的文件，并输出。 * * @param dir * @param prefix
	 */
	public static void findFile4Prefix(File dir, String prefix) {
		String[] fileNames = Optional.ofNullable(dir.list((file, fileName) -> fileName.startsWith(prefix)))
				.orElse(new String[] {});
		Stream.of(fileNames).forEach(System.out::println);
	}

	public static void visitAllDirsAndFiles(File dir) {
		System.out.println(dir);
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllDirsAndFiles(new File(dir, children[i]));
			}
		}
	}
}
