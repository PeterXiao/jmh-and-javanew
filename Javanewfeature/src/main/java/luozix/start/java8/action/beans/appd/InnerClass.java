/**  
* @Title: InnerClass.java
* @Package luozix.start.java8.action.beans.appd
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:28:45
* @version V1.0  
*/
package luozix.start.java8.action.beans.appd;
/**
* @ClassName: InnerClass
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:28:45
*
*/
import java.util.function.Function;

public class InnerClass {
	Function<Object, String> f = new Function<Object, String>() {
		@Override
		public String apply(Object obj) {
			return obj.toString();
		}
	};
}
