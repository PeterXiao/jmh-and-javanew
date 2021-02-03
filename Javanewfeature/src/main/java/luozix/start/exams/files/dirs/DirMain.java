/**
 * 
 */
package luozix.start.exams.files.dirs;

import java.io.File;

/**
 * @author xiaoy
 *
 */
public class DirMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directories = "D:\\a\\b\\c\\d\\e\\f\\g\\h\\i";
		File file = new File(directories);
		boolean result = file.mkdirs();
		System.out.println("Status = " + result);

		// 删除当前目录下的 directories 目录 "./test"
		deleteDir(new File(directories));

		File filelist = new File("./testdir"); // 当前目录下的 testdir目录
		if (filelist.isDirectory()) {
			if (filelist.list().length > 0) {
				System.out.println("目录不为空!");
			} else {
				System.out.println("目录为空!");
			}
		} else {
			System.out.println("这不是一个目录!");
		}
		// 使用 File 类的 file.isHidden() 方法来判断文件是否隐藏：
		File file1 = new File("C:/Demo.txt");
		System.out.println(file1.isHidden());
	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		if (dir.delete()) {
			System.out.println("目录已被删除！");
			return true;
		} else {
			System.out.println("目录删除失败！");
			return false;
		}
	}
}
