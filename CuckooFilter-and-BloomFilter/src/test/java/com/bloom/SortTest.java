package com.bloom;

import java.util.stream.Stream;

import org.json.JSONObject;

// import com.alibaba.fastjson.JSONObject;

/**
 * @program: learn
 * @description:
 * @create: 2020-06-14 16:00
 **/
public class SortTest {

    private static Integer[] arr = new Integer[] {1, -2, 1, 7, 3, 10, 20, 9, 8, 0, 13};

    private static int findPartition(Integer[] arr, int low, int high) {

        Integer sentry = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= sentry) {
                high--;
            }

            arr[low] = arr[high];

            while (low < high && arr[low] <= sentry) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = sentry;

        return low;
    }

    /**
     * 快速排序 最坏时间复杂度 O(n2)-完全有序复杂度最低，适合插入排序 最好时间复杂度 O(nlog2n) 平均时间复杂度 O(nlog2n) 空间复杂度 O(nlog2n) 不稳定排序
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void fastSort(Integer[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int partition = findPartition(arr, low, high);
        fastSort(arr, low, partition - 1);
        fastSort(arr, partition + 1, high);
    }

    /**
     * 简单插入排序 最坏时间复杂度 O(n2) 最好的时间复杂度 O(n2) 平均时间复杂度 O(n2) 空间负责度 O(1) 稳定排序
     *
     * @param arr
     */
    private static void simpleInsertSort(Integer[] arr) {
        int i, j;
        for (i = 1; i < arr.length; i++) {
            int current = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (current < arr[j]) {
                    // 往后移动
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = current;
        }
    }

    /**
     * 简单选择排序 最坏时间复杂度 O(n2) 最好时间复杂度 O(n2) 平均时间复杂度 O(n2) 空间复杂度 O(1) 不稳定排序:?
     *
     * @param arr
     */
    private static void simpleSelectedSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            // 找到最小的
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

    /**
     * 冒泡排序 最坏时间复杂度 O(n2) 最好时间复杂度 O(n) 平均时间复杂度 O(n2) 空间复杂度 0(1) 稳定排序
     *
     * @param arr
     */
    private static void bubbleSort(Integer[] arr) {
        int i, j;
        boolean flag = true;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    flag = false;
                }
            }

            // 没有发生任何交换，数组有序，可直接中断循环
            if (flag) {
                break;
            }
        }
    }

    /**
     * 希尔排序 最坏时间复杂度 O(n2) 最好时间复杂度 O(n) 平均时间复杂度 O(n1.3) 空间复杂度 O(1) 不稳定排序
     *
     * @param arr
     */
    private static void shellSort(Integer[] arr) {
        int i, j;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (i = gap; i < arr.length; i++) {
                int current = arr[i];
                for (j = i - gap; j >= 0 && current < arr[j]; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = current;
            }
        }
    }

    private static void merge(Integer[] arr, int start1, int end1, int start2, int end2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int arr1Length = end1 - start1 + 1;
        int arr2Length = end2 - start2 + 1;
        Integer[] target = new Integer[arr1Length + arr2Length];

        while (i < arr1Length && j < arr2Length) {
            if (arr[start1 + i] < arr[start2 + j]) {
                target[k++] = arr[start1 + i];
                i++;
            } else {
                target[k++] = arr[start2 + j];
                j++;
            }
        }

        while (i < arr1Length) {
            target[k++] = arr[start1 + i++];
        }

        while (j < arr2Length) {
            target[k++] = arr[start2 + j++];
        }

        for (i = 0; i < k; i++) {
            arr[start1 + i] = target[i];
        }
    }

    /**
     * 归并排序 最坏时间复杂度 O(nlogn) 最好时间复杂度 O(nlogn) 平均时间复杂度 O(nlogn) 空间复杂度 O(n) 稳定排序
     *
     * @param arr
     */
    private static void mergeSort(Integer[] arr, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, middle + 1, end);
        }
    }

    private static void adjustHead(Integer[] arr, int start, int length) {
        for (int i = 0; i < length / 2; i++) {
            // 默认最大子节点=左子节点
            int maxChildIndex = 2 * i;
            if (maxChildIndex + 1 < length) {
                maxChildIndex = arr[maxChildIndex] > arr[maxChildIndex + 1] ? maxChildIndex : maxChildIndex + 1;
            }

            if (arr[i] < arr[maxChildIndex]) {
                // 交换根和最大子节点
                int temp = arr[maxChildIndex];
                arr[maxChildIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 堆排序 最坏时间复杂度 O(nlog2n) 最好时间复杂度 O(nlog2n) 平均时间复杂度 O(nlog2n) 空间复杂度 O(n) 不稳定排序
     *
     * @param arr
     */
    private static void heapSort(Integer[] arr) {
        // 从最后一个非叶子节点开始调整大根堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHead(arr, i, arr.length);
        }

        // 从最后一个元素开始于第一个元素进行交换并调整
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustHead(arr, 0, i);
        }
    }

    public static void main(String[] args) {

        fastSort(arr, 0, arr.length - 1);
        simpleInsertSort(arr);
        simpleSelectedSort(arr);
        bubbleSort(arr);
        shellSort(arr);
        mergeSort(arr, 0, arr.length - 1);
        heapSort(arr);
        System.out.println("sort result : " + JSONObject.valueToString(arr));

        Stream.of("a", "b", "c", "d", "e").map(str -> {
            System.out.println("map: \t" + str);
            return str.toUpperCase();
        }).filter(str -> {
            System.out.println("filter: " + str);
            return str.equals("B");
        }).forEach(str -> {
            System.out.println("forEach: " + str);
        });

    }
}
