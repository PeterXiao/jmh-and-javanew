/**  
* @Title: TemplateLambda.java
* @Package luozix.start.pattern
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:01:01
* @version V1.0  
*/
package luozix.start.pattern;
/**
* @ClassName: TemplateLambda
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:01:01
*
*/

import java.util.Random;
import java.util.function.Consumer;

public class TemplateLambda {

	public void execute(Consumer<Resource> resourceOperations) {
		Resource r = new Resource();
		r.open();
		try {
			resourceOperations.accept(r);
		} finally {
			r.close();
		}
	}

	private static class Resource {
		public void open() {
			System.out.println("Openning resource");
		}

		public void close() {
			System.out.println("Clossing resource");
		}

		public Resource useResource() {
			System.out.println("Ussing resource");
			return this;
		}

		public Resource employResource() {
			Random r = new Random();
			if (r.nextInt(3) == 0) {
				throw new RuntimeException("Random error");
			}
			System.out.println("Resource employed");
			return this;
		}

	}

	public static void main(String[] args) {
		TemplateLambda tl = new TemplateLambda();
		tl.execute(r -> r.useResource().employResource());
	}

}
