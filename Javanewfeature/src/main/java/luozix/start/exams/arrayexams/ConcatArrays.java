/**
 * 
 */
package luozix.start.exams.arrayexams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
/**
 * @author xiaoy
 *
 */
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatArrays {

	public static void main(String[] args) {
		int[] myNumbers = new int[] { 1, 2, 3, 4 };
		int[] yourNumbers = new int[] { 5, 6, 7 };
		int[] theirNumbers = new int[] { 8, 9, 0 };

		// 按需要分配buffer
		IntBuffer intBuffer = IntBuffer.allocate(myNumbers.length + yourNumbers.length + theirNumbers.length);

		// 放入到buffer
		intBuffer.put(myNumbers);
		intBuffer.put(yourNumbers);
		intBuffer.put(theirNumbers);

		// 得到合并后的数组
		int[] allNumber = intBuffer.array();

		// 显示合并后的数组
		for (int i : allNumber) {
			System.out.print(i);
			System.out.print(", ");
		}

		// 各种数据原始类型都有buffer可用，非常方便
		LongBuffer longBuffer = LongBuffer.allocate(10);
		DoubleBuffer doubleBuffer = DoubleBuffer.allocate(10);
		FloatBuffer floatBuffer = FloatBuffer.allocate(10);
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		ShortBuffer shortBuffer = ShortBuffer.allocate(10);
		CharBuffer charBuffer = CharBuffer.allocate(10);

		System.out.print("\n--------------------------------------\n ");
		String a[] = { "A", "E", "I" };
		String b[] = { "O", "U" };
		List list = new ArrayList(Arrays.asList(a));
		list.addAll(Arrays.asList(b));
		Object[] c = list.toArray();
		System.out.println(Arrays.toString(c));
	}

	// 实际上不会因为数组读写而抛出异常
	byte[] getStrunctureBytes(byte[] data) throws IOException {
		byte[] groupUID = new BigInteger("0123").toByteArray();
		byte[] sn = new BigInteger("456").toByteArray();
		byte[] bodySize = new BigInteger("789").toByteArray();

		// 上边三个字节数组用16字节空间+data的大小，以此大小分配缓冲区避免反复分配和复制内存
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16 + data.length);
		byteArrayOutputStream.write(groupUID);
		byteArrayOutputStream.write(sn);
		byteArrayOutputStream.write(bodySize);
		byteArrayOutputStream.write(data);
		byteArrayOutputStream.flush();// 字节数组流的冲刷其实没有用，但是使用流的时候及时冲刷是好习惯

		return byteArrayOutputStream.toByteArray();
	}
}
