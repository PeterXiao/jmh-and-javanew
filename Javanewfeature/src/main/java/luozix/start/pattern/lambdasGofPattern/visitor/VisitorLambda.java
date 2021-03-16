/**
 * Project Name:java11_in_action File Name:VisitorLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.visitor Date:2021年3月4日下午5:50:29 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: VisitorLambda.java @Package luozix.start.pattern.lambdasGofPattern.visitor @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:50:29
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.visitor;
/**
 * ClassName:VisitorLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:50:29 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: VisitorLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:50:29
 * @version
 * @since JDK 1.8
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class VisitorLambda {

  public static class LambdaVisitor<A> implements Function<Object, A> {
    private Map<Class<?>, Function<Object, A>> fMap = new HashMap<>();

    public <B> Acceptor<A, B> on(Class<B> clazz) {
      return new Acceptor<>(this, clazz);
    }

    @Override
    public A apply(Object o) {
      return fMap.get(o.getClass()).apply(o);
    }

    static class Acceptor<A, B> {
      private final LambdaVisitor visitor;
      private final Class<B> clazz;

      public Acceptor(LambdaVisitor<A> visitor, Class<B> clazz) {
        this.visitor = visitor;
        this.clazz = clazz;
      }

      public LambdaVisitor<A> then(Function<B, A> f) {
        visitor.fMap.put(clazz, f);
        return visitor;
      }
    }
  }

  public static class Square {
    final double side;

    public Square(double side) {
      this.side = side;
    }
  }

  public static class Circle {
    final double radius;

    public Circle(double radius) {
      this.radius = radius;
    }
  }

  public static class Rectangle {
    final double weidht;
    final double height;

    public Rectangle(double weidht, double height) {
      this.weidht = weidht;
      this.height = height;
    }
  }

  static Function<Object, Double> areaVisitor =
      new LambdaVisitor<Double>()
          .on(Square.class)
          .then(s -> s.side * s.side)
          .on(Circle.class)
          .then(c -> Math.PI * c.radius * c.radius)
          .on(Rectangle.class)
          .then(r -> r.height * r.weidht);

  static Function<Object, Double> perimeterVisitor =
      new LambdaVisitor<Double>()
          .on(Square.class)
          .then(s -> 4 * s.side)
          .on(Circle.class)
          .then(c -> 2 * Math.PI * c.radius)
          .on(Rectangle.class)
          .then(r -> 2 * r.height + 2 * r.weidht);

  public static void main(String[] args) {
    List<Object> figures = Arrays.asList(new Circle(4), new Square(5), new Rectangle(6, 7));

    double totalArea = figures.stream().map(areaVisitor).reduce(0.0, (v1, v2) -> v1 + v2);
    System.out.println("Total area = " + totalArea);

    double totalPerimeter = figures.stream().map(perimeterVisitor).reduce(0.0, (v1, v2) -> v1 + v2);
    System.out.println("Total perimeter = " + totalPerimeter);
  }
}
