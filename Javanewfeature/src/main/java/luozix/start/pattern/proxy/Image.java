/**  
* @Title: Image.java
* @Package luozix.start.pattern.proxy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:31:24
* @version V1.0  
*/
package luozix.start.pattern.proxy;
/**
* @ClassName: Image
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:31:24
*
*/
public interface Image {

	public void load();

	public void show();

	public void showSummary();

	public void resize();

	public void remove();

	public void close();
}