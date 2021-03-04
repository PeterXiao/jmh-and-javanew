/**
 * Project Name:java11_in_action File Name:GZipUtil.java Package Name:luozix.start.util.common
 * Date:2021年3月4日下午3:12:10 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: GZipUtil.java @Package luozix.start.util.common @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:12:10
 * @version V1.0
 */
package luozix.start.util.common;
/**
 * ClassName:GZipUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:12:10 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/**
 * @ClassName: GZipUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:12:10
 * @version
 * @since JDK 1.8
 */
public class GZipUtil {

  private GZipUtil() throws IllegalAccessException {
    throw new IllegalAccessException("Instantiation is not allowed! Use static methods only!");
  }

  /**
   * gzip an input stream to a gzipped output stream. You need to close streams manually.
   *
   * @param is input stream
   * @param gzippedOutputStream gzipped output stream
   * @throws IOException
   */
  public static void gzip(InputStream is, GZIPOutputStream gzippedOutputStream) throws IOException {
    byte[] buffer = new byte[1024];
    int len = -1;
    while ((len = is.read(buffer)) != -1) {
      gzippedOutputStream.write(buffer, 0, len);
    }
  }

  /**
   * gzip an input stream to a gzipped file. You need to close streams manually.
   *
   * @param is input stream
   * @param gzippedFile gzipped file
   * @throws IOException
   */
  public static void gzip(InputStream is, File gzippedFile) throws IOException {
    GZIPOutputStream gos = null;
    try {
      gos = new GZIPOutputStream(new FileOutputStream(gzippedFile));
      byte[] buffer = new byte[1024];
      int len = -1;
      while ((len = is.read(buffer)) != -1) {
        gos.write(buffer, 0, len);
      }
    } finally {
      close(gos);
    }
  }

  /**
   * gzip a file to a gzipped file
   *
   * @param srcFile file to be gzipped
   * @param gzippedFile target gzipped file
   * @throws IOException
   */
  public static void gzip(File srcFile, File gzippedFile) throws IOException {
    GZIPOutputStream gos = null;
    FileInputStream fis = null;
    try {
      gos = new GZIPOutputStream(new FileOutputStream(gzippedFile));
      fis = new FileInputStream(srcFile);
      byte[] buffer = new byte[1024];
      int len = -1;
      while ((len = fis.read(buffer)) != -1) {
        gos.write(buffer, 0, len);
      }
    } finally {
      close(fis);
      close(gos);
    }
  }

  /**
   * UnGzip an gzipped input stream to an output stream. You need to close streams manually.
   *
   * @param gzippedInputStream
   * @param ungzippedOutputStream
   * @throws IOException
   */
  public static void unGzip(GZIPInputStream gzippedInputStream, OutputStream ungzippedOutputStream)
      throws IOException {
    byte[] buffer = new byte[1024];
    int len = -1;
    while ((len = gzippedInputStream.read(buffer)) != -1) {
      ungzippedOutputStream.write(buffer, 0, len);
    }
  }

  /**
   * ungzip a gzipped file to a normal file
   *
   * @param gzippedFile
   * @param ungzippedFile
   * @throws IOException
   */
  public static void unzip(File gzippedFile, File ungzippedFile) throws IOException {
    GZIPInputStream gis = null;
    FileOutputStream fos = null;
    try {
      gis = new GZIPInputStream(new FileInputStream(gzippedFile));
      fos = new FileOutputStream(ungzippedFile);
      byte[] buffer = new byte[1024];
      int len = -1;
      while ((len = gis.read(buffer)) != -1) {
        fos.write(buffer, 0, len);
      }
    } finally {
      close(gis);
      close(fos);
    }
  }

  /*
   * 内部方法, 关流用
   */
  private static void close(Closeable io) {
    if (io != null) {
      try {
        io.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      io = null;
    }
  }
}
