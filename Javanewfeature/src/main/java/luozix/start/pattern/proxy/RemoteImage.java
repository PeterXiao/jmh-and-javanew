/**  
* @Title: RemoteImage.java
* @Package luozix.start.pattern.proxy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:33:21
* @version V1.0  
*/
package luozix.start.pattern.proxy;
/**
* @ClassName: RemoteImage
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:33:21
*
*/

public class RemoteImage implements Image {

	private String remoteHost;
	protected String fileNameWithPath;

	public RemoteImage(String remoteHost, String fileNameWithPath) {
		this.remoteHost = remoteHost;
		this.fileNameWithPath = fileNameWithPath;
		load();
	}

	@Override
	public void load() {
		System.out.printf("RemoteImage: Loading image: 'smb:\\\\%s\\%s'.\n", remoteHost, fileNameWithPath);
	}

	@Override
	public void show() {
		System.out.printf("RemoteImage: Showing image: 'smb:\\\\%s\\%s'.\n", remoteHost, fileNameWithPath);
	}

	@Override
	public void showSummary() {
		System.out.printf("RemoteImage: Showing Summary of image: 'smb:\\\\%s\\%s'.\n", remoteHost, fileNameWithPath);
	}

	@Override
	public void resize() {
		System.out.printf("RemoteImage: Resizing image: 'smb:\\\\%s\\%s'.\n", remoteHost, fileNameWithPath);
	}

	@Override
	public void remove() {
		System.out.printf("RemoteImage: Removing image: 'smb:\\\\%s\\%s'.\n", remoteHost, fileNameWithPath);
	}

	@Override
	public void close() {
		System.out.printf("RemoteImage: Closing image: 'smb:\\\\%s\\%s'.\n", remoteHost, fileNameWithPath);
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

}
