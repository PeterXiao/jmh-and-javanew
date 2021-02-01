/**
 * 
 */
package luozix.start.dataalais;

import java.util.LinkedList;

/**
 * @author xiaoy
 *
 */
public class RunoobTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		// 引入 LinkedList 类
//		import java.util.LinkedList; 
//
//		LinkedList<E> list = new LinkedList<E>();   // 普通创建方法
//		//或者
//		LinkedList<E> list = new LinkedList(Collection<? extends E> c); // 使用集合创建链表

		LinkedList<String> sites = new LinkedList<String>();
		sites.add("Google");
		sites.add("Runoob");
		sites.add("Taobao");
		sites.add("Weibo");
		System.out.println(sites);

		// 使用 addFirst() 在头部添加元素
		sites.addFirst("Wiki");
		System.out.println(sites);

		// 使用 addLast() 在尾部添加元素
		sites.addLast("Web");
		System.out.println(sites);

		// 使用 removeFirst() 移除头部元素
		sites.removeFirst();
		System.out.println(sites);

		// 使用 removeLast() 移除尾部元素
		sites.removeLast();
		System.out.println(sites);

		// 使用 getFirst() 获取头部元素
		System.out.println(sites.getFirst());

		// 使用 getLast() 获取尾部元素
		System.out.println(sites.getLast());

		for (int size = sites.size(), i = 0; i < size; i++) {
			System.out.println(sites.get(i));
		}
		for (String i : sites) {
			System.out.println(i);
		}

	}

}
