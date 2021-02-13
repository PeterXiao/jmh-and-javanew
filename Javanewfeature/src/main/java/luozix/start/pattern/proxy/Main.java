/**  
* @Title: Main.java
* @Package luozix.start.pattern.proxy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:34:38
* @version V1.0  
*/
package luozix.start.pattern.proxy;
/**
* @ClassName: Main
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:34:38
*
*/
public class Main {

	/**
	 * 
	* <p>Title: </p>
	* <p>Description: </p>
	 */

	public static void main(String[] args) {
		System.out.println("Using Real Image class...");
		Image image1 = new RealImage("ABC.jpg");
		image1.showSummary();
		image1.load();
		image1.show();
		image1.resize();
		image1.close();
		image1.remove();
		System.out.println("------------------------------------------------");
		System.out.println("Using Proxy Image class...");
		Image image2 = new ProxyImage("ABC.jpg", true);
		image2.showSummary();
		image2.load();
		image2.show();
		image2.resize();
		image2.close();
		image2.remove();
		System.out.println("------------------------------------------------");
		System.out.println("Using Remote Image class...");
		Image image3 = new RemoteImage("192.168.0.1", "ABC.jpg");
		image3.showSummary();
		image3.load();
		image3.show();
		image3.resize();
		image3.close();
		image3.remove();
		System.out.println("------------------------------------------------");
		System.out.println("Using Proxy Image class...");
		Image image4 = new ProxyImage("192.168.0.1", "ABC.jpg", false);
		image4.showSummary();
		image4.load();
		image4.show();
		image4.resize();
		image4.close();
		image4.remove();
		System.out.println("------------------------------------------------");
	}
}
