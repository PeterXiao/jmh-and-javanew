/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:JEP321Http2Client.java Package Name:jvm
 * Date:2021年6月14日上午11:17:28 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: JEP321Http2Client.java @Package jvm @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年6月14日 上午11:17:28
 * @version V1.0
 */
package jvm;
/**
 * ClassName:JEP321Http2Client <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年6月14日 上午11:17:28 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: JEP321Http2Client @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年6月14日 上午11:17:28
 * @version
 * @since JDK 1.8
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JEP321Http2Client {

  static ExecutorService executor =
      Executors.newFixedThreadPool(
          6,
          (Runnable r) -> {
            return new Thread(r);
          });

  public static void main(String[] args) throws Exception {
    System.out.println("Running HTTP/2 example...");
    try {
      HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();

      long start = System.currentTimeMillis();

      HttpRequest pageRequest =
          HttpRequest.newBuilder().uri(URI.create("https://http2.golang.org/gophertiles")).build();

      HttpResponse<String> pageResponse = httpClient.send(pageRequest, BodyHandlers.ofString());

      System.out.println("Page response status code: " + pageResponse.statusCode());
      System.out.println("Page response headers: " + pageResponse.headers());
      String responseBody = pageResponse.body();
      System.out.println(responseBody);

      List<Future<?>> futures = new ArrayList<>();
      AtomicInteger atomicInt = new AtomicInteger(1);

      Document doc = Jsoup.parse(responseBody);
      Elements imgs = doc.select("img[width=32]"); // img with width=32

      // Send request on a separate thread for each image in the page,
      imgs.forEach(
          img -> {
            var image = img.attr("src");
            Future<?> imgFuture =
                executor.submit(
                    () -> {
                      HttpRequest imgRequest =
                          HttpRequest.newBuilder()
                              .uri(URI.create("https://http2.golang.org" + image))
                              .build();
                      try {
                        HttpResponse<String> imageResponse =
                            httpClient.send(imgRequest, BodyHandlers.ofString());
                        System.out.println(
                            "["
                                + atomicInt.getAndIncrement()
                                + "] Loaded "
                                + image
                                + ", status code: "
                                + imageResponse.statusCode());
                      } catch (IOException | InterruptedException ex) {
                        System.out.println("Error loading image " + image + ": " + ex.getMessage());
                      }
                    });
            futures.add(imgFuture);
            System.out.println("Adding future for image " + image);
          });

      // Wait for image loads to be completed
      futures.forEach(
          f -> {
            try {
              f.get();
            } catch (InterruptedException | ExecutionException ex) {
              System.out.println("Exception during loading images: " + ex.getMessage());
            }
          });

      long end = System.currentTimeMillis();
      System.out.println("Total load time: " + (end - start) + " ms");
      System.out.println(atomicInt.get() - 1 + " images loaded");
    } finally {
      executor.shutdown();
    }
  }
}
