/**  
* @Title: UnionFind.java
* @Package luozix.start.alg.actor.structs.union
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午3:00:42
* @version V1.0  
*/
package luozix.start.alg.actor.structs.union;
/**
* @ClassName: UnionFind
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午3:00:42
*
*/
public class UnionFind {
	private int[] id;
	// 数据个数
	private int count;

	public UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }
}
