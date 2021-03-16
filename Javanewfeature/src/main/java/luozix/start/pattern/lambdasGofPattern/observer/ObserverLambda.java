/**
 * Project Name:java11_in_action File Name:ObserverLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.observer Date:2021年3月4日下午5:48:33 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ObserverLambda.java @Package
 * luozix.start.pattern.lambdasGofPattern.observer @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:48:33
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.observer;
/**
 * ClassName:ObserverLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:48:33 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ObserverLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:48:33
 * @version
 * @since JDK 1.8
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ObserverLambda {
  public static class Observable {
    private final Map<Object, Consumer<Object>> listeners = new ConcurrentHashMap<>();

    public void register(Object key, Consumer<Object> listener) {
      listeners.put(key, listener);
    }

    public void unregister(Object key) {
      listeners.remove(key);
    }

    public void sendEvent(Object event) {
      listeners.values().forEach(listener -> listener.accept(event));
    }
  }

  public static void main(String[] args) {
    Observable observable = new Observable();
    observable.register("key1", System.out::println);
    observable.register("key2", System.out::println);

    observable.sendEvent("Hello World!");
  }
}
