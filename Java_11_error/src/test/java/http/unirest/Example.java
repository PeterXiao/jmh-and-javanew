/**
 *
 */
package http.unirest;

import static java.util.stream.Collectors.toList;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;

/**
 * Java 11 的 Http Client 示例
 * <p>
 * 移除了 HttpResponse.BodyHandler.asString() 使用
 * HttpResponse.BodyHandlers.ofString() 代替功能
 *
 * @author LiY
 * @time 下午5:56:30
 */
public class Example {

	// 同步调用 GET
	public static void syncGet(String uri) throws Exception {
		final HttpClient client = HttpClient.newHttpClient();
		final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

		final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.statusCode());
		System.out.println(response.body());
	}

	// 异步调用 GET
	public static void asyncGet(String uri) throws Exception {
		final HttpClient client = HttpClient.newHttpClient();
		final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

		final CompletableFuture<HttpResponse<String>> responseCompletableFuture = client.sendAsync(request,
				HttpResponse.BodyHandlers.ofString());
		responseCompletableFuture.whenComplete((resp, t) -> {
			if (t != null) {
				t.printStackTrace();
			} else {
				System.out.println(resp.body());
				System.out.println(resp.statusCode());
			}
		}).join();
	}

	// 异步调用 POST
	public static void asyncPost() throws Exception {
		final HttpClient client = HttpClient.newHttpClient();

		final Gson gson = new Gson();
		final Foo foo = new Foo();
		foo.name = "com";
		foo.url = "https://github.com/com";

		final String jsonBody = gson.toJson(foo);

		final HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://httpbin.org/post"))
				.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).whenComplete((resp, t) -> {
			if (t != null) {
				t.printStackTrace();
			} else {
				System.out.println(resp.body());
				System.out.println(resp.statusCode());
			}
		}).join();
	}

	// 下载文件
	public static void downloadFile() throws Exception {
		final HttpClient client = HttpClient.newHttpClient();

		final HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://labs.consol.de/")).GET().build();

		final Path tempFile = Files.createTempFile("consol-labs-home", ".html");
		final HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(tempFile));
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}

	// 上传文件
	public static void uploadFile() throws Exception {
		final HttpClient client = HttpClient.newHttpClient();

		final HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:8080/upload/"))
				.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("/tmp/files-to-upload.txt"))).build();

		final HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
		System.out.println(response.statusCode());
	}

	// 设置代理
	public static void proxy() throws Exception {
		final HttpClient client = HttpClient.newBuilder()
				.proxy(ProxySelector.of(new InetSocketAddress("127.0.0.1", 1080))).build();

		final HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://www.google.com")).GET().build();

		final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}

	// basic 认证
	public static void basicAuth() throws Exception {
		final HttpClient client = HttpClient.newBuilder().authenticator(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("username", "password".toCharArray());
			}
		}).build();

		final HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://labs.consol.de")).GET().build();

		final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}

	// 访问 HTTP2 网址
	public static void http2() throws Exception {
		HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).version(HttpClient.Version.HTTP_2).build()
				.sendAsync(HttpRequest.newBuilder().uri(new URI("https://http2.akamai.com/demo")).GET().build(),
						HttpResponse.BodyHandlers.ofString())
				.whenComplete((resp, t) -> {
					if (t != null) {
						t.printStackTrace();
					} else {
						System.out.println(resp.body());
						System.out.println(resp.statusCode());
					}
				}).join();
	}

	// 并行请求
	public void getURIs(List<URI> uris) {
		final HttpClient client = HttpClient.newHttpClient();
		final List<HttpRequest> requests = uris.stream().map(HttpRequest::newBuilder).map(HttpRequest.Builder::build)
				.collect(toList());

		CompletableFuture
				.allOf(requests.stream().map(request -> client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
						.toArray(CompletableFuture<?>[]::new))
				.join();
	}

	public static void main(String[] args) throws Exception {
//        syncGet("https://biezhi.me");
//        asyncGet("https://biezhi.me");
		asyncPost();
//        http2();
	}

}