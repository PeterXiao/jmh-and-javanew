# 二分搜索树

二分搜索树（英语：Binary Search Tree），也称为 二叉查找树 、二叉搜索树 、有序二叉树或排序二叉树。满足以下几个条件：

若它的左子树不为空，左子树上所有节点的值都小于它的根节点。
若它的右子树不为空，右子树上所有的节点的值都大于它的根节点。
它的左、右子树也都是二分搜索树。	 

二分搜索树有着高效的插入、删除、查询操作。

平均时间的时间复杂度为 O(log n)，最差情况为 O(n)。二分搜索树与堆不同，不一定是完全二叉树，底层不容易直接用数组表示故采用链表来实现二分搜索树。  



二分搜索树深度优先遍历
二分搜索树遍历分为两大类，深度优先遍历和层序遍历。

深度优先遍历分为三种：先序遍历（preorder tree walk）、中序遍历（inorder tree walk）、后序遍历（postorder tree walk），分别为：

1、前序遍历：先访问当前节点，再依次递归访问左右子树。
2、中序遍历：先递归访问左子树，再访问自身，再递归访问右子树。
3、后序遍历：先递归访问左右子树，再访问自身节点。    

二分搜索树的层序遍历，即逐层进行遍历，即将每层的节点存在队列当中，然后进行出队（取出节点）和入队（存入下一层的节点）的操作，以此达到遍历的目的。

通过引入一个队列来支撑层序遍历：

如果根节点为空，无可遍历；

如果根节点不为空：

先将根节点入队；

只要队列不为空：

出队队首节点，并遍历；
如果队首节点有左孩子，将左孩子入队；
如果队首节点有右孩子，将右孩子入队； 

# 二分搜索树的特性  

非平衡二叉树
二叉搜索树可能退化成链表，相应的，二叉搜索树的查找操作是和这棵树的高度相关的，而此时这颗树的高度就是这颗树的节点数 n，同时二叉搜索树相应的算法全部退化成 O(n) 级别。

一、顺序性
二分搜索树可以当做查找表的一种实现。

我们使用二分搜索树的目的是通过查找 key 马上得到 value。minimum、maximum、successor（后继）、predecessor（前驱）、floor（地板）、ceil（天花板、rank（排名第几的元素）、select（排名第n的元素是谁）这些都是二分搜索树顺序性的表现。

二、局限性
二分搜索树在时间性能上是具有局限性的。

如下图所示，元素节点一样，组成两种不同的二分搜索树，都是满足定义的：