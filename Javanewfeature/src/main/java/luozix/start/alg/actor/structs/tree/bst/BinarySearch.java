/**  
* @Title: BinarySearch.java
* @Package luozix.start.alg.actor.structs.tree.bst
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:45:47
* @version V1.0  
*/
package luozix.start.alg.actor.structs.tree.bst;
/**
* @ClassName: BinarySearch
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:45:47
*
*/

/**
 * 二分查找法
 */
public class BinarySearch {
	// 二分查找法,在有序数组arr中,查找target
	// 如果找到target,返回相应的索引index
	// 如果没有找到target,返回-1
	public static int find(Comparable[] arr, Comparable target) {

		// 在arr[l...r]之中查找target
		int l = 0, r = arr.length - 1;
		while (l <= r) {

			// int mid = (l + r)/2;
			// 防止极端情况下的整形溢出，使用下面的逻辑求出mid
			int mid = l + (r - l) / 2;

			if (arr[mid].compareTo(target) == 0)
				return mid;

			if (arr[mid].compareTo(target) > 0)
				r = mid - 1;
			else
				l = mid + 1;
		}

		return -1;
	}
}
