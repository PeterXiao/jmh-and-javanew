/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:httpclientdemo.java Package Name:spiservice
 * Date:2021年6月13日上午11:55:49 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: httpclientdemo.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年6月13日 上午11:55:49
 * @version V1.0
 */
package spiservice;
	/**
  * ClassName:httpclientdemo <br>
  * Function: TODO ADD FUNCTION. <br>
  * Reason: TODO ADD REASON. <br>
  * Date: 2021年6月13日 上午11:55:49 <br>
  *
  * @author xiaoy
  * @version
  * @since JDK 1.8
  * @see
  */

/**
 * @ClassName: httpclientdemo @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年6月13日 上午11:55:49
 * @version
 * @since JDK 1.8
 */
//	import java.net.URI;
//	import java.net.http.HttpClient;
//	import java.net.http.HttpRequest;
//	import java.net.http.HttpResponse;
//	import java.security.NoSuchAlgorithmException;
//	import java.security.SecureRandom;
//	import java.security.cert.CertificateException;
//	import java.security.cert.X509Certificate;
//	import java.time.Duration;
//	import javax.net.ssl.HostnameVerifier;
//	import javax.net.ssl.SSLContext;
//	import javax.net.ssl.SSLParameters;
//	import javax.net.ssl.SSLSession;
//	import javax.net.ssl.TrustManager;
//	import javax.net.ssl.X509TrustManager;
//	public class httpclientdemo {
//	    public static void main(String[] args) throws NoSuchAlgorithmException, Exception,
// InterruptedException {
//	        TrustManager[] trustAllCertificates = new TrustManager[] { new X509TrustManager() {
//	            @Override
//	            public X509Certificate[] getAcceptedIssuers() {
//	                return null; // Not relevant.
//	            }
//	            @Override
//	            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws
// CertificateException {
//	                // TODO Auto-generated method stub
//	            }
//	            @Override
//	            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws
// CertificateException {
//	                // TODO Auto-generated method stub
//	            }
//	        } };
//	        //HostnameVerifier trustAllHostnames = new HostnameVerifier() {
//	        //  @Override
//	        //  public boolean verify(String hostname, SSLSession session) {
//	        //      return true; // Just allow them all.
//	        //  }
//	        };
//	        var timeoutInSeconds = 60;
//	        SSLParameters sslParams = new SSLParameters();
//	        sslParams.setEndpointIdentificationAlgorithm("");
//	        SSLContext sc = SSLContext.getInstance("SSL");
//
// System.setProperty("jdk.internal.httpclient.disableHostnameVerification","true");//取消主机名验证
//	        sc.init(null, trustAllCertificates, new SecureRandom());
//	        HttpClient httpClient =
// HttpClient.newBuilder().connectTimeout(Duration.ofMillis(timeoutInSeconds * 1000))
//	                .sslContext(sc)
//	                .sslParameters(sslParams)
//	                .build();
//	        HttpRequest requestBuilder =
// HttpRequest.newBuilder().uri(URI.create("https://www.example.com/getSomething"))
//	                .GET().build();
//	        HttpResponse<String> result = httpClient.send(requestBuilder,
// HttpResponse.BodyHandlers.ofString()); //发送请求
//	    }
