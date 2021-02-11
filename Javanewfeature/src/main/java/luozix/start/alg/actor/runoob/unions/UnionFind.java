package luozix.start.alg.actor.runoob.unions;

/**
 * 并查集的构造
 */
public class UnionFind {
    private int[] id;
    // 数据个数
    private int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        // 初始化, 每一个id[i]指向自己, 没有合并的元素
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

}