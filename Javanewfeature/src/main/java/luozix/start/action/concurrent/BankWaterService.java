/**  
* @Title: BankWaterService.java
* @Package luozix.start.action.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 上午10:57:13
* @version V1.0  
*/
package luozix.start.action.concurrent;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * @ClassName: BankWaterService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月6日 上午10:57:13
 *
 */
public class BankWaterService implements Runnable {

	// 创建4个屏障，处理完之后执行当前类的run方法

	private CyclicBarrier c = new CyclicBarrier(4, this);

	// 假设只有4个sheet，所以只启动4个线程

	private Executor executor = Executors.newFixedThreadPool(4);

	// 保存每个sheet计算出的银流结果<String, Integer>

	private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

	private void count() {

		for (int i = 0; i < 4; i++) {

			executor.execute(new Runnable() {

				@Override

				public void run() {

					// 计算当前sheet的银流数据，计算代码省略

					sheetBankWaterCount.put(Thread.currentThread().getName(), 1);

					// 银流计算完成，插入一个屏障

					try {

						c.await();

					} catch (InterruptedException | BrokenBarrierException e) {

						e.printStackTrace();

					}

				}

			});

		}

	}

	@Override

	public void run() {

	int result = 0;

	// 汇总每个sheet计算出的结果 (int)

	for (Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {

		result += sheet.getValue();

	}

	//将结果输出

	sheetBankWaterCount.put("result", result);

	System.out.println(result);

	}

	public static void main(String[] args) {

		BankWaterService bankWaterCount = new BankWaterService();

		bankWaterCount.count();

	}

}

