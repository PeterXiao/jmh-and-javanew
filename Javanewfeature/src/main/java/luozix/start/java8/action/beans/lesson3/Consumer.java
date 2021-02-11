/**  
* @Title: Consumer.java
* @Package luozix.start.java8.action.beans.lesson3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午7:09:46
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson3;
/**
* @ClassName: Consumer
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午7:09:46
*
*/
@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}
