/**  
* @Title: Singleton.java
* @Package luozix.start.exams.concurrent.singleton
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午10:53:21
* @version V1.0  
*/
package luozix.start.exams.concurrent.singleton;
/**
* @ClassName: Singleton
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午10:53:21
*
*/
/**
 * 饿汉式 类被加载时初始化！线程安全
 * 
 * @author by Assume
 * @date 2018/11/16 16:29
 */
public class Singleton {
	private static Singleton single = new Singleton();

	// 私有化构造函数
	private Singleton() {
	}

	public static Singleton getSingle() {
		return single;
	}
}
// 相当于上面的第二种解决方案。
