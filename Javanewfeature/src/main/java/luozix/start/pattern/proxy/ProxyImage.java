/**  
* @Title: ProxyImage.java
* @Package luozix.start.pattern.proxy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:33:53
* @version V1.0  
*/
package luozix.start.pattern.proxy;
/**
* @ClassName: ProxyImage
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:33:53
*
*/

public class ProxyImage implements Image {

	protected String remoteHost;
	protected String fileNameWithPath;
	private Image image;
	protected boolean isAdmin;

	public ProxyImage(String fileNameWithPath, boolean isAdmin) {
		super();
		this.fileNameWithPath = fileNameWithPath;
		this.isAdmin = isAdmin;
	}

	public ProxyImage(String remoteHost, String fileNameWithPath, boolean isAdmin) {
		this(fileNameWithPath, isAdmin);
		this.remoteHost = remoteHost;
	}

	@Override
	public void load() {
		if (image == null) {
			if (remoteHost != null) {
				image = new RemoteImage(remoteHost, fileNameWithPath);
			} else {
				image = new RealImage(fileNameWithPath);
			}
		} else {
			System.err.printf("ImageProxy: Already loaded image: '%s'.\n", fileNameWithPath);
		}
	}

	@Override
	public void show() {
		load();
		image.show();
	}

	@Override
	public void showSummary() {
		System.err.printf("ImageProxy: Showing Summary of image: '%s'.\n", fileNameWithPath);
	}

	@Override
	public void resize() {
		if (isAdmin) {
			load();
			image.resize();
		} else {
			System.err.printf("ImageProxy: Only Admin can resize image: '%s'.\n", fileNameWithPath);
		}
	}

	@Override
	public void remove() {
		if (isAdmin) {
			load();
			image.resize();
		} else {
			System.err.printf("ImageProxy: Only Admin can remove image: '%s'.\n", fileNameWithPath);
		}
	}

	@Override
	public void close() {
		if (image != null) {
			image.close();
		} else {
			System.err.printf("ImageProxy: Already closed image: " + fileNameWithPath);
		}
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getFileNameWithPath() {
		return fileNameWithPath;
	}

	public void setFileNameWithPath(String fileNameWithPath) {
		this.fileNameWithPath = fileNameWithPath;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
