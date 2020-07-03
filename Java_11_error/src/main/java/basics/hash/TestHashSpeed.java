/**
 *
 */
package basics.hash;

import java.nio.charset.Charset;

import org.junit.Test;

/**
 * @author yonik
 */
public class TestHashSpeed {

	static Charset utf8Charset = Charset.forName("UTF-8");

	public static void main(String[] args) throws Exception {
		final int arg = 0;
		final int size = Integer.parseInt("1000"); // args[arg++]
		final int iter = Integer.parseInt("1024"); // args[arg++]
		final String method = "murmur32";// args[arg++]; murmur32 fast_string slow_string

		final byte[] arr = new byte[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (i & 0x7f);
		}
		final String s = new String(arr, "UTF-8");

		int ret = 0;
		final long start = System.currentTimeMillis();

		if (method == null || method.equals("murmur32")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(arr, offset, len, i);
			}
		} else if (method.equals("slow_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				final byte[] utf8 = s.getBytes(utf8Charset);
				ret += MurmurHash3.murmurhash3_x86_32(utf8, offset, len, i);
			}
		} else if (method.equals("fast_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(s, offset, len, i);
			}
		} else {
			throw new RuntimeException("Unknown method " + method);
		}

		final long end = System.currentTimeMillis();

		System.out.println(
				"method=" + method + " result=" + ret + " throughput=" + 1000 * ((double) size) * iter / (end - start));

	}

	@Test
	public void murmur32() throws Exception {
		final int arg = 0;
		final int size = Integer.parseInt("1000"); // args[arg++]
		final int iter = Integer.parseInt("1024"); // args[arg++]
		final String method = "murmur32";// args[arg++]; murmur32 fast_string slow_string

		final byte[] arr = new byte[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (i & 0x7f);
		}
		final String s = new String(arr, "UTF-8");

		int ret = 0;
		final long start = System.currentTimeMillis();

		if (method == null || method.equals("murmur32")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(arr, offset, len, i);
			}
		} else if (method.equals("slow_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				final byte[] utf8 = s.getBytes(utf8Charset);
				ret += MurmurHash3.murmurhash3_x86_32(utf8, offset, len, i);
			}
		} else if (method.equals("fast_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(s, offset, len, i);
			}
		} else {
			throw new RuntimeException("Unknown method " + method);
		}

		final long end = System.currentTimeMillis();

		System.out.println(
				"method=" + method + " result=" + ret + " throughput=" + 1000 * ((double) size) * iter / (end - start));

	}

	@Test
	public void slow_string() throws Exception {
		final int arg = 0;
		final int size = Integer.parseInt("1000"); // args[arg++]
		final int iter = Integer.parseInt("1024"); // args[arg++]
		final String method = "slow_string";// args[arg++]; murmur32 fast_string slow_string

		final byte[] arr = new byte[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (i & 0x7f);
		}
		final String s = new String(arr, "UTF-8");

		int ret = 0;
		final long start = System.currentTimeMillis();

		if (method == null || method.equals("murmur32")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(arr, offset, len, i);
			}
		} else if (method.equals("slow_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				final byte[] utf8 = s.getBytes(utf8Charset);
				ret += MurmurHash3.murmurhash3_x86_32(utf8, offset, len, i);
			}
		} else if (method.equals("fast_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(s, offset, len, i);
			}
		} else {
			throw new RuntimeException("Unknown method " + method);
		}

		final long end = System.currentTimeMillis();

		System.out.println(
				"method=" + method + " result=" + ret + " throughput=" + 1000 * ((double) size) * iter / (end - start));

	}

	@Test
	public void fast_string() throws Exception {
		final int arg = 0;
		final int size = Integer.parseInt("1000"); // args[arg++]
		final int iter = Integer.parseInt("1024"); // args[arg++]
		final String method = "fast_string";// args[arg++]; murmur32 fast_string slow_string

		final byte[] arr = new byte[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (i & 0x7f);
		}
		final String s = new String(arr, "UTF-8");

		int ret = 0;
		final long start = System.currentTimeMillis();

		if (method == null || method.equals("murmur32")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(arr, offset, len, i);
			}
		} else if (method.equals("slow_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				final byte[] utf8 = s.getBytes(utf8Charset);
				ret += MurmurHash3.murmurhash3_x86_32(utf8, offset, len, i);
			}
		} else if (method.equals("fast_string")) {
			for (int i = 0; i < iter; i++) {
				// change offset and len so internal conditionals aren't predictable
				final int offset = ret & 0x03;
				final int len = arr.length - offset - ((ret >> 3) & 0x03);
				ret += MurmurHash3.murmurhash3_x86_32(s, offset, len, i);
			}
		} else {
			throw new RuntimeException("Unknown method " + method);
		}

		final long end = System.currentTimeMillis();

		System.out.println(
				"method=" + method + " result=" + ret + " throughput=" + 1000 * ((double) size) * iter / (end - start));

	}
}
