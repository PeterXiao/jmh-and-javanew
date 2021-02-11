package luozix.start.alg.actor.runoob.graph.read;


public class GraphReadTest {
    public static void main(String[] args) {
        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "testG1.txt";
        SparseGraphImpl g1 = new SparseGraphImpl(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println();

        DenseGraphImpl g2 = new DenseGraphImpl(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename);
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        filename = "testG2.txt";
        SparseGraphImpl g3 = new SparseGraphImpl(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraphImpl g4 = new DenseGraphImpl(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();

    }

}