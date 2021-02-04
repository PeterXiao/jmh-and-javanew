/**  
* @Title: ProxyImplement.java
* @Package luozix.start.exams.aop
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:03:39
* @version V1.0  
*/
package luozix.start.exams.aop;
/**
* @ClassName: ProxyImplement
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:03:39
*
*/
public class ProxyImplement implements InterfaceA {
	private InterfaceA interfaces;
    
    public ProxyImplement(){
		interfaces = new RealImplement();
    }

	@Override
	public void exec(){
		System.out.println("dosomethings before");
        //实际调用
		interfaces.exec();
        
        System.out.println("dosomethings after");    
        }

}
