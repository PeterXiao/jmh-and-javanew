    /** 
	 * Project Name:java11_in_action 
	 * File Name:StringDemo.java 
	 * Package Name:luozix.start.perf 
	 * Date:2021年3月2日上午9:48:11 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: StringDemo.java
* @Package luozix.start.perf
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 上午9:48:11
* @version V1.0  
*/  
	  
	package luozix.start.perf;  
	/** 
	 * ClassName:StringDemo <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年3月2日 上午9:48:11 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import java.util.concurrent.TimeUnit;

/**
* @ClassName: StringDemo
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月2日 上午9:48:11
* @version  
*@since JDK 1.8
*/
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringDemo {

	@Benchmark
	public void stringAdd() {
		String a = "";
		for (int i = 0; i < 10; i++) {
			a += i;
		}
		// System.out.println(a);
	}

	@Benchmark
	public void stringBuildAdd() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			stringBuilder.append(i);
		}
		// System.out.println(stringBuilder.toString());
	}

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(StringDemo.class.getSimpleName())
				.output("stringbench.log").build();
		new Runner(options).run();
	}
}
