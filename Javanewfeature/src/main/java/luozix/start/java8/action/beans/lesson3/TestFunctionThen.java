/**  
* @Title: TestFunctionThen.java
* @Package luozix.start.java8.action.beans.lesson3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午9:45:24
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson3;

import java.util.function.DoubleFunction;
import java.util.function.Function;

/**
* @ClassName: TestFunctionThen
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午9:45:24
*
*/
public class TestFunctionThen {

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
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> function = f.andThen(g);
		int result = function.apply(2);
		System.out.println(result);

		Function<Integer, Integer> functiong = f.compose(g);
		int result1 = functiong.apply(2);
		System.out.println(result1);

	}

	public static double integrate(DoubleFunction<Double> f, double a, double b) {
		return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;

	}

}
