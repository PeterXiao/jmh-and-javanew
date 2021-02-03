/**
 * 
 */
package luozix.start.exams.connect;

import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoy
 *
 */
public class ConnectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		 
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("Local HostAddress: " + addr.getHostAddress());
		String hostname = addr.getHostName();
		System.out.println("Local host name: " + hostname);

		int size;
		URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
		URLConnection conn = url.openConnection();
		size = conn.getContentLength();
		if (size < 0)
			System.out.println("无法获取文件大小。");
		else
			System.out.println("文件大小为：" + size + " bytes");
		conn.getInputStream().close();

		URL u = new URL("http://127.0.0.1/test/test.html");
		URLConnection uc = u.openConnection();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		uc.setUseCaches(false);
		long timestamp = uc.getLastModified();
		System.out.println("test.html 文件最后修改时间 :" + ft.format(new Date(timestamp)));
	}

}
