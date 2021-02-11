package luozix.start.alg.actor.runoob.graph.read;

/**
 * 图的抽象接口
 */
public interface Graph {
    public int V();
    public int E();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Integer> adj(int v);
}
