/**  
* @Title: Single.java
* @Package luozix.start.exams.concurrent.singleton
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午10:54:24
* @version V1.0  
*/
package luozix.start.exams.concurrent.singleton;
/**
* @ClassName: Single
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午10:54:24
*
*/
/**
 * 懒汉式
 */
public class Single {
	private volatile static Single single;

	// 私有化构造函数
	private Single() {
	}

	public static Single getSingle() {
		if (single == null) {
			synchronized (Singleton.class) {
				if (single == null) {
					single = new Single();
				}
			}
		}
		return single;
	}
}
// 第一种使用volatile的方案实现线程安全

//public class Singleton {
//    private static class SingletonHolder{
//        public static Singleton singleton = new Singleton();
//    }
//    
//    public static Singleton getInstance(){
//        return SingletonHolder.singleton;
//    }
//}