/**  
* @Title: ExecuteAround.java
* @Package luozix.start.java8.action.beans.lesson3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午5:42:14
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson3;
/**
* @ClassName: ExecuteAround
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午5:42:14
*
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ExecuteAround {

	public static void main(String... args) throws IOException {

		// method we want to refactor to make more flexible
		String result = processFileLimited();
		System.out.println(result);

		System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

	}

	public static String processFileLimited() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("/lambdasinaction/data.txt"))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("/lambdasinaction/data.txt"))) {
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor {
		public String process(BufferedReader b) throws IOException;

	}
}