

图的分类：无权图和有权图，连接节点与节点的边是否有数值与之对应，有的话就是有权图，否则就是无权图。

图的连通性：在图论中，连通图基于连通的概念。在一个无向图 G 中，若从顶点 i 到顶点 j 有路径相连（当然从j到i也一定有路径），则称 i 和 j 是连通的。如果 G 是有向图，那么连接i和j的路径中所有的边都必须同向。如果图中任意两点都是连通的，那么图被称作连通图。如果此图是有向图，则称为强连通图（注意：需要双向都有路径）。图的连通性是图的基本性质。

完全图：完全是一个简单的无向图，其中每对不同的顶点之间都恰连有一条边相连。

自环边：一条边的起点终点是一个点。

平行边：两个顶点之间存在多条边相连接。



二、适用说明
图可用于在物理、生物、社会和信息系统中建模许多类型的关系和过程，许多实际问题可以用图来表示。因此，图论成为运筹学、控制论、信息论、网络理论、博弈论、物理学、化学、生物学、社会科学、语言学、计算机科学等众多学科强有力的数学工具。在强调其应用于现实世界的系统时，网络有时被定义为一个图，其中属性(例如名称)之间的关系以节点和或边的形式关联起来。

三、图的表达形式
邻接矩阵：1 表示相连接，0 表示不相连。

邻接表适合表示稀疏图 (Sparse Graph)

邻接矩阵适合表示稠密图 (Dense Graph)


广度优先遍历与最短路径
广度优先遍历从某个顶点 v 出发，首先访问这个结点，并将其标记为已访问过，然后顺序访问结点v的所有未被访问的邻接点 {vi,..,vj} ，并将其标记为已访问过，然后将 {vi,...,vj} 中的每一个节点重复节点v的访问方法，直到所有结点都被访问完为止。

我们可以分为三个步骤：

（1）使用一个辅助队列 q，首先将顶点 v 入队，将其标记为已访问，然后循环检测队列是否为空。
（2）如果队列不为空，则取出队列第一个元素，并将与该元素相关联的所有未被访问的节点入队，将这些节点标记为已访问。
（3）如果队列为空，则说明已经按照广度优先遍历了所有的节点。



只用散列表也可以实现一个图，但是以面向对象的方法来写会更加健壮。



以下便是一种更为健壮的实现方式，它采用的语言是Ruby。

	class Person
	
	  attr_accessor :name, :friends
	
	  def initialize(name)
	    @name = name
	    @friends = []
	  end
	
	  def add_friend(friend)
	    @friends << friend
	  end
	
	end

图有两种经典的遍历方式：广度优先搜索 和深度优先搜索 。在此我们会研究广度优先搜索，深度优先搜索你可以自己去学习。两者是相似的，并且在大多数情况下都一样好用。

	class Person
	
	  attr_accessor :name, :friends, :visited
	
	  def initialize(name)
	    @name = name
	    @friends = []
	    @visited = false
	  end
	
	  def add_friend(friend)
	    @friends << friend
	  end
	
	  def display_network
	    # 记下每个访问过的人，以便算法完结后能重置他们的visited属性为false
	    to_reset = [self]
	
	    # 创建一个开始就含有根顶点的队列
	    queue = [self]
	    self.visited = true
	
	    while queue.any?
	      # 设出队的顶点为当前顶点
	      current_vertex = queue.shift
	      puts current_vertex.name
	
	      # 将当前顶点的所有未访问的邻接点加入队列
	      current_vertex.friends.each do |friend|
	        if !friend.visited
	          to_reset << friend
	          queue << friend
	          friend.visited = true
	        end
	      end
	    end
	
	    # 算法完结时，将访问过的结点的visited属性重置为false
	    to_reset.each do |node|
	      node.visited = false
	    end
	  end
	
	end
	
Neo4j是开源的图数据库中比较受欢迎的一个。我建议你上它的官网去了解更多关于图数据库的知识。其他开源的图数据库还有ArangoDB和Apache Giraph。

但记住，图数据库也并不总是最好的解决方案。你得谨慎地评估每个应用场景的需求再做选择。	



	class City
	
	  attr_accessor :name, :routes
	
	  def initialize(name)
	    @name = name
	    # 把表示邻接点的数组换成散列表
	    @routes = {}
	  end
	
	  def add_route(city, price)
	    @routes[city] = price
	  end
	
	end

Dijkstra算法的规则如下（别担心，之后我们跟着例子运行一遍就会更明白了）。

(1) 以起步的顶点为当前顶点。

(2) 检查当前顶点的所有邻接点，计算起点到所有已知顶点的权重，并记录下来。

(3) 从未访问过 （未曾作为当前顶点）的邻接点中，选取一个起点能到达的总权重最小 的顶点，作为下一个当前顶点。

(4) 重复前3步，直至图中所有顶点都被访问过。	