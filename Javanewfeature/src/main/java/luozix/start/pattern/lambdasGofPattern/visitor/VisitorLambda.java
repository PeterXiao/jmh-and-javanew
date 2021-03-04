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
import java.util.HashMap;
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

  public static void main(String[] args) {}
}
