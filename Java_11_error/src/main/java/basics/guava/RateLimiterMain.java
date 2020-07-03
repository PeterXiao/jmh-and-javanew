/**
 *
 */
package basics.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author Office
 *
 */
public class RateLimiterMain {
    public static void main(String[] args) {
	RateLimiter rateLimiter = RateLimiter.create(10);
	for (int i = 0; i < 10; i++) {
	    new Thread(new Runnable() {
		@Override
		public void run() {
		    rateLimiter.acquire();
		    System.out.println("pass");
		}
	    }).start();
	}
    }
}

