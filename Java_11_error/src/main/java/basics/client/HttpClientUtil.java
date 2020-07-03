package basics.client;

import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * http 连接工具类
 *
 * @ClassName: HttpClientUtil
 * @date 2017年9月16日 上午11:46:45
 */
public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static PoolingHttpClientConnectionManager connectionManager;
    private static final Timer connectionManagerTimer = new Timer("SimpleRouteFilter.connectionManagerTimer", true);
    /**
     * 使用工厂方法初始化一个ScheduledThreadPool
     */
    // ScheduledExecutorService newScheduledThreadPool =
    // Executors.newScheduledThreadPool(2);
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
    int size = 2;// services.size();
    ExecutorService newScheduledThreadPool = new ThreadPoolExecutor(size, size, 0L, TimeUnit.MILLISECONDS,
	    new LinkedBlockingQueue<Runnable>(), namedThreadFactory);

    static {
	connectionManager = newConnectionManager();
	connectionManagerTimer.schedule(new TimerTask() {
	    @Override
	    public void run() {
		if (connectionManager == null) {
		    return;
		}
		connectionManager.closeExpiredConnections(); // 释放掉过期的链接
	    }
	}, 30000, 5000);
    }

    /**
     * 创建连接池
     *
     * @CreateTime: 2017年9月16日 下午12:01:54
     * @UpdateTime: 2017年9月16日 下午12:01:54
     * @return
     */
    private static PoolingHttpClientConnectionManager newConnectionManager() {
	try {
	    final SSLContext sslContext = SSLContext.getInstance("SSL");
	    sslContext.init(null, new TrustManager[] { new X509TrustManager() {
		@Override
		public void checkClientTrusted(final X509Certificate[] x509Certificates, final String s)
			throws CertificateException {
		}

		@Override
		public void checkServerTrusted(final X509Certificate[] x509Certificates, final String s)
			throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
		    return null;
		}
	    } }, new SecureRandom());

	    final RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder
		    .<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.INSTANCE)
		    .register("https", new SSLConnectionSocketFactory(sslContext));
	    final Registry<ConnectionSocketFactory> registry = registryBuilder.build();
	    connectionManager = new PoolingHttpClientConnectionManager(registry);
	    /**
	     * maxTotal 与 MaxPerRoute 解释：
	     * 路由的默认最大连接（该值默认为2）限制数量实际使用DefaultMaxPerRoute并非MaxTotal
	     * 设置过小无法支持大并发（ConnectionPoolTimeoutException: Timeout waiting for connection
	     * from pool） 路由是对maxTotal的细分例如：MaxtTotal=400 DefaultMaxPerRoute=200
	     * 而我只连接到http://sishuok.com时，到这个主机的并发最多只有200；而不是400； 而我连接到http://sishuok.com 和
	     * http://qq.com时，到每个主机的并发最多只有200；即加起来是400（但不能超过400）
	     */
	    connectionManager.setMaxTotal(400);// 设置整个连接池最大连接数
	    connectionManager.setDefaultMaxPerRoute(200);// 每个主机的并发最多只有200
	    // this.connectionManager.setValidateAfterInactivity(ms);
	    return connectionManager;
	} catch (final Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * 创建连接
     *
     * @CreateTime: 2017年9月16日 下午12:02:14
     * @UpdateTime: 2017年9月16日 下午12:02:14
     * @param timeOut
     * @return
     */
    private static CloseableHttpClient getHttpClient(final int timeOut) {
	final RequestConfig requestConfig = RequestConfig.custom()
		// .setSocketTimeout(PropertyPlaceholder.getInt("proxyClient.socket_timeout"))//请求获取数据的超时时间
		.setSocketTimeout(timeOut)// 请求获取数据的超时时间
		.setConnectTimeout(200000)// 设置连接超时时间，单位毫秒。
		.setConnectionRequestTimeout(3000000)// 设置从连接池获取连接超时时间、如果不设置，默认为connection_timeout因此一定要设置而且不能太大
		.setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
	final HttpClientBuilder httpClientBuilder = HttpClients.custom();
	return httpClientBuilder.setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig)
		.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))// 不进行重试
		.setRedirectStrategy(new RedirectStrategy() { // 重定向问题
		    @Override
		    public boolean isRedirected(final HttpRequest request, final HttpResponse response,
			    final HttpContext context) throws ProtocolException {
			return false;
		    }

		    @Override
		    public HttpUriRequest getRedirect(final HttpRequest request, final HttpResponse response,
			    final HttpContext context) throws ProtocolException {
			return null;
		    }
		}).build();
    }

    public static String httpRequest(String requestUrl, final Map<String, String> params, final String requestbody) {
	String result = "";
	CloseableHttpClient httpclient = null;
	try {
	    httpclient = getHttpClient(100000000);// 默认超时时间为30s
	    if (null != params && params.size() > 0) {
		requestUrl = requestUrl + "?";
		for (final String key : params.keySet()) {
		    requestUrl = requestUrl + key + "=" + params.get(key) + "&";
		}
	    }
	    logger.info("httpCinet 发送请求地址：{}", requestUrl);
	    final HttpPost httpPost = new HttpPost(requestUrl);
	    // 设置请求的body
	    if (StringUtils.isNotBlank(requestbody)) {
		httpPost.setEntity(new StringEntity(requestbody, "UTF-8"));
	    }
	    final long startTime = System.currentTimeMillis();
	    final CloseableHttpResponse response = httpclient.execute(httpPost);
	    // httpPost.releaseConnection();
	    logger.info("httpCinet 发送请求地址：{},共花费了：{} ms", requestUrl, System.currentTimeMillis() - startTime);
	    try {
		final InputStream in = response.getEntity().getContent();
		result = IOUtils.toString(in);
		// httpPost.releaseConnection();
		in.close();// bufferedReader.close();作用就是将用完的连接释放，下次请求可以复用
	    } finally {
		// 这里特别注意的是，如果不使用in.close();而仅仅使用response.close();结果就是连接会被关闭，并且不能被复用，这样就失去了采用连接池的意义
		response.close();
	    }
	} catch (final Exception e) {
	    logger.error(e.getMessage(), e);
	}
	return result;
    }
}
