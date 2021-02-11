/**  
* @Title: Lambda.java
* @Package luozix.start.java8.action.beans.appd
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:29:07
* @version V1.0  
*/
package luozix.start.java8.action.beans.appd;
/**
* @ClassName: Lambda
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:29:07
*
*/
import java.util.function.Function;

public class Lambda {
	Function<Object, String> f = obj -> obj.toString();
}
