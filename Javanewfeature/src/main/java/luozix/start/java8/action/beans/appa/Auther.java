/**  
* @Title: Auther.java
* @Package luozix.start.java8.action.beans.appa
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午1:22:07
* @version V1.0  
*/
package luozix.start.java8.action.beans.appa;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* @ClassName: Auther
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午1:22:07
*
*/
@Repeatable(Authers.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auther {
	String name();
}
