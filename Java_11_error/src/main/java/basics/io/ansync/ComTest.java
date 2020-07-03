/**
 *
 */
package basics.io.ansync;

import static org.asynchttpclient.Dsl.asyncHttpClient;

import java.io.IOException;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @author Office
 *
 */
public class ComTest {
    @Test
    public static void name() throws IOException {
	try (AsyncHttpClient asyncHttpClient = asyncHttpClient()) {
	    asyncHttpClient.prepareGet("http://www.349m.com/play/d2cf844973/1/1.html").execute().toCompletableFuture() // http://www.example.com/
		    .thenApply(Response::getResponseBody).thenAccept(System.out::println).join();
	}
    }
}
