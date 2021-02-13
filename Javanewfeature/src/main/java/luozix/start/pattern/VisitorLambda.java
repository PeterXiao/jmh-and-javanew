/**  
* @Title: VisitorLambda.java
* @Package luozix.start.pattern
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:59:27
* @version V1.0  
*/
package luozix.start.pattern;
/**
* @ClassName: VisitorLambda
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午10:59:27
*
*/

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class VisitorLambda {

	public static class VisitorFunction<A> implements Function<Object, A> {
		private Map<Class<?>, Function<Object, A>> functionMap = new HashMap<>();

		public <B> Acceptor<A, B> on(Class<B> clazz) {
			return new Acceptor<>(this, clazz);
		}

		@Override
		public A apply(Object o) {
			return functionMap.get(o.getClass()).apply(o);
		}

		public static class Acceptor<A, B> {
			private final VisitorFunction<A> visitor;
			private final Class<B> clazz;

			public Acceptor(VisitorFunction<A> visitor, Class<B> clazz) {
				this.visitor = visitor;
				this.clazz = clazz;
			}

			public VisitorFunction<A> then(Function<B, A> f) {
				visitor.functionMap.put(clazz, (Function<Object, A>) f);
				return visitor;
			}
		}

	}

	public static class Square {
		final double side;

		public Square(double s) {
			this.side = s;
		}
	}

	public static class Circle {
		final double radio;

		public Circle(double r) {
			this.radio = r;
		}
	}

	static Function<Object, Double> area = new VisitorFunction<Double>().on(Square.class).then(s -> s.side * s.side)
			.on(Circle.class).then(c -> c.radio * c.radio * Math.PI);

	public static void main(String[] args) {
		System.out.println(area.apply(new Square(10)));

		System.out.println(area.apply(new Circle(10)));

	}

}