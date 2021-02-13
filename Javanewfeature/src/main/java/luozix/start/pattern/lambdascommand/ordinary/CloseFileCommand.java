/**  
* @Title: CloseFileCommand.java
* @Package luozix.start.pattern.lambdascommand.ordinary
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:18:43
* @version V1.0  
*/
package luozix.start.pattern.lambdascommand.ordinary;

import luozix.start.pattern.lambdascommand.system.FileSystemReceiver;

/**
* @ClassName: CloseFileCommand
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:18:43
*
*/
public class CloseFileCommand extends FileCommand {

	/**
	 * @param fs
	* <p>Title: </p>
	* <p>Description: </p>
	* @param fs
	 */
	public CloseFileCommand(FileSystemReceiver fs) {
		super(fs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() {
		return this.fileSystemReceiver.close();
	}
}
