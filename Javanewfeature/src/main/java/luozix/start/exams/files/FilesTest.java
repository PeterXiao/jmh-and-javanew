/**
 * 
 */
package luozix.start.exams.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xiaoy
 *
 */
public class FilesTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));
			out.write("菜鸟教程");
			out.close();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
		}
		// 读取文件时 String 换成 Stringbuffer 提高代码运行速度，ready() 方法判断文件是否准备好被读取，如果为
		// null，则停止。同时可以确保 Stringbuffer 不会报空指针异常。
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));
			out.write("菜鸟教程");
			out.append("dasd");
			out.newLine();
			out.write("你好");
			out.flush();
			out.close();
			System.out.println("文件创建成功！");
			BufferedReader in = new BufferedReader(new FileReader("runoob.txt"));
			StringBuffer sb;
			while (in.ready()) {
				sb = (new StringBuffer(in.readLine()));
				System.out.println(sb);
			}
			in.close();
		} catch (IOException e) {
		}

		try {
			BufferedReader in = new BufferedReader(new FileReader("test.log"));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}
			System.out.println(str);
		} catch (IOException e) {
		}

		try {
			File file = new File("test.txt");
			if (file.delete()) {
				System.out.println(file.getName() + " 文件已被删除！");
			} else {
				System.out.println("文件删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		BufferedWriter out1 = new BufferedWriter(new FileWriter("srcfile"));
//	        out1.write("string to be copied\n");
//	        out1.close();
//	        InputStream in = new FileInputStream(new File("srcfile"));
//	        OutputStream out = new FileOutputStream
//	        (new File("destnfile"));
//	        byte[] buf = new byte[1024];
//	        int len;
//	        while ((len = in.read(buf)) > 0) {
//	            out.write(buf, 0, len);
//	        }
//	        in.close();
//	        out.close();
//	        BufferedReader in1 = new BufferedReader(new FileReader("destnfile"));
//	        String str;
//	        while ((str = in1.readLine()) != null) {
//	            System.out.println(str);
//	        }
//	        in1.close();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("filename"));
			out.write("aString1\n");
			out.close();
			out = new BufferedWriter(new FileWriter("filename", true));
			out.write("aString2");
			out.close();
			BufferedReader in = new BufferedReader(new FileReader("filename"));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("exception occoured" + e);
		}

		File temp = File.createTempFile("testrunoobtmp", ".txt");
		System.out.println("文件路径: " + temp.getAbsolutePath());
		temp.deleteOnExit();
		BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		out.write("aString");
		System.out.println("临时文件已创建:");
		out.close();

		File f = null;

		try {

			// 创建临时文件
			f = File.createTempFile("tmp", ".txt", new File("C:/"));

			// 输出绝对路径
			System.out.println("File path: " + f.getAbsolutePath());

			// 终止后删除临时文件
			f.deleteOnExit();

			// 创建临时文件
			f = File.createTempFile("tmp", null, new File("D:/"));

			// 输出绝对路径
			System.out.print("File path: " + f.getAbsolutePath());

			// 终止后删除临时文件
			f.deleteOnExit();

		} catch (Exception e) {

			// 如果有错误输出内容
			e.printStackTrace();
		}
	}

}
