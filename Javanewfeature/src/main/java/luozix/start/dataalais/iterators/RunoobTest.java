/**
 * 
 */
package luozix.start.dataalais.iterators;

/**
 * @author xiaoy
 *
 */
//引入 ArrayList 和 Iterator 类
import java.util.ArrayList;
import java.util.Iterator;

public class RunoobTest {
	public static void main(String[] args) {

     // 创建集合
     ArrayList<String> sites = new ArrayList<String>();
     sites.add("Google");
     sites.add("Runoob");
     sites.add("Taobao");
     sites.add("Zhihu");

     // 获取迭代器
     Iterator<String> it = sites.iterator();

     // 输出集合中的第一个元素
     System.out.println(it.next());

		// 输出集合中的所有元素
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(12);
		numbers.add(8);
		numbers.add(2);
		numbers.add(23);
		Iterator<Integer> itnum = numbers.iterator();
		while (itnum.hasNext()) {
			Integer i = itnum.next();
			if (i < 10) {
				itnum.remove(); // 删除小于 10 的元素
			}
		}
		System.out.println(numbers);
 }

}

//循环集合元素
//让迭代器 it 逐个返回集合中所有元素最简单的方法是使用 while 循环：
//
//while(it.hasNext()) {
//    System.out.println(it.next());
//}