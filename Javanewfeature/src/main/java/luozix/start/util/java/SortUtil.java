/**
 * Project Name:java11_in_action File Name:SortUtil.java Package Name:luozix.start.util.java
 * Date:2021年3月4日下午3:29:53 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: SortUtil.java @Package luozix.start.util.java @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:29:53
 * @version V1.0
 */
package luozix.start.util.java;

import java.util.Random;

/**
 * ClassName:SortUtil <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:29:53 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: SortUtil @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:29:53
 * @version
 * @since JDK 1.8
 */
public class SortUtil {

  /*
  todo 堆排序
   */

  private SortUtil() throws IllegalAccessException {
    throw new IllegalAccessException("Instantiation is not allowed! Use static methods only!");
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static boolean isSort(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static void print(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i] + "");
    }
  }

  private static int uniform(int n) {
    if (n <= 0) throw new IllegalArgumentException("Parameter N must be positive");
    return new Random().nextInt(n);
  }

  public static void shuffle(Object[] a) {
    if (a == null) throw new NullPointerException("argument array is null");
    int n = a.length;
    for (int i = 0; i < n; i++) {
      int r = i + uniform(n - i); // between i and n-1
      Object temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  public static void reverse(Comparable[] a) {
    int n = a.length;
    int limit;
    if (n % 2 == 0) {
      limit = n / 2;
    } else {
      limit = n / 2 + 1;
    }
    for (int i = 0; i < limit; i++) {
      Comparable t = a[i];
      a[i] = a[n - i - 1];
      a[n - i - 1] = t;
    }
  }

  public static class Selection {

    public static void sort(Comparable[] a) {
      int n = a.length;
      for (int i = 0; i < n; i++) {
        int min = i;
        for (int j = i + 1; j < n; j++) {
          if (less(a[j], a[min])) {
            min = j;
          }
        }
        exch(a, i, min);
      }
    }
  }

  public static class Insertion {

    public static void sort(Comparable[] a) {
      int n = a.length;
      for (int i = 1; i < n; i++) {
        for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
          exch(a, j, j - 1);
        }
      }
    }
  }

  public static class Shell {

    public static void sort(Comparable[] a) {
      int n = a.length;
      int h = 1;
      while (h < n / 3) {
        h = 3 * h + 1;
      }
      while (h >= 1) {
        // make array become h sorted
        for (int i = h; i < n; i++) {
          // insert a[i] into a[i-h], a[i-2*h], a[i-3*h]...
          for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
            exch(a, j, j - h);
          }
        }
        h = h / 3;
      }
    }
  }

  public static class Merge {

    private static Comparable[] aux; // temp arr

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
      int i = lo;
      int j = mid + 1;
      for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
      }
      for (int k = lo; k <= hi; k++) {
        if (i > mid) {
          a[k] = aux[j++];
        } else if (j > hi) {
          a[k] = aux[i++];
        } else if (less(aux[j], aux[i])) {
          a[k] = aux[j++];
        } else {
          a[k] = aux[i++];
        }
      }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
      if (hi <= lo) {
        return;
      }
      int mid = lo + (hi - lo) / 2;
      sort(a, lo, mid);
      sort(a, mid + 1, hi);
      merge(a, lo, mid, hi);
    }

    public static void upBottomSort(Comparable[] a) {
      aux = new Comparable[a.length];
      sort(a, 0, a.length - 1);
    }

    public static void bottomUpSort(Comparable[] a) {
      int n = a.length;
      aux = new Comparable[n];
      for (int size = 1; size < n; size *= 2) {
        for (int lo = 0; lo < n - size; lo += size * 2) {
          merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, n - 1));
        }
      }
    }
  }

  public static class Quick {

    private static int partition(Comparable[] a, int lo, int hi) {
      int i = lo;
      int j = hi + 1;
      Comparable v = a[lo];
      while (true) {
        while (less(a[++i], v)) {
          if (i == hi) {
            break;
          }
        }
        while (less(v, a[--j])) {
          if (j == lo) {
            break;
          }
        }
        if (i >= j) {
          break;
        }
        exch(a, i, j);
      }
      exch(a, lo, j);
      return j;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
      if (hi < lo) {
        return;
      }
      int j = partition(a, lo, hi);
      sort(a, lo, j - 1);
      sort(a, j + 1, hi);
    }

    public static void sort(Comparable[] a) {
      shuffle(a); // eleminate input rely
      sort(a, 0, a.length - 1);
    }
  }
}
