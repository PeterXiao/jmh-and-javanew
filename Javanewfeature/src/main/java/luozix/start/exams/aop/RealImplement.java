/**  
* @Title: RealImplement.java
* @Package luozix.start.exams.aop
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:02:10
* @version V1.0  
*/
package luozix.start.exams.aop;
/**
* @ClassName: RealImplement
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:02:10
*
*/
public class RealImplement implements InterfaceA {

	@Override
	public void exec() {
		System.out.println("real impl");
	}
}
