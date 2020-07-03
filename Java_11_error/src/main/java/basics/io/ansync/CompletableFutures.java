/**
 *
 */
package basics.io.ansync;

/**
 * @author Office
 *
 */
import org.testng.Assert;
import org.testng.annotations.Test;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.io.IOException;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class CompletableFutures {

    public static void main(String[] args) throws IOException {

	try (AsyncHttpClient asyncHttpClient = asyncHttpClient()) {
	    asyncHttpClient.prepareGet("http://www.349m.com/play/d2cf844973/1/1.html").execute().toCompletableFuture() // http://www.example.com/
		    .thenApply(Response::getResponseBody).thenAccept(System.out::println).join();
	}
    }

    @Test(threadPoolSize = 30, invocationCount = 600, timeOut = 3000)
    public void testMethod() throws IOException {
	Long id = Thread.currentThread().getId();
	System.out.println("Test method executing on thread with id: " + id);
	try (AsyncHttpClient asyncHttpClient = asyncHttpClient()) {
	    asyncHttpClient.prepareGet("http://www.349m.com/play/d2cf844973/1/1.html").execute().toCompletableFuture() // http://www.example.com/
		    .thenApply(Response::getResponseBody).thenAccept(System.out::println).join();
	}
    }
}