/**
 *
 */
package basics.limits;

/**
 * @author Office
 *
 */

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by 58 on 2017/5/22.
 *
 */
public class TrafficShaper {

    private static final ConcurrentMap<String, RateLimiter> resourceLimiterMap = Maps.newConcurrentMap();

    public static void updateResourceQps(String resource, double qps) {

	RateLimiter limiter = resourceLimiterMap.get(resource);
	if (limiter == null) {
	    limiter = RateLimiter.create(qps);
	    RateLimiter putByOtherThread = resourceLimiterMap.putIfAbsent(resource, limiter);
	    if (putByOtherThread != null) {
		limiter = putByOtherThread;
	    }
	}
	limiter.setRate(qps);
    }

    public static void enter(String resource) throws RateLimitException {
	RateLimiter limiter = resourceLimiterMap.get(resource);
	// 为空 不限流
	if (limiter == null) {
	    return;
	}

	if (!limiter.tryAcquire()) {
	    // 限流
	    throw new RateLimitException(resource);
	} else {
	    // 正常流速，业务处理
	    System.out.println("hello");
	}
    }

    public static class RateLimitException extends Exception {

	private static final long serialVersionUID = 1L;

	private String resource;

	public String getResource() {
	    return resource;
	}

	public RateLimitException(String resource) {
	    super(resource + " should not be visited so frequently");
	    this.resource = resource;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
	    return this;
	}
    }

    public static void main(String[] args) {

	TrafficShaper.updateResourceQps("testKey", 95);
	while (true) {
	    try {
		TrafficShaper.enter("testKey");
		Thread.sleep(10);
	    } catch (RateLimitException e) {
		e.printStackTrace();
	    } catch (Exception e1) {

	    }
	}

    }

}