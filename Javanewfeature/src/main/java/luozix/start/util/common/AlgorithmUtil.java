/**
 * Project Name:java11_in_action File Name:AlgorithmUtil.java Package Name:luozix.start.util.common
 * Date:2021年3月4日下午3:10:47 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: AlgorithmUtil.java @Package luozix.start.util.common @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:10:47
 * @version V1.0
 */
package luozix.start.util.common;
/**
 * ClassName:AlgorithmUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:10:47 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: AlgorithmUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:10:47
 * @version
 * @since JDK 1.8
 */
public class AlgorithmUtil {

  /*
  todo
  各种算法
  排序
  查找
  去重
  合并
  插入
  删除
  修改 replace(int start, int end)
   */

  /*排序部分 small -> large */

  public static int[] bucketSort(int[] arr) {
    // int bucketSize = arr.max() // TODO: 16/8/8
    // int[] bucket = new int[]
    return new int[] {1, 1};
  }

  /**
   * Bubble sort | O(N^2)
   *
   * <p>x x x x x x
   *
   * @param arr array to be sorted
   * @return sorted array
   */
  public static int[] bubbleSort(int[] arr) {
    int length = arr.length;
    int temp;
    for (int i = 0; i < length - 1; i++) {
      for (int j = 0; j < length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  /**
   * Quick sort | worst: O(N^2), avg: O(N * logN)
   *
   * @param arr
   * @param low
   * @param high
   * @return
   */
  public static int[] quickSort(int[] arr, int low, int high) {
    int lowIndex = low;
    int highIndex = high;
    int key = arr[lowIndex];
    while (lowIndex < highIndex) {
      while (arr[highIndex] >= key && highIndex > lowIndex) {
        highIndex--;
      }
      if (lowIndex < highIndex) {
        arr[lowIndex] = arr[highIndex];
        lowIndex++;
      }
      while (arr[lowIndex] <= key && lowIndex < highIndex) {
        lowIndex++;
      }
      if (lowIndex < highIndex) {
        arr[highIndex] = arr[lowIndex];
        highIndex--;
      }
    }
    arr[lowIndex] = key;
    if (lowIndex > low) {
      quickSort(arr, low, lowIndex - 1);
    }
    if (lowIndex < high) {
      quickSort(arr, lowIndex + 1, high);
    }
    return arr;
  }

  public static int[] reverse(int[] arr) {
    int length = arr.length;
    int[] newArr = new int[length];
    for (int i = 0; i < length; i++) {
      newArr[i] = arr[length - 1 - i];
    }
    return newArr;
  }

  /*查找部分*/

  public static int max(int[] arr) {
    return 0;
  }

  public static int min(int[] arr) {
    return 0;
  }

  public static int indexOf(int[] arr) {
    return 0;
  }

  // ============= method run time counter

  public interface OnCountMethodTimeCallback {
    void onCountBegin();
  }

  public static OnCountMethodTimeCallback sOnCountMethodTimeCallback;

  public static void setOnCountMethodTimeCallback(
      OnCountMethodTimeCallback onCountMethodTimeCallback) {
    sOnCountMethodTimeCallback = onCountMethodTimeCallback;
  }

  public static long time(OnCountMethodTimeCallback onCountMethodTimeCallback) {
    long begin = System.currentTimeMillis();
    if (onCountMethodTimeCallback != null) {
      onCountMethodTimeCallback.onCountBegin();
    }
    long end = System.currentTimeMillis();
    long duration = end - begin;
    System.out.println(duration);
    return duration;
  }
}
