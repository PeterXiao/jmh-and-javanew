/**  
* @Title: OpenFileCommand.java
* @Package luozix.start.pattern.lambdascommand.ordinary
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:20:32
* @version V1.0  
*/
package luozix.start.pattern.lambdascommand.ordinary;

import luozix.start.pattern.lambdascommand.system.FileSystemReceiver;

/**
* @ClassName: OpenFileCommand
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:20:32
*
*/
public class OpenFileCommand extends FileCommand {

	/**
	 * @param fs
	* <p>Title: </p>
	* <p>Description: </p>
	* @param fs
	 */
	public OpenFileCommand(FileSystemReceiver fs) {
		super(fs);
		// TODO Auto-generated constructor stub
	}

	/* (非 Javadoc)
	* <p>Title: execute</p>
	* <p>Description: </p>
	* @return
	* @see luozix.start.pattern.lambdascommand.Command#execute()
	*/
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return this.fileSystemReceiver.open();
	}

}
