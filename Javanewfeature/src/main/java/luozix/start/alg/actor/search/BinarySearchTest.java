/**  
* @Title: BinarySearchTest.java
* @Package luozix.start.alg.actor.search
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午3:23:44
* @version V1.0  
*/
package luozix.start.alg.actor.search;

/**
* @ClassName: BinarySearchTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午3:23:44
*
*/
public class BinarySearchTest {

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

		int[] alist = { 1, 2, 3, 4, 5 };

		System.out.println(b_Search(alist, 3));
	}

	public static int b_Search(int[] alist, int state) {
		int index = 0;
		int start =0;
		int Temp = alist.length - 1;
		do {
			  
			 if (alist[Temp]==state) {
				return Temp;
			}else if (alist[Temp] >state) {
				// 避免超出整数范围
				Temp = (Temp - start) / 2 + start;
				start = 0;
			} else if (alist[Temp] < state) {
				
				start =(Temp+start)/2;
				Temp = alist.length;
				continue;
			} else {
				return 0;
			}
			
		} while (start <= Temp);
//		for (int i = 0; i < alist.length; i++) {
//
//		}
		return index;
	}
}
