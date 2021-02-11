/**  
* @Title: DenseGraph.java
* @Package luozix.start.alg.actor.structs.graph
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午3:18:32
* @version V1.0  
*/
package luozix.start.alg.actor.structs.graph;
/**
* @ClassName: DenseGraph
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午3:18:32
*
*/
/**
 * 邻接矩阵
 */
public class DenseGraph {
   // 节点数
   private int n;
   // 边数
   private int m;
   // 是否为有向图
   private boolean directed;
   // 图的具体数据
   private boolean[][] g;

   // 构造函数
   public DenseGraph( int n , boolean directed ){
       assert n >= 0;
       this.n = n;
       this.m = 0;
       this.directed = directed;
       // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
       // false为boolean型变量的默认值
       g = new boolean[n][n];
   }
   // 返回节点个数
   public int V(){ return n;}
   // 返回边的个数
   public int E(){ return m;}

   // 向图中添加一个边
   public void addEdge( int v , int w ){
       assert v >= 0 && v < n ;
       assert w >= 0 && w < n ;
       if( hasEdge( v , w ) )
           return;
       g[v][w] = true;
       if( !directed )
           g[w][v] = true;
       m ++;
   }

   // 验证图中是否有从v到w的边
   boolean hasEdge( int v , int w ){
       assert v >= 0 && v < n ;
       assert w >= 0 && w < n ;
       return g[v][w];
   }
}
