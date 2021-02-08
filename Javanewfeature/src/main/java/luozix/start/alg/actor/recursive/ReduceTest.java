/**  
* @Title: ReduceTest.java
* @Package luozix.start.alg.actor.recursive
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:03:10
* @version V1.0  
*/
package luozix.start.alg.actor.recursive;
/**
* @ClassName: ReduceTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:03:10
*
*/
public class ReduceTest {

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

		System.out.println(addNum(3));
	}

	public static void sprint() {

	}

	public static int addNum(int n) {

		if (n == 1) {
			return 1;
		} else {
		return n + addNum(n - 1);
		}
	}
}
//(1) 找出基准情形。
//
//(2) 看该函数在基准情形下会做什么。
//
//(3) 看该函数在到达基准情形的前一步 会做什么。
//
//(4) 就这样往前推，看每一步都在做什么。

//def find_directories(directory)
//Dir.foreach(directory) do |filename|
//  if File.directory?("#{directory}/#{filename}") &&
//  filename != "." && filename != ".."
//    puts "#{directory}/#{filename}"
//    find_directories("#{directory}/#{filename}")
//  end
//end
//end
//
//# 以当前目录为参数，调用find_directories
//find_directories(".")
