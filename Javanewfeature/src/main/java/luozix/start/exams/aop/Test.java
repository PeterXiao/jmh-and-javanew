/**  
* @Title: Test.java
* @Package luozix.start.exams.aop
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:05:19
* @version V1.0  
*/
package luozix.start.exams.aop;
/**
* @ClassName: Test
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:05:19
*
*/
public class Test {

	/**
	 * @param args
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	 */
    public static void main(String[] args){
		InterfaceA interfaces = new ProxyImplement();
		interfaces.exec();
    }

}
