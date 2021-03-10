/**
 * Project Name:java11_in_action File Name:StreamsEx.java Package Name:org.mvnsearch
 * Date:2021年3月10日下午6:19:48 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: StreamsEx.java @Package org.mvnsearch @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月10日 下午6:19:48
 * @version V1.0
 */
package org.mvnsearch;

/**
 * ClassName:StreamsEx <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月10日 下午6:19:48 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: StreamsEx @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月10日 下午6:19:48
 * @version
 * @since JDK 1.8
 */
public class StreamsEx {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月10日 下午6:19:48.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  //    JVM Settings:
  //
  //        -Xms1024m
  //
  //        -Xmx6144m
  //
  //        -XX:MaxMetaspaceSize=512m
  //
  //        -XX:ReservedCodeCacheSize=1024m
  //
  //        -XX:+UseConcMarkSweepGC
  //
  //        -XX:SoftRefLRUPolicyMSPerMB=100
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    //    //stream
    //    List<Integer> result = list.stream()
    //    .mapToInt(x -> x)
    //    .map(x -> ++x)
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));
    //    //iterator
    //    List<Integer> result = new ArrayList<>();
    //    for(Integer e : list){
    //        result.add(++e);
    //    }
    //    //parallel stream
    //    List<Integer> result = list.parallelStream()
    //    .mapToInt(x -> x)
    //    .map(x -> ++x)
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));

    //    //stream
    //    List<Integer> result = list.stream()
    //    .mapToInt(x -> x)
    //    .filter(x -> x > 200)
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));
    //    //iterator
    //    List<Integer> result = new ArrayList<>(list.size());
    //    for(Integer e : list){
    //        if(e > 200){
    //            result.add(e);
    //        }
    //    }
    //    //parallel stream
    //    List<Integer> result = list.parallelStream()
    //    .mapToInt(x -> x)
    //    .filter(x -> x > 200)
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));

    //    //stream
    //    List<Integer> result = list.stream()
    //    .mapToInt(x->x)
    //    .sorted()
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));
    //    //iterator
    //    List<Integer> result = new ArrayList<>(list);
    //    Collections.sort(result);
    //    //parallel stream
    //    List<Integer> result = list.parallelStream()
    //    .mapToInt(x->x)
    //    .sorted()
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));

    //    //stream
    //    int max = list.stream()
    //    .mapToInt(x -> x)
    //    .max()
    //    .getAsInt();
    //    //iterator
    //    int max = -1;
    //    for(Integer e : list){
    //        if(e > max){
    //            max = e;
    //        }
    //    }
    //    //parallel stream
    //    int max = list.parallelStream()
    //    .mapToInt(x -> x)
    //    .max()
    //    .getAsInt();

    //    //stream
    //    String result = list.stream().map(String::valueOf).collect(Collectors.joining(","));
    //    //iterator
    //    StringBuilder builder = new StringBuilder();
    //    for(Integer e : list){
    //        builder.append(e).append(",");
    //    }
    //    String result = builder.length() == 0 ? "" : builder.substring(0,builder.length() - 1);
    //    //parallel stream
    //    String result = list.stream().map(String::valueOf).collect(Collectors.joining(","));

    //    //stream
    //    List<Integer> result = list.stream()
    //    .filter(Objects::nonNull)
    //    .mapToInt(x -> x + 1)
    //    .filter(x -> x > 200)
    //    .distinct()
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));
    //    //iterator
    //    HashSet<Integer> set  = new HashSet<>(list.size());
    //    for(Integer e : list){
    //        if(e != null && e > 200){
    //            set.add(e + 1);
    //        }
    //    }
    //    List<Integer> result = new ArrayList<>(set);
    //    //parallel stream
    //    List<Integer> result = list.parallelStream()
    //    .filter(Objects::nonNull)
    //    .mapToInt(x -> x + 1)
    //    .filter(x -> x > 200)
    //    .distinct()
    //    .boxed()
    //    .collect(Collectors.toCollection(ArrayList::new));

    //
    //      从以上的实验来看，可以总结处以下几点：
    //
    //      ﻿
    //
    //      在少低数据量的处理场景中（size<=1000），stream 的处理效率是不如传统的 iterator
    // 外部迭代器处理速度快的，但是实际上这些处理任务本身运行时间都低于毫秒，这点效率的差距对普通业务几乎没有影响，反而 stream 可以使得代码更加简洁；
    //
    //      ﻿
    //
    //      在大数据量（szie>10000）时，stream 的处理效率会高于 iterator，特别是使用了并行流，在cpu恰好将线程分配到多个核心的条件下（当然parallel
    // stream 底层使用的是 JVM 的 ForkJoinPool，这东西分配线程本身就很玄学），可以达到一个很高的运行效率，然而实际普通业务一般不会有需要迭代高于10000次的计算；
    //
    //      ﻿
    //
    //      Parallel Stream 受引 CPU 环境影响很大，当没分配到多个cpu核心时，加上引用 forkJoinPool 的开销，运行效率可能还不如普通的 Stream；
    //
    //      ﻿
    //
    //      6、使用 Stream 的建议
    //      ﻿
    //
    //      简单的迭代逻辑，可以直接使用 iterator，对于有多步处理的迭代逻辑，可以使用 stream，损失一点几乎没有的效率，换来代码的高可读性是值得的；
    //
    //      单核 cpu 环境，不推荐使用 parallel stream，在多核 cpu 且有大数据量的条件下，推荐使用 paralle stream；
    //
    //      stream 中含有装箱类型，在进行中间操作之前，最好转成对应的数值流，减少由于频繁的拆箱、装箱造成的性能损失。
  }
}
