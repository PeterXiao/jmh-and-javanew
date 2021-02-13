/**  
* @Title: MyBenchmark.java
* @Package luozix.start.perf
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午6:02:26
* @version V1.0  
*/
package luozix.start.perf;
/**
* @ClassName: MyBenchmark
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午6:02:26
*
*/

import java.util.stream.DoubleStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class MyBenchmark {

	private static final int POPULATION_SIZE = 30_000_000;
	double[] population;

	@Setup
	public void init() {
		population = DoubleStream.generate(Variance::randInt).limit(POPULATION_SIZE).toArray();
	}

	@Benchmark
	public double testVarianceImperative() {
		return Variance.varianceImperative(population);
	}

	@Benchmark
	public double testVarianceStreams() {
		return Variance.varianceStreams(population);
	}

	@Benchmark
	public double testVarianceForkJoin() {
		return Variance.varianceForkJoin(population);
	}

}
