/**  
* @Title: ArrayListSet.java
* @Package luozix.start.alg.actor.structs
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午12:20:10
* @version V1.0  
*/
package luozix.start.alg.actor.structs;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ArrayListSet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月8日 下午12:20:10
 * 
 * 
 *       操作的速度，也常被称为时间复杂度 。
 * 
 *       我们会提到速度 、时间复杂度 、效率 、性能 ，但它们其实指的都是步数。
 * 
 * 
 */
public class ArrayListSet {

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
		// 数组是计算机科学里面最基本的数据结构，也是最基本的方法论 最基本的思维模型，解题模型
		String[] array = { "apples", "bananas", "cucumbers", "dates", "elderberries" };

		for (String string : array) {
			System.out.println(string);
		}

		// 集合 。它是一种不允许元素重复的数据结构。
		Set<String> set = new HashSet<>();
		for (String string : array) {
			set.add(string);
		}

		System.out.println(set);
	}

}
