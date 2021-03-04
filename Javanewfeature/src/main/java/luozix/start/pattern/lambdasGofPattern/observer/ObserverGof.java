/**
 * Project Name:java11_in_action File Name:ObserverGof.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.observer Date:2021年3月4日下午5:48:05 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ObserverGof.java @Package luozix.start.pattern.lambdasGofPattern.observer @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:48:05
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.observer;
/**
 * ClassName:ObserverGof <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:48:05 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ObserverGof @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:48:05
 * @version
 * @since JDK 1.8
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObserverGof {

  interface Listener {
    void onEvent(Object event);
  }

  public static class Observable {
    private final Map<Object, Listener> listeners = new ConcurrentHashMap<>();

    public void register(Object key, Listener listener) {
      listeners.put(key, listener);
    }

    public void unregister(Object key) {
      listeners.remove(key);
    }

    public void sendEvent(Object event) {
      for (Listener listener : listeners.values()) {
        listener.onEvent(event);
      }
    }
  }

  public static class Observer1 {
    Observer1(Observable observable) {
      observable.register(
          this,
          new Listener() {
            @Override
            public void onEvent(Object event) {
              System.out.println(event);
            }
          });
    }
  }

  public static class Observer2 implements Listener {
    Observer2(Observable observable) {
      observable.register(this, this);
    }

    @Override
    public void onEvent(Object event) {
      System.out.println(event);
    }
  }

  public static void main(String[] args) {
    Observable observable = new Observable();
    new Observer1(observable);
    new Observer2(observable);

    observable.sendEvent("Hello World!");
  }
}
