/**
 * Project Name:java11_in_action File Name:FileUtil.java Package
 * Name:luozix.start.unit.junit.exam.ex Date:2021年3月8日上午11:26:55 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: FileUtil.java @Package luozix.start.unit.junit.exam.ex @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月8日 上午11:26:55
 * @version V1.0
 */
package luozix.start.unit.junit.exam.ex;
/**
 * ClassName:FileUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月8日 上午11:26:55 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: FileUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月8日 上午11:26:55
 * @version
 * @since JDK 1.8
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.UUID;

public class FileUtil {

  static File getRandomFile() {
    String fileName = UUID.randomUUID().toString();

    File file = new File(fileName);
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                new Runnable() {
                  @Override
                  public void run() {
                    file.delete();
                  }
                }));
    return file;
  }

  static RandomAccessFile getRandomAccessFile() throws IOException {
    File file = FileUtil.getAlreadyFillFile();
    RandomAccessFile ra = new RandomAccessFile(file, "r");
    return ra;
  }

  static FileChannel getFileChannel() throws FileNotFoundException {
    File file = FileUtil.getRandomFile();
    FileChannel fc = new RandomAccessFile(file, "rw").getChannel();
    return fc;
  }

  static MappedByteBuffer getMappedByteBuffer() throws IOException {
    File file = FileUtil.getRandomFile();
    MappedByteBuffer mb =
        new RandomAccessFile(file, "rw")
            .getChannel()
            .map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 1024 * 1024);
    return mb;
  }

  static File getAlreadyFillFile() throws IOException {
    File file = getRandomFile();
    FileOutputStream fo = new FileOutputStream(file);
    byte[] arr = new byte[1024 * 1024 * 1024];
    Arrays.fill(arr, (byte) 1);
    fo.write(arr);
    return file;
  }
}
