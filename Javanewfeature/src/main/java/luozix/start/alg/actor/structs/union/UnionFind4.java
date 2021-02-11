/**  
* @Title: UnionFind4.java
* @Package luozix.start.alg.actor.structs.union
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午3:06:09
* @version V1.0  
*/
package luozix.start.alg.actor.structs.union;
/**
* @ClassName: UnionFind4
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午3:06:09
*
*/
/**
 * 基于rank的优化
 */
public class UnionFind4 {
	private int[] rank; // rank[i]表示以i为根的集合所表示的树的层数
	private int[] parent; // parent[i]表示第i个元素所指向的父节点
	private int count; // 数据个数
	// 构造函数

	public UnionFind4(int count) {
		rank = new int[count];
		parent = new int[count];
		this.count = count;
		// 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
		for (int i = 0; i < count; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	// 查找过程, 查找元素p所对应的集合编号
	// O(h)复杂度, h为树的高度
	private int find(int p) {
		assert (p >= 0 && p < count);
		// 不断去查询自己的父亲节点, 直到到达根节点
		// 根节点的特点: parent[p] == p
		while (p != parent[p])
			p = parent[p];
		return p;
	}

	// 查看元素p和元素q是否所属一个集合
	// O(h)复杂度, h为树的高度
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	// 合并元素p和元素q所属的集合
	// O(h)复杂度, h为树的高度
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		if (rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = qRoot;
		} else if (rank[qRoot] < rank[pRoot]) {
			parent[qRoot] = pRoot;
		} else { // rank[pRoot] == rank[qRoot]
			parent[pRoot] = qRoot;
			rank[qRoot] += 1; // 维护rank的值
		}
	}
}
