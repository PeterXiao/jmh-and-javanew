/**  
* @Title: ChooseSort.java
* @Package luozix.start.alg.actor.sort.slow
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:56:40
* @version V1.0  
*/
package luozix.start.alg.actor.sort.slow;
/**
* @ClassName: ChooseSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:56:40
*
*/
public class ChooseSort {
	private int[] array;
	private int length;

	public ChooseSort(int[] array) {
		this.array = array;
		this.length = array.length;
	}

	/**
	 * 打印数组中的所有元素
	 */
	public void display() {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * 选择排序算法
	 */
	public void chooseSort() {
		for (int i = 0; i < length - 1; i++) {
			int minIndex = i;
			for (int j = minIndex + 1; j < length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	public static void main(String[] args) {
		int[] array = { 100, 45, 36, 21, 17, 13, 7 };
		ChooseSort cs = new ChooseSort(array);
		System.out.println("排序前的数据为：");
		cs.display();
		cs.chooseSort();
		System.out.println("排序后的数据为：");
		cs.display();
	}
}

//N个元素需要排序N-1轮；
//
//第i轮需要比较N-i次；
//
//N个元素排序，需要比较n（n-1）/2次；
//
//选择排序的算法复杂度仍为O（n*n）；
//
//相比于冒泡排序，选择排序的交换次数大大减少，因此速度要快于冒泡排序
