/**  
* @Title: FileCommand.java
* @Package luozix.start.pattern.lambdascommand.ordinary
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:16:52
* @version V1.0  
*/
package luozix.start.pattern.lambdascommand.ordinary;

import luozix.start.pattern.lambdascommand.Command;
import luozix.start.pattern.lambdascommand.system.FileSystemReceiver;

/**
* @ClassName: FileCommand
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:16:52
*
*/
public abstract class FileCommand implements Command {

	protected final FileSystemReceiver fileSystemReceiver;
	/**
	 * 
	* <p>Title: </p>
	* <p>Description: </p>
	 */
	public FileCommand(FileSystemReceiver fs) {
		// TODO Auto-generated constructor stub
		this.fileSystemReceiver = fs;
	}

}
