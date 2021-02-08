/**  
* @Title: HeapSort.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:40:22
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;
/**
* @ClassName: HeapSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:40:22
*
*/
public class HeapSort {

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
		int[] list = { 4, 2, 7, 1, 3, 5 };
		// MinHeap_Sort(list, 3);
		for (int i : list) {
			System.out.println(i);
		}
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };
	}

	// 构建最小堆
	public static void MakeMinHeap(int a[], int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			MinHeapFixdown(a, i, n);
		}
	}

	// 从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
	public static void MinHeapFixdown(int a[], int i, int n) {

		int j = 2 * i + 1; // 子节点
		int temp = 0;

		while (j < n) {
			// 在左右子节点中寻找最小的
			if (j + 1 < n && a[j + 1] < a[j]) {
				j++;
			}

			if (a[i] <= a[j])
				break;

			// 较大节点下移
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;

			i = j;
			j = 2 * i + 1;
		}
	}

	public static void MinHeap_Sort(int a[], int n) {
		int temp = 0;
		MakeMinHeap(a, n);

		for (int i = n - 1; i > 0; i--) {
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			MinHeapFixdown(a, 0, i);
		}
	}
}
