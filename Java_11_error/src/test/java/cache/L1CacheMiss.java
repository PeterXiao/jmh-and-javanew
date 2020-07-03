/**
 *
 */
package cache;

/**
 * @author LiY
 * @time 下午3:35:57
 */
public class L1CacheMiss {
	private static final int RUNS = 10;
	private static final int DIMENSION_1 = 1024 * 1024;
	private static final int DIMENSION_2 = 62;

	private static long[][] longs;

	public static void main(String[] args) throws Exception {

		/* 初始化一个1024*1024行、62列的二位数组（矩阵），矩阵的每个元素都是0 */
		Thread.sleep(10000);
		longs = new long[DIMENSION_1][];
		for (int i = 0; i < DIMENSION_1; i++) {
			longs[i] = new long[DIMENSION_2];
			for (int j = 0; j < DIMENSION_2; j++) {
				longs[i][j] = 0L;
			}
		}
		System.out.println("starting....");

		final long start = System.nanoTime();
		long sum = 0L;
		for (int r = 0; r < RUNS; r++) {
			/* 对列遍历，然后逐个累加每列中所有行 */
			for (int j = 0; j < DIMENSION_2; j++) {
				for (int i = 0; i < DIMENSION_1; i++) {
					sum += longs[i][j];
				}
			}
//			/* 对行遍历，然后逐个累加每行中所有列 */
//			for (int i = 0; i < DIMENSION_1; i++) {
//				for (int j = 0; j < DIMENSION_2; j++) {
//					sum += longs[i][j];
//				}
//			}
		}
		System.out.println("duration = " + (System.nanoTime() - start));
	}
}
