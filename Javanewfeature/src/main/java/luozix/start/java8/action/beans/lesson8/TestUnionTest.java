/**  
* @Title: TestUnionTest.java
* @Package luozix.start.java8.action.beans.lesson8
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午12:52:56
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
* @ClassName: TestUnionTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午12:52:56
*
*/
public class TestUnionTest {

	/**
	 * @throws IOException @param args @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param args 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String oneLineString = processFile((BufferedReader b) -> b.readLine());
		String twoLineString = processFile((BufferedReader b) -> b.readLine() + b.readLine());

		System.out.println(oneLineString + twoLineString);
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader bReader = new BufferedReader(new FileReader("runoob.txt"))) {
			return p.process(bReader);
		}

	}
	public interface BufferedReaderProcessor {
		String process(BufferedReader b) throws IOException;
	}
}
