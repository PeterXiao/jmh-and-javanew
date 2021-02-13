/**  
* @Title: Dog.java
* @Package luozix.start.pattern.strategy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:42:23
* @version V1.0  
*/
package luozix.start.pattern.strategy;
/**
* @ClassName: Dog
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:42:23
*
*/
public class Dog implements Animal {

	/**
	 * 
	* <p>Title: </p>
	* <p>Description: </p>
	 */
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	/* (非 Javadoc)
	* <p>Title: say</p>
	* <p>Description: </p>
	* @see luozix.start.pattern.strategy.Animal#say()
	*/
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("Hello from Dog");
	}

}
