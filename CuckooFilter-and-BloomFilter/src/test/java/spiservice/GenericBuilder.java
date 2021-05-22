/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:GenericBuilder.java Package Name:spiservice
 * Date:2021年5月4日下午1:04:13 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: GenericBuilder.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月4日 下午1:04:13
 * @version V1.0
 */
package spiservice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * ClassName:GenericBuilder <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月4日 下午1:04:13 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: GenericBuilder @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月4日 下午1:04:13
 * @version
 * @since JDK 1.8
 */
public class GenericBuilder<T> {

  private final Supplier<T> instantiator;

  private List<Consumer<T>> instanceModifiers = new ArrayList<>();

  public GenericBuilder(Supplier<T> instantiator) {
    this.instantiator = instantiator;
  }

  public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
    return new GenericBuilder<T>(instantiator);
  }

  public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
    Consumer<T> c = instance -> consumer.accept(instance, value);
    instanceModifiers.add(c);
    return this;
  }

  public T build() {
    T value = instantiator.get();
    instanceModifiers.forEach(modifier -> modifier.accept(value));
    instanceModifiers.clear();
    return value;
  }
}
