/**
 * 
 */
package luozix.start.exams.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author xiaoy
 *
 */
public class MainFileTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		file_add("ababababababab");
	}

	/**
	 * 文件追加数据 原理就是将原文件数据先写进缓冲区，再在缓冲区追加数据最后保存 也可以重新创建个备份文件记录原文件，再记录进缓冲区 这里用第二种
	 * 要用第一种，就只需要用一个字符串变量来记录备份，但是万一突然断电，缓冲区所有记录消失，还是更安全点好
	 * 
	 * @param args
	 * @throws Exception
	 */
	static void file_add(String str) throws Exception {
		// 首先创建一个备份文件,并读取原文件写入备份数据
		File c = new File("Desktopc.txt");
		BufferedWriter c_w = new BufferedWriter(new FileWriter("Desktopc.txt"));
		BufferedReader a_r = new BufferedReader(new FileReader("Desktopa.txt"));
		String a_copy;
		while ((a_copy = a_r.readLine()) != null) {
			c_w.write(a_copy);
			c_w.write("\n");
		}
		c_w.close();

		// 再用备份文件先写入原文件缓冲区
		BufferedReader c_r = new BufferedReader(new FileReader("Desktopc.txt"));
		String c_str;
		BufferedWriter a_w = new BufferedWriter(new FileWriter("Desktopa.txt"));
		while ((c_str = c_r.readLine()) != null) {
			a_w.write(c_str);
			a_w.write("\n");
		}

		// 先不要写入，再把需要追加的参数数据写入缓冲区
		a_w.write(str);

		// 然后写入
		a_w.close();

		// 最后删除备份文件（也可以保留），删除需要中止该文件的所有数据流，最好所有的都结束
		a_r.close();
		a_w.close();
		c_r.close();
		c_w.close();
		c.delete();

	}
}
