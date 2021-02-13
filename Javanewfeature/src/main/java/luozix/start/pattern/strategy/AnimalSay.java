/**  
* @Title: AnimalSay.java
* @Package luozix.start.pattern.strategy
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:42:46
* @version V1.0  
*/
package luozix.start.pattern.strategy;
/**
* @ClassName: AnimalSay
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:42:46
*
*/
public class AnimalSay {

	Animal animal;

	public AnimalSay(Animal animal) {
		this.animal = animal;
	}

	public void say() {
		this.animal.say();
	}

	public static void doTheJob(String animalType) {
		Animal animalObject = null;
		switch (animalType) {
		case "dog":
			animalObject = new Dog();
			break;
		case "cat":
			animalObject = new Cat();
			break;
		default:
			System.out.println("Your choice is wrong");
			break;
		}
		animalObject.say();
	}

	public static void main(String[] args) throws Exception {
		doTheJob("cat");

	}
}
