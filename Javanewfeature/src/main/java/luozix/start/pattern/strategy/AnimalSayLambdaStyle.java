/**  
* @Title: AnimalSayLambdaStyle.java
* @Package luozix.start.pattern.strategy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:43:18
* @version V1.0  
*/
package luozix.start.pattern.strategy;
/**
* @ClassName: AnimalSayLambdaStyle
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:43:18
*
*/
import java.util.function.Function;

public class AnimalSayLambdaStyle {
	Animal animal;

	public AnimalSayLambdaStyle(Animal animal) {
		this.animal = animal;
	}

	public void say() {
		this.animal.say();
	}

	public static void main(String[] args) throws Exception {
		Function<String, Animal> dog = (a) -> {
			if (a.equals("dog"))
				return new Dog();
			else
				return new Cat();
		};
		dog.apply("cat").say();

		Function<String, Animal> trySortFunctionStyle = (a) -> {
			return new Dog();
		};
		trySortFunctionStyle.apply("dog").say();
	}
}