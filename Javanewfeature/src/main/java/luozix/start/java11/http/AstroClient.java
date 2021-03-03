/**
 * Project Name:java11_in_action File Name:AstroClient.java Package Name:luozix.start.java11.http
 * Date:2021年3月3日上午9:48:30 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: AstroClient.java @Package luozix.start.java11.http @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:48:30
 * @version V1.0
 */
package luozix.start.java11.http;
/**
 * ClassName:AstroClient <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午9:48:30 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName: AstroClient @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午9:48:30
 * @version
 * @since JDK 1.8
 */
import com.google.gson.Gson;

import luozix.start.java11.http.json.AstroResponse;

public class AstroClient {
  private HttpClient client =
      HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_2)
          .connectTimeout(Duration.ofSeconds(2))
          .build();

  private Gson gson = new Gson();

  private HttpRequest buildRequest() {
    String astroUrl = "http://api.open-notify.org/astros.json";
    return HttpRequest.newBuilder().uri(URI.create(astroUrl)).GET().build();
  }

  public AstroResponse getSync() throws IOException, InterruptedException {
    HttpResponse<String> response =
        client.send(buildRequest(), HttpResponse.BodyHandlers.ofString());
    return getResponse(response.body());
  }

  public AstroResponse getAsync() throws ExecutionException, InterruptedException {
    String json =
        client
            .sendAsync(buildRequest(), HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .get();
    return getResponse(json);
  }

  private AstroResponse getResponse(String json) {
    return gson.fromJson(json, AstroResponse.class);
  }
}
