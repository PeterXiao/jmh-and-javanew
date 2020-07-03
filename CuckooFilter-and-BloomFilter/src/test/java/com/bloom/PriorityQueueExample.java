package com.bloom;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 重写 Comparator<Integer>来决定 优先队列是小根堆还是大根堆
 */
public class PriorityQueueExample {

    public static void main(String[] args) {
        // 实现小根堆
        Queue<Integer> qi = new PriorityQueue<Integer>();
        qi.add(5);
        qi.add(2);
        qi.add(1);
        qi.add(10);
        qi.add(3);

        while (!qi.isEmpty()) {
            System.out.print(qi.poll() + ",");
        }
        System.out.println();
        System.out.println("-----------------------------");

        // 自定义的比较器，可以让我们自由定义比较的顺序 Comparator<Integer> cmp;
        // 生成最大堆使用e2-e1,生成最小堆使用e1-e2,
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };

        // 实现大根堆
        Queue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
        q2.add(2);
        q2.add(8);
        q2.add(9);
        q2.add(1);
        while (!q2.isEmpty()) {
            System.out.print(q2.poll() + ",");
        }

    }

}
