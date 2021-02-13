/**  
* @Title: FileSystemReceiver.java
* @Package luozix.start.pattern.lambdascommand.system
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:10:12
* @version V1.0  
*/
package luozix.start.pattern.lambdascommand.system;
/**
* @ClassName: FileSystemReceiver
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:10:12
*
*/
public class FileSystemReceiver {
	private final SystemType type;

	/**
	 * 
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	FileSystemReceiver(SystemType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public String open() {
		return type + ", " + FileOperationType.OPEN;
	}

	public String write() {
		return type + ", " + FileOperationType.WRITE;
	}

	public String close() {
		return type + ", " + FileOperationType.CLOSE;
	}

	public String hold() {
		return type + ", " + FileOperationType.HOLD;
	}
}
