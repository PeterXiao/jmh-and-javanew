/**  
* @Title: TwoStackQueue.java
* @Package luozix.start.exams.alg
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com   
* @date 2021年2月4日 上午11:23:27
* @version V1.0  
*/
package luozix.start.exams.alg;

import java.util.Stack;

/**
 * @ClassName: TwoStackQueue
 * @Description: * Function: 两个栈实现队列
 *
 *               利用两个栈来实现，第一个栈存放写队列的数据。 第二个栈存放移除队列的数据，移除之前先判断第二个栈里是否有数据。
 *               如果没有就要将第一个栈里的数据依次弹出压入第二个栈，这样写入之后的顺序再弹出其实就是一个先进先出的结构了。
 *
 *               这样出队列只需要移除第二个栈的头元素即可。
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月4日 上午11:23:27
 *
 */
public class TwoStackQueue<T> {

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

	}

	/**
	 * 写入的栈
	 */
	private Stack<T> input = new Stack();

	/**
	 * 移除队列所出的栈
	 */
	private Stack<T> out = new Stack();

	/**
	 * 写入队列
	 * 
	 * @param t
	 */
	public void appendTail(T t) {
		input.push(t);
	}

	/**
	 * 删除队列头结点 并返回删除数据
	 * 
	 * @return
	 */
	public T deleteHead() {

		// 是空的 需要将 input 出栈写入 out
		if (out.isEmpty()) {
			while (!input.isEmpty()) {
				out.push(input.pop());
			}
		}

		// 不为空时直接移除出栈就表示移除了头结点
		return out.pop();
	}

	public int getSize() {
		return input.size() + out.size();
	}

}
