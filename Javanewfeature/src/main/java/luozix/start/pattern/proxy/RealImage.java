/**  
* @Title: RealImage.java
* @Package luozix.start.pattern.proxy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:32:31
* @version V1.0  
*/
package luozix.start.pattern.proxy;
/**
* @ClassName: RealImage
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:32:31
*
*/

public class RealImage implements Image {

	protected String fileNameWithPath;

	public RealImage(String fileNameWithPath) {
		this.fileNameWithPath = fileNameWithPath;
		load();
	}

	@Override
	public void load() {
		System.out.println("RealImage: Loading image: " + fileNameWithPath);
	}

	@Override
	public void show() {
		System.out.println("RealImage: Showing image: " + fileNameWithPath);
	}

	@Override
	public void showSummary() {
		System.out.println("RealImage: Showing Summary of image: " + fileNameWithPath);
	}

	@Override
	public void resize() {
		System.out.println("RealImage: Resizing image: " + fileNameWithPath);
	}

	@Override
	public void remove() {
		System.out.println("RealImage: Removing image: " + fileNameWithPath);
	}

	@Override
	public void close() {
		System.out.println("RealImage: Closing image: " + fileNameWithPath);
	}

	public String getFileNameWithPath() {
		return fileNameWithPath;
	}

	public void setFileNameWithPath(String fileNameWithPath) {
		this.fileNameWithPath = fileNameWithPath;
	}

}