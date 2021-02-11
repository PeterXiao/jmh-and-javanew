/**  
* @Title: FisrtClass.java
* @Package luozix.start.java8.action.beans.lesson01
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 下午4:38:17
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson01;

import java.io.File;
import java.util.Arrays;

/**
* @ClassName: FisrtClass
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 下午4:38:17
*
*/

public class FisrtClass {

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
		@SuppressWarnings("unused")
		double mydouble = 100.00d;
		System.out.println(mydouble);
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);

		System.out.println(Arrays.toString(hiddenFiles));
	}

//	Collections.sort(inventory, new Comparator<Apple>()){
//		 public int compare(Apple a1, Apple a2) {
//			 return a1.getWeight().compareTo(a2.getWeight());
//		 }
//	};
//	
//	inventory.sort(comparing(Apple::getWeight()));
}
