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