/**  
* @Title: Authers.java
* @Package luozix.start.java8.action.beans.appa
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午1:23:42
* @version V1.0  
*/
package luozix.start.java8.action.beans.appa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* @ClassName: Authers
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午1:23:42
*
*/
@Retention(RetentionPolicy.RUNTIME)
public @interface Authers {

	Auther[] value();
}
