/**
 *
 */
package basics.limits;

import static org.mockito.Mockito.mock;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.vavr.control.Try;

/**
 * @author Office
 *
 */
public class TestLimit {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub


    }

    public boolean state = false;
    HelloWorldService helloWorldService;

    AsyncHelloWorldService asyncHelloWorldService;
    @BeforeClass
    public void setUp() {

	helloWorldService = mock(HelloWorldService.class);
	asyncHelloWorldService = mock(AsyncHelloWorldService.class);
    }

    @Test
    public void testRateLimiter() {
	// Create a custom RateLimiter configuration
	RateLimiterConfig config = RateLimiterConfig.custom().timeoutDuration(Duration.ofMillis(100))
		.limitRefreshPeriod(Duration.ofSeconds(1)).limitForPeriod(1).build();
	// Create a RateLimiter
	RateLimiter rateLimiter = RateLimiter.of("backendName", config);

	// BackendService backendService = new BackendService();
	// Decorate your call to BackendService.doSomething()
	Supplier<String> restrictedSupplier = RateLimiter.decorateSupplier(rateLimiter,
		helloWorldService::returnHelloWorld);

	IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
	    Try<String> aTry = Try.ofSupplier(restrictedSupplier);
	    System.out.println(aTry.isSuccess());
	});
    }

    @Test
    public void testasyncRateLimiter() {
	// Create a custom RateLimiter configuration
	RateLimiterConfig config = RateLimiterConfig.custom().timeoutDuration(Duration.ofMillis(100))
		.limitRefreshPeriod(Duration.ofSeconds(1)).limitForPeriod(1).build();
	// Create a RateLimiter
	RateLimiter rateLimiter = RateLimiter.of("backendName", config);

	// BackendService backendService = new BackendService();
	// Decorate your call to BackendService.doSomething()
	Supplier<CompletionStage<String>> restrictedSupplier = RateLimiter.decorateSupplier(rateLimiter,
		asyncHelloWorldService::returnHelloWorld);

	IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
	    Try<CompletionStage<String>> aTry = Try.ofSupplier(restrictedSupplier);
	    System.out.println(aTry.isSuccess());
	});
    }
    /*
     * class BackendService { public String doSomething() {
     * System.out.println("fuck world");
     *
     * return "do"; } }
     */
    /*
     * @Test public void testTimelimiter(){ ExecutorService executorService =
     * Executors.newSingleThreadExecutor(); TimeLimiterConfig config =
     * TimeLimiterConfig.custom() .timeoutDuration(Duration.ofMillis(600))
     * .cancelRunningFuture(true) .build(); TimeLimiter timeLimiter =
     * TimeLimiter.of(config);
     *
     * Supplier<Future<String>> futureSupplier = () -> { return
     * executorService.submit(backendService::doSomethingThrowException); };
     * Callable<String> restrictedCall =
     * TimeLimiter.decorateFutureSupplier(timeLimiter,futureSupplier);
     * Try.of(restrictedCall::call) .onFailure(throwable -> System.out.
     * println("We might have timed out or the circuit breaker has opened.")); }
     */
}
