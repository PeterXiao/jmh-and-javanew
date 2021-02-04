/**
 * 
 */
package luozix.start.exams.alg;

/**
 * @author xiaoy
 *
 */
public class LinkLoop {

	public static class Node {
		private Object data;
		public Node next;

		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Node(Object data) {
			this.data = data;
		}

		/**
		 * 判断链表是否有环
		 * 
		 * @param node
		 * @return
		 */
		public boolean isLoop(Node node) {// • 是否循环链表
			Node slow = node;
			Node fast = node.next;

			while (slow.next != null) {// • 优化
				Object dataSlow = slow.data;// • 是否循环链表
				Object dataFast = fast.data;

				// 说明有环
				if (dataFast == dataSlow) {
					return true;
				}

				// 一共只有两个节点，但却不是环形链表的情况，判断NPE//• 更新
				if (fast.next == null) {// • 修复只有两个节点的链表
					return false;
				}
				// slow走慢点 fast走快点//• 是否循环链表
				slow = slow.next;
				fast = fast.next.next;

				// 如果走的快的发现为空 说明不存在环
				if (fast == null) {
					return false;
				}
			}
			return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * Function:是否是环链表，采用快慢指针，一个走的快些一个走的慢些 如果最终相遇了就说明是环
 * 就相当于在一个环形跑道里跑步，速度不一样的最终一定会相遇。
 *
 */