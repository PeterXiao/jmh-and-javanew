/**  
* @Title: FileInvoker.java
* @Package luozix.start.pattern.lambdascommand
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:06:22
* @version V1.0  
*/
package luozix.start.pattern.lambdascommand;
/**
* @ClassName: FileInvoker
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:06:22
*
*/
public class FileInvoker {

	private final Command command;

	public FileInvoker(Command c) {
		this.command = c;

	}

	public String excute() {
		return this.command.execute();
	}
}
