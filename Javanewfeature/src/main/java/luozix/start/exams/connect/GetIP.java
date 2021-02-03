/**
 * 
 */
package luozix.start.exams.connect;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * @author xiaoy
 *
 */
public class GetIP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress address = null;
		try {
			address = InetAddress.getByName("www.runoob.com");
		} catch (UnknownHostException e) {
			System.exit(2);
		}
		System.out.println(address.getHostName() + "=" + address.getHostAddress());

		// 检测本地 80 端口
		log(isSocketAliveUitlitybyCrunchify("localhost", 80));

		// 检测本地 8080 端口
		log(isSocketAliveUitlitybyCrunchify("localhost", 8080));

		// 检测本地 8081 端口
		log(isSocketAliveUitlitybyCrunchify("localhost", 8081));

		// 检测 runoob.com 的 80 端口
		log(isSocketAliveUitlitybyCrunchify("runoob.com", 80));

		// 检测 runoob.com 的 443 端口
		log(isSocketAliveUitlitybyCrunchify("runoob.com", 443));

		// 检测 runoob.com 的 81 端口
		log(isSocketAliveUitlitybyCrunchify("runoob.com", 81));

		Socket Skt;
		String host = "localhost";
		if (args.length > 0) {
			host = args[0];
		}
		for (int i = 0; i < 1024; i++) {
			try {
				System.out.println("查看 " + i);
				Skt = new Socket(host, i);
				System.out.println("端口 " + i + " 已被使用");
			} catch (UnknownHostException e) {
				System.out.println("Exception occured" + e);
				break;
			} catch (IOException e) {
			}
		}

		System.exit(0);

	}
	/**
	 * 判断主机端口
	 * 
	 * @param hostName
	 * @param port
	 * @return boolean - true/false
	 */
	public static boolean isSocketAliveUitlitybyCrunchify(String hostName, int port) {
		boolean isAlive = false;

		// 创建一个套接字
		SocketAddress socketAddress = new InetSocketAddress(hostName, port);
		Socket socket = new Socket();

		// 超时设置，单位毫秒
		int timeout = 2000;

		log("hostName: " + hostName + ", port: " + port);
		try {
			socket.connect(socketAddress, timeout);
			socket.close();
			isAlive = true;

		} catch (SocketTimeoutException exception) {
			System.out.println("SocketTimeoutException " + hostName + ":" + port + ". " + exception.getMessage());
		} catch (IOException exception) {
			System.out.println(
					"IOException - Unable to connect to " + hostName + ":" + port + ". " + exception.getMessage());
		}
		return isAlive;
	}

	private static void log(String string) {
		System.out.println(string);
	}

	private static void log(boolean isAlive) {
		System.out.println("是否真正在使用: " + isAlive + "\n");
	}
}
