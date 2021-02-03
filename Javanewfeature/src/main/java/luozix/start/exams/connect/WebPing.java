/**
 * 
 */
package luozix.start.exams.connect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaoy
 *
 */
public class WebPing {
	public static void main(String[] args) throws Exception {
		try {
			InetAddress addr;
			Socket sock = new Socket("www.runoob.com", 80);
			addr = sock.getInetAddress();
			System.out.println("连接到 " + addr);
			sock.close();
		} catch (java.io.IOException e) {
			System.out.println("无法连接 " + args[0]);
			System.out.println(e);
		}

		URL url = new URL("http://www.runoob.com");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			writer.write(line);
			writer.newLine();
		}
		reader.close();
		writer.close();

		// URL url = new URL("http://www.runoob.com");
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		long date = httpCon.getDate();
		if (date == 0)
			System.out.println("无法获取信息。");
		else
			System.out.println("Date: " + new Date(date));

		URLConnection conn = url.openConnection();

		Map headers = conn.getHeaderFields();
		Set<String> keys = headers.keySet();
		for (String key : keys) {
			String val = conn.getHeaderField(key);
			System.out.println(key + "    " + val);
		}
		System.out.println(conn.getLastModified());

		URL url1 = new URL("http://www.runoob.com/html/html-tutorial.html");
		System.out.println("URL 是 " + url1.toString());
		System.out.println("协议是 " + url1.getProtocol());
		System.out.println("文件名是 " + url1.getFile());
		System.out.println("主机是 " + url1.getHost());
		System.out.println("路径是 " + url1.getPath());
		System.out.println("端口号是 " + url1.getPort());
		System.out.println("默认端口号是 " + url1.getDefaultPort());
	}
}
