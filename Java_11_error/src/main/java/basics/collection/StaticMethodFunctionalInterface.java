package basics.collection;

import java.util.Arrays;

@FunctionalInterface
interface FunctionalInterfaceWithStaticMethod {
	static int sum(int[] array) {
		return Arrays.stream(array).reduce((a, b) -> a+b).getAsInt();
	}
	
	void apply();
}
public class StaticMethodFunctionalInterface {
	public static void main(String[] args) {
		int sum = FunctionalInterfaceWithStaticMethod.sum(new int[]{1,2,3,4,5});
		
		FunctionalInterfaceWithStaticMethod f = () -> {};
		
		InterfaceWithDefaultMethod i = (o) -> {};
		i.apply(null);
		i.say("default method");
	}
}

@FunctionalInterface
interface InterfaceWithDefaultMethod {
	void apply(Object obj);
	
	default void say(String name) {
		System.out.println("hello " + name);
	}
}
//class FunctionalInterfaceWithDefaultMethod {
//	public static void main(String[] args) {
//		InterfaceWithDefaultMethod i = (o) -> {};
//		i.apply(null);
//		i.say("default method");
//	}
//}