/**
 * Project Name:java11_in_action File Name:HttpServerAPI.java Package
 * Name:luozix.start.javabefore7.j6 Date:2021年3月3日上午10:40:16 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: HttpServerAPI.java @Package luozix.start.javabefore7.j6 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:40:16
 * @version V1.0
 */
package luozix.start.javabefore7.j6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * ClassName:HttpServerAPI <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:40:16 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
/**
 * @ClassName: HttpServerAPI @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:40:16
 * @version
 * @since JDK 1.8
 */
public class HttpServerAPI {
  private static int count = 0;

  static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
      System.out.println("Request " + count++);
      System.out.println(he.getHttpContext().getPath());

      InputStream is = he.getRequestBody();
      String response = "<font color='red'>Lets Learn Java8.</font>";
      he.sendResponseHeaders(200, response.length());
      OutputStream os = he.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }
  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午10:40:16.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      HttpServer hs = HttpServer.create(new InetSocketAddress(8080), 0);
      hs.createContext("/", new MyHandler());
      hs.createContext("/java", new MyHandler());
      hs.setExecutor(null);
      hs.start();
      System.out.println("---begin---");
      System.out.println("Listening on " + hs.getAddress());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
