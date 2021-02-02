/**
 * 
 */
package luozix.start.java11;

/**
 * @author xiaoy
 *
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class GetRequestTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpRequest request = HttpBinRequestBuilder.createGetRequest();

		HttpClient httpClient = HttpClientBuilderTest.createHttpClient();
		// HttpClient#send is blocking; the body is kept in memory to be processed
		HttpResponse<String> httpResponse = httpClient.send(request, BodyHandlers.ofString());
		System.out.println("Response: " + httpResponse.body());

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request1 = HttpRequest.newBuilder().uri(URI.create("http://openjdk.java.net/")).build();
		client.sendAsync(request1, BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();
	}
}
