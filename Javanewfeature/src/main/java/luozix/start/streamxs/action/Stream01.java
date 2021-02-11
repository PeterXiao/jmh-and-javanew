/**  
* @Title: Stream01.java
* @Package luozix.start.streamxs.action
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午6:31:32
* @version V1.0  
*/
package luozix.start.streamxs.action;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import lombok.experimental.var;

/**
* @ClassName: Stream01
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午6:31:32
*
*/
public class Stream01 {

	/**
	 * @param args
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream.of("hello", "great").map(s -> s + " world").forEach(System.out::println);

		Optional.of(new Random().nextInt(10)).filter(i -> i % 2 == 0).map(i -> "number is even:" + i)
				.ifPresent(System.out::println);
		var i = 3;
		String s;
		switch (i) {
		case 1:
			s = "one";
			break;
		case 2:
			s = "two";
			break;
		case 3:
			s = "three";
			break;
		default:
			s = "unknown number";
		}
	}

}
