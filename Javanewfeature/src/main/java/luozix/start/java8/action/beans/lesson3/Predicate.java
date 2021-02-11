/**  
* @Title: Predicate.java
* @Package luozix.start.java8.action.beans.lesson3
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午6:47:33
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson3;

/**
 * @ClassName: Predicate
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @param <T>
 * @date 2021年2月11日 下午6:47:33
 *
 */
@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}
