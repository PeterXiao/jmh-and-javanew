/**  
* @Title: ProblemsofPararellstream.java
* @Package luozix.start.streamxs.problems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午6:22:17
* @version V1.0  
*/
package luozix.start.streamxs.problems;

import java.util.stream.LongStream;

/**
* @ClassName: ProblemsofPararellstream
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午6:22:17
*
*/
public class ProblemsofPararellstream {

	public static void main(String[] args) {

		// right
		long res = LongStream.of(2, 53, 17, 21, 11, 42, 30).reduce(1, (acc, next) -> acc * next);
		System.out.println(res);
		// fault
		long resfalut = LongStream.of(2, 53, 17, 21, 11, 42, 30).parallel().reduce(5, (acc, next) -> acc * next);
		System.out.println(resfalut);
	}
}
