/**  
* @Title: MeaningOfThis.java
* @Package luozix.start.java8.action.beans.lesson02
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:31:52
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson02;

/**
* @ClassName: MeaningOfThis
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午4:31:52
*
*/
public class MeaningOfThis {

	public final int value = 4;

	public void doIt() {
		int value = 6;
		Runnable runnable = new Runnable() {
			public final int value = 5;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 10;
				System.out.println(this.value);
			}
		};
		runnable.run();
	}

	public static void main(String[] args) {
		MeaningOfThis meaningOfThis = new MeaningOfThis();
		meaningOfThis.doIt();
		Thread thread = new Thread(() -> System.out.print("Hello world "));
	}
}
