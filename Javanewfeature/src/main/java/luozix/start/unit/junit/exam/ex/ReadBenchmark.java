/**
 * Project Name:java11_in_action File Name:ReadBenchmark.java Package
 * Name:luozix.start.unit.junit.exam.ex Date:2021年3月8日上午11:29:01 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ReadBenchmark.java @Package luozix.start.unit.junit.exam.ex @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月8日 上午11:29:01
 * @version V1.0
 */
package luozix.start.unit.junit.exam.ex;
/**
 * ClassName:ReadBenchmark <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月8日 上午11:29:01 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ReadBenchmark @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月8日 上午11:29:01
 * @version
 * @since JDK 1.8
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReadBenchmark {

  static int arrLen = 0;

  static int[] lenArr = {32, 64, 128, 512, 1024, 2048, 4096, 8192, 16384, 134217728, 1073741824};

  public static void main(String[] args) throws Exception {

    for (int i : lenArr) {
      arrLen = i;
      MmapBM.read();
      FileChannelBM.read();
      RandomAccessFileBM.read();
      FileInput.read();
      System.out.println("============================== length : " + i);
    }
  }

  static class FileInput {

    static void read() throws IOException {
      File file = FileUtil.getAlreadyFillFile();

      FileInputStream fs = new FileInputStream(file);

      long s = System.currentTimeMillis();
      while (true) {
        byte[] arr = new byte[arrLen];
        int len = fs.read(arr);
        if (len == -1) {
          break;
        }
      }
      long e = System.currentTimeMillis();
      System.out.println("FileInputStream cost : " + (e - s));
    }
  }

  static class MmapBM {

    static void read() throws IOException {

      final MappedByteBuffer mb = FileUtil.getMappedByteBuffer();

      byte[] arr = new byte[arrLen];
      long s = System.currentTimeMillis();
      while (mb.hasRemaining()) {
        mb.get(arr);
        arr = new byte[arrLen];
      }
      long e = System.currentTimeMillis();
      System.out.println("mmp cost : " + (e - s));
    }
  }

  static class RandomAccessFileBM {

    static void read() throws IOException {
      RandomAccessFile ra = FileUtil.getRandomAccessFile();
      long s = System.currentTimeMillis();
      while (true) {
        byte[] arr = new byte[arrLen];
        int len = ra.read(arr);
        if (len == -1) {
          break;
        }
      }
      long e = System.currentTimeMillis();
      System.out.println("RandomAccessFile cost : " + (e - s));
    }
  }

  static class FileChannelBM {

    static void read() throws Exception {

      FileChannel fc = FileUtil.getFileChannel();

      ByteBuffer byteBuffer = ByteBuffer.allocate(arrLen);

      long s = System.currentTimeMillis();
      while (true) {
        int len = fc.read(byteBuffer);
        byteBuffer.clear();
        if (len == -1) {
          break;
        }
      }
      long e = System.currentTimeMillis();
      System.out.println("fileChannel cost : " + (e - s));
    }
  }
}
