/**
 * Project Name:java11_in_action File Name:WriteBenchmark.java Package
 * Name:luozix.start.unit.junit.exam.ex Date:2021年3月8日上午11:30:07 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: WriteBenchmark.java @Package luozix.start.unit.junit.exam.ex @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月8日 上午11:30:07
 * @version V1.0
 */
package luozix.start.unit.junit.exam.ex;
/**
 * ClassName:WriteBenchmark <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月8日 上午11:30:07 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: WriteBenchmark @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月8日 上午11:30:07
 * @version
 * @since JDK 1.8
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class WriteBenchmark {

  static long fileSize = 1024 * 1024 * 1024;

  static int arrLen = 0;

  static int[] lenArr = {32, 64, 128, 512, 1024, 2048, 4096, 8192, 16384, 134217728, 1073741824};

  public static void main(String[] args) throws Exception {
    for (int i : lenArr) {
      arrLen = i;
      MmapBM.write();
      FileChannelBM.write();
      RandomAccessFileBM.write();
      FileOutputStreamBM.write();
      System.out.println("============================== length : " + i);
    }
  }

  static class MmapBM {

    static void write() throws IOException {

      MappedByteBuffer mb = FileUtil.getMappedByteBuffer();

      byte[] arr = new byte[arrLen];
      Arrays.fill(arr, (byte) 2);
      int length = 0;
      long s = System.currentTimeMillis();
      while (length < mb.capacity()) {
        length += arr.length;
        mb.put(arr);
      }
      // 测试 force, 纯粹写测试时,应该关闭,对性能影响很大
      //            long s1 = System.currentTimeMillis();
      //            mb.force();
      //            long s2 = System.currentTimeMillis();
      //            System.out.println("force : " + (s2 - s1));
      long e = System.currentTimeMillis();
      System.out.println("MappedByteBuffer cost : " + (e - s));
    }
  }

  static class FileChannelBM {

    static void write() throws IOException {
      FileChannel fc = FileUtil.getFileChannel();

      byte[] arr = new byte[arrLen];
      Arrays.fill(arr, (byte) 2);

      int length = 0;
      long s = System.currentTimeMillis();
      ByteBuffer b = ByteBuffer.wrap(arr);
      while (length < fileSize) {
        length += arr.length;
        fc.write(b);
      }
      long e = System.currentTimeMillis();
      System.out.println("FileChannel cost : " + (e - s));
    }
  }

  static class RandomAccessFileBM {

    static void write() throws IOException {

      RandomAccessFile ra = FileUtil.getRandomAccessFile();

      byte[] arr = new byte[arrLen];
      Arrays.fill(arr, (byte) 2);
      long s = System.currentTimeMillis();
      int length = 0;
      while (length < fileSize) {
        length += arr.length;
        ra.write(arr);
      }

      long e = System.currentTimeMillis();
      System.out.println("RandomAccessFile cost : " + (e - s));
    }
  }

  static class FileOutputStreamBM {

    static void write() throws IOException {
      File file = FileUtil.getRandomFile();

      FileOutputStream fo = new FileOutputStream(file);

      byte[] arr = new byte[arrLen];
      Arrays.fill(arr, (byte) 2);
      long s = System.currentTimeMillis();
      int length = 0;
      while (length < fileSize) {
        length += arr.length;
        fo.write(arr);
      }
      long e = System.currentTimeMillis();
      System.out.println("FileOutputStream cost : " + (e - s));
    }
  }
}
