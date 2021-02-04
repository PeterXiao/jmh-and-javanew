/**  
* @Title: Singleton.java
* @Package luozix.start.exams.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:29:50
* @version V1.0  
*/
package luozix.start.exams.concurrent;
/**
* @ClassName: Singleton
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:29:50
*
*/
public class Singleton {
	private static volatile Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

}
//控制停止线程的标记

//private volatile boolean flag ;
//private void run(){
//    new Thread(new Runnable() {
//        @Override
//        public void run() {
//            while (flag) {
//                doSomeThing();
//            }
//        }
//    });
//}
//
//private void stop(){
//    flag = false ;
//}