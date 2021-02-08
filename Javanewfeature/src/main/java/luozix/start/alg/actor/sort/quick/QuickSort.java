/**  
* @Title: QuickSort.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:58:47
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;
/**
* @ClassName: QuickSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:58:47
*
*/
public class QuickSort {

	/** 待排序、划分数组 */
	private int[] array;
	/** 数组长度 */
	private int length;

	public QuickSort(int[] array) {
		this.array = array;
		this.length = array.length;
	}

	/**
	 * 打印元素
	 */
	public void printArray() {
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 划分
	 * 
	 * @return 划分的分界点
	 */
	public int partition(int left, int right, int pivot) {
		// 左指针的起点，left-1是由于在后面的循环中，每循环一次左指针都要右移，
		// 这样可以确保左指针从左边第一个元素开始，不然是从第二个开始
		int leftpoint = left - 1;
		// 右指针的起点，right+1是由于后面的循环中，每循环一次右指针都要左移，
		// 这样可以确保右指针从最右边开始，不然是从倒数第二个开始
		int rightpoint = right + 1;
		while (true) {
			// 找到左边大于pivot的数据，或者走到了最右边仍然没有找到比pivot大的数据
			while (leftpoint < right && array[++leftpoint] < pivot)
				;
			// 找到右边小于pivot的数据，或者走到了最左边仍然没有找到比pivot小的数据
			while (rightpoint > left && array[--rightpoint] > pivot)
				;
			// 左指针和右指针重叠或相交
			if (leftpoint >= rightpoint) {
				break;
			} else {
				// 交换左边大的和右边小的数据
				swap(leftpoint, rightpoint);
			}
		}
		// 返回分界点，即右边子数组中最左边的点
		return leftpoint;
	}

	/**
	 * 交换数据
	 */
	public void swap(int leftpoint, int rightpoint) {
		int temp = array[leftpoint];
		array[leftpoint] = array[rightpoint];
		array[rightpoint] = temp;
	}

	public static void main(String args[]) {
		int[] array = { 99, 78, 26, 17, 82, 36, 9, 81, 22, 100, 30, 20, 17, 85 };
		QuickSort qs = new QuickSort(array);
		System.out.println("划分前的数据为：");
		qs.printArray();
		int bound = qs.partition(0, array.length - 1, 50);
		System.out.println("划分后的数据为：");
		qs.printArray();
		System.out.println("划分的分界点为：" + array[bound] + "，分界点的坐标为：" + bound);
	}

}
