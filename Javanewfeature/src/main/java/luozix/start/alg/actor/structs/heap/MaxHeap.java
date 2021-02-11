/**  
* @Title: MaxHeap.java
* @Package luozix.start.alg.actor.structs.heap
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:31:35
* @version V1.0  
*/
package luozix.start.alg.actor.structs.heap;
/**
* @ClassName: MaxHeap
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:31:35
*
*/
/**
 * 堆定义
 */
public class MaxHeap<T> {
	private T[] data;
	private int count;

	// 构造函数, 构造一个空堆, 可容纳capacity个元素
	public MaxHeap(int capacity) {
		data = (T[]) new Object[capacity + 1];
		count = 0;
	}

	// 返回堆中的元素个数
	public int size() {
		return count;
	}

	// 返回一个布尔值, 表示堆中是否为空
	public boolean isEmpty() {
		return count == 0;
	}

	// 测试 MaxHeap
	public static void main(String[] args) {
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
		System.out.println(maxHeap.size());
	}
}