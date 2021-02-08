/**  
* @Title: Node.java
* @Package luozix.start.alg.actor.structs.linkedlist
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:15:51
* @version V1.0  
*/
package luozix.start.alg.actor.structs.linkedlist;

/**
* @ClassName: Node
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:15:51
*
*/

public class Node {

	/** The value of the node */
	int value;

	/** Point to the next node */
	Node next;

	Node() {
	}

	/**
	 * Constructor
	 *
	 * @param value Value to be put in the node
	 */
	Node(int value) {
		this(value, null);
	}

	/**
	 * Constructor
	 *
	 * @param value Value to be put in the node
	 * @param next  Reference to the next node
	 */
	Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

}
