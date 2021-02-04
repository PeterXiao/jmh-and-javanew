package jmh;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, jvmArgsAppend = { "-XX:+UseSuperWord", "-XX:+UnlockDiagnosticVMOptions",
		"-XX:CompileCommand=print,*BenchmarkSIMDBlog.array1" })
@Warmup(iterations = 5)
@Measurement(iterations = 10)
public class BenchmarkSIMDBlog {

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(BenchmarkSIMDBlog.class.getSimpleName()).forks(1).build();

		new Runner(opt).run();
	}
	public static final int SIZE = 1024;

	@State(Scope.Thread)
	public static class Context {
		public final int[] values = new int[SIZE];
		public final int[] results = new int[SIZE];

		@Setup
		public void setup() {
			Random random = new Random();
			for (int i = 0; i < SIZE; i++) {
				values[i] = random.nextInt(Integer.MAX_VALUE / 32);
			}
		}
	}

	@Benchmark
	public int[] increment(Context context) {
		for (int i = 0; i < SIZE; i++) {
			context.results[i] = context.values[i] + 1;
		}
		return context.results;
	}

	private static int getHashPosition(long rawHash, long mask) {
		rawHash ^= rawHash >>> 33;
		rawHash *= 0xff51afd7ed558ccdL;
		rawHash ^= rawHash >>> 33;
		rawHash *= 0xc4ceb9fe1a85ec53L;
		rawHash ^= rawHash >>> 33;

		return (int) (rawHash & mask);
	}

	private static int getHashPosition(int rawHash, int mask) {
		rawHash ^= rawHash >>> 15;
		rawHash *= 0xed558ccd;
		rawHash ^= rawHash >>> 15;
		rawHash *= 0x1a85ec53;
		rawHash ^= rawHash >>> 15;

		return rawHash & mask;
	}

	@Benchmark
	public int[] hashLoop(Context context) {
		for (int i = 0; i < SIZE; i++) {
			context.results[i] = getHashPosition(context.values[i], 1048575);
		}
		return context.results;
	}

	@Benchmark
	public void hashLoopPart(Context context) {
		for (int i = 0; i < SIZE; i++) {
			context.results[i] = getHashPosition1(context.values[i]);
		}
	}

	private static int getHashPosition1(int rawHash) {
		rawHash ^= rawHash >>> 15;
		return rawHash *= 0xed558ccd;

	}

	@Benchmark
	public int[] hashLoopSplit(Context context) {
		for (int i = 0; i < SIZE; i++) {
			context.results[i] = getHashPosition1(context.values[i]);
		}

		for (int i = 0; i < SIZE; i++) {
			context.results[i] = getHashPosition2(context.results[i]);
		}

		for (int i = 0; i < SIZE; i++) {
			context.results[i] = getHashPosition3(context.results[i], 1048575);
		}

		return context.results;
	}

	private static int getHashPosition2(int rawHash) {
		rawHash ^= rawHash >>> 15;
		rawHash *= 0x1a85ec53;
		return rawHash;
	}

	private static int getHashPosition3(int rawHash, int mask) {
		rawHash ^= rawHash >>> 15;
		return rawHash & mask;
	}
//    private static int getHashPosition(int rawHash, int mask)
//    {
//        rawHash ^= rawHash >>> 15;
//        rawHash *= 0xed558ccd;
//        rawHash ^= rawHash >>> 15;
//        rawHash *= 0x1a85ec53;
//        rawHash ^= rawHash >>> 15;
//
//        return rawHash & mask;
//    }
//    for (int i = 0; i < x.length; i++) {
//    z[i] = x[i] * y[i];
//}
//
//    for (int i = 0; i < x.length; i += 4) {
//       Load x[i, i+1, i+2, i+3] into xmm0
//       Load y[i, i+1, i+2, i+3] into xmm1
//       Multiply xmm0 * xmm1 and store result in xmm0
//       Store xmm0 into z[i, i+1, i+2, i+3]
//   }

}

