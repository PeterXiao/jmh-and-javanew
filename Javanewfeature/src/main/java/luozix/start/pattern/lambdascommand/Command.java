/**  
* @Title: command.java
* @Package luozix.start.pattern.lambdascommand
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:05:33
* @version V1.0  
*/
package luozix.start.pattern.lambdascommand;
/**
* @ClassName: command
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:05:33
*
*/
@FunctionalInterface
public interface Command {
	String execute();
}
