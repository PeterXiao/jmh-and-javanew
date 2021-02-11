/**  
* @Title: BinarySearchTreeInsert.java
* @Package luozix.start.alg.actor.structs.tree.bst
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:47:49
* @version V1.0  
*/
package luozix.start.alg.actor.structs.tree.bst;

/**
* @ClassName: BinarySearchTreeInsert
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午2:47:49
*
*/

/**
 * 二分搜索树插入新的元素
 */

public class BinarySearchTreeInsert<Key extends Comparable<Key>, Value> {

	// 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}

	private Node root; // 根节点
	private int count; // 树种的节点个数

	// 构造函数, 默认构造一棵空二分搜索树
	public BinarySearchTreeInsert() {
		root = null;
		count = 0;
	}

	// 返回二分搜索树的节点个数
	public int size() {
		return count;
	}

	// 返回二分搜索树是否为空
	public boolean isEmpty() {
		return count == 0;
	}

	// 向二分搜索树中插入一个新的(key, value)数据对
	public void insert(Key key, Value value) {
		root = insert(root, key, value);
	}

	// 核心代码---开始
	// 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
	// 返回插入新节点后的二分搜索树的根
	private Node insert(Node node, Key key, Value value) {
		if (node == null) {
			count++;
			return new Node(key, value);
		}
		if (key.compareTo(node.key) == 0)
			node.value = value;
		else if (key.compareTo(node.key) < 0)
			node.left = insert(node.left, key, value);
		else // key > node->key
			node.right = insert(node.right, key, value);

		return node;
	}
//	1.在递归调用之前并没有判断当前这个node的左右节点是否为null
//
//	2.count数目并不是当前的tree的节点数
//	private Node insert(Node node, K key, V value) {
//		if (node == null) {
//			root = new Node<>(key, value);
//			count++;
//			return root;
//		}
//		if (key.compareTo(node.getKey()) == 0) {
//			node.setValue(value);
//		} else if (key.compareTo(node.getKey()) < 0) {
//			if (null == node.getLeft()) {
//				node.setLeft(new TreeNode(key, value));
//				count++;
//				return node;
//			}
//			insert(node.getLeft(), key, value);
//		} else {
//			if (null == node.getRight()) {
//				node.setRight(new TreeNode(key, value));
//				count++;
//				return node;
//			}
//			insert(node.getRight(), key, value);
//		}
//		return node;
//	}
	// 核心代码---结束
}
