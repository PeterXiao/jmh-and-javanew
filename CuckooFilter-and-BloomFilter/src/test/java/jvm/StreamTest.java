 package jvm;

 import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;

 /**
  * @author xiaoy
  * @date 2020/08/07
  */
public class StreamTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //1.创建list
        List<Integer> personList = new ArrayList<Integer>();
        for (int i = 0; i < 100; ++i) {
            personList.add(i);
        }

        //2.切分处理
        List<List<Integer>> list = Lists.partition(personList, 20);
        list.stream().forEach(tempList -> System.out.println("tempList:" + JSON.toJSONString(tempList)));

        // 1.缓存列表
        List<Integer> mergeList = new ArrayList<>();
        int limit = 20;
        // Stream.Builder<Integer> builder = Stream.builder();
        // Stream<Integer> stream = builder.build();
        Stream<Integer> stream = personList.stream();
        // 2.循环获取元素并缓存
        stream.forEach(e -> {
            if (mergeList.size() >= limit) {
                System.out.println(JSON.toJSONString("mergeList:" + mergeList));
                mergeList.clear();
            }
            mergeList.add(e);
        });
        // 3.退出后，补漏处理
        if (mergeList.size() > 0) {
            System.out.println(JSON.toJSONString(mergeList));
        }
        Stream<Integer> integerStream = personList.stream(); // Stream.of(1, 2, 3);
        Flux flux = Flux.fromStream(integerStream);
        // 2..聚合消费
        flux.buffer(20).subscribe(integers -> {
            System.out.println(JSON.toJSONString("integers" + integers));
        });
    }

}
