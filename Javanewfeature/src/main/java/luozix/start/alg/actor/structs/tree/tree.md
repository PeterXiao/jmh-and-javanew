python的删除二叉树节点

		def delete(valueToDelete, node):
		
		    # 当前位置的上一层无子结点，已到达树的底层，即基准情形
		    if node is None:
		        return None
		
		    # 如果要删除的值小于（或大于）当前结点，
		    # 则以左子树（或右子树）为参数，递归调用本方法，
		    # 然后将当前结点的左链（或右链）指向返回的结点
		    elif valueToDelete < node.value:
		        node.leftChild = delete(valueToDelete, node.leftChild)
		        # 将当前结点（及其子树，如果存在的话）返回，
		        # 作为其父结点的新左子结点（或新右子结点）
		        return node
		    elif valueToDelete > node.value:
		        node.rightChild = delete(valueToDelete, node.rightChild)
		        return node
		
		    # 如果要删除的正是当前结点
		    elif valueToDelete == node.value:
		
		        # 如果当前结点没有左子结点，
		        # 则以右子结点（及其子树，如果存在的话）替换当前结点成为当前结点之父结点的新子结点
		        if node.leftChild is None:
		            return node.rightChild
		
		            # 如果当前结点没有左子结点，也没有右子结点，那这里就是返回None
		
		        elif node.rightChild is None:
		            return node.leftChild
		
		        # 如果当前结点有两个子结点，则用lift函数（见下方）来做删除，
		        # 它会使当前结点的值变成其后继结点的值
		        else:
		            node.rightChild = lift(node.rightChild, node)
		            return node
		
		def lift(node, nodeToDelete):
		
		    # 如果此函数的当前结点有左子结点，
		    # 则递归调用本函数，从左子树找出后继结点
		    if node.leftChild:
		        node.leftChild = lift(node.leftChild, nodeToDelete)
		        return node
		    # 如果此函数的当前结点无左子结点，
		    # 则代表当前结点是后继结点，于是将其值设置为被删除结点的新值
		    else:
		        nodeToDelete.value = node.value
		        # 用后继结点的右子结点替代后继结点的父节点的左子结点
		        return node.rightChild
		        
		        
树形的数据结构除了二叉树以外还有很多种，包括堆、B树、红黑树、2-3-4树等。它们也各有自己适用的场景		        