/**  
* @Title: HeapShiftUp.java
* @Package luozix.start.alg.actor.structs.heap
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:33:22
* @version V1.0  
*/
package luozix.start.alg.actor.structs.heap;
/**
* @ClassName: HeapShiftUp
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:33:22
*
*/

/**
 * 往堆中添加一元素
 */
public class HeapShiftUp<T extends Comparable> {

	protected T[] data;
	protected int count;
	protected int capacity;

	// 构造函数, 构造一个空堆, 可容纳capacity个元素
	public HeapShiftUp(int capacity) {
		data = (T[]) new Comparable[capacity + 1];
		count = 0;
		this.capacity = capacity;
	}

	// 返回堆中的元素个数
	public int size() {
		return count;
	}

	// 返回一个布尔值, 表示堆中是否为空
	public boolean isEmpty() {
		return count == 0;
	}

	// 像最大堆中插入一个新的元素 item
	public void insert(T item) {
		assert count + 1 <= capacity;
		data[count + 1] = item;
		count++;
		shiftUp(count);
	}

	// 交换堆中索引为i和j的两个元素
	private void swap(int i, int j) {
		T t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	// ********************
	// * 最大堆核心辅助函数
	// ********************
	private void shiftUp(int k) {

		while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
			swap(k, k / 2);
			k /= 2;
		}
	}

	// 测试 HeapShiftUp
	public static void main(String[] args) {
		HeapShiftUp<Integer> heapShiftUp = new HeapShiftUp<Integer>(100);
		int N = 50; // 堆中元素个数
		int M = 100; // 堆中元素取值范围[0, M)
		for (int i = 0; i < N; i++)
			heapShiftUp.insert(new Integer((int) (Math.random() * M)));
		System.out.println(heapShiftUp.size());

	}
}