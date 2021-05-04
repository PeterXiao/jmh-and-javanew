/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:BubbleSort.java Package Name:com.recompiling
 * Date:2021年5月3日上午11:38:21 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: BubbleSort.java @Package com.recompiling @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月3日 上午11:38:21
 * @version V1.0
 */
package com.recompiling;
/**
 * ClassName:BubbleSort <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月3日 上午11:38:21 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.ArrayList;
/**
 * @ClassName: BubbleSort @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月3日 上午11:38:21
 * @version
 * @since JDK 1.8
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BubbleSort {

  private static void bubbleSort(int[] nums) {
    boolean hasChange = true;
    for (int i = 0, n = nums.length; i < n - 1 && hasChange; ++i) {
      hasChange = false;
      for (int j = 0; j < n - i - 1; ++j) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
          hasChange = true;
        }
      }
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    int n;
    if (nums == null || (n = nums.length) < 3) {
      return Collections.emptyList();
    }
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n - 2; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int p = i + 1, q = n - 1;
      while (p < q) {
        if (p > i + 1 && nums[p] == nums[p - 1]) {
          ++p;
          continue;
        }
        if (q < n - 1 && nums[q] == nums[q + 1]) {
          --q;
          continue;
        }
        if (nums[p] + nums[q] + nums[i] < 0) {
          ++p;
        } else if (nums[p] + nums[q] + nums[i] > 0) {
          --q;
        } else {
          res.add(Arrays.asList(nums[p], nums[q], nums[i]));
          ++p;
          --q;
        }
      }
    }
    return res;
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    int n;
    if (nums == null || (n = (nums.length)) < 4) {
      return Collections.emptyList();
    }
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n - 3; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < n - 2; ++j) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int p = j + 1, q = n - 1;
        while (p < q) {
          if (p > j + 1 && nums[p] == nums[p - 1]) {
            ++p;
            continue;
          }
          if (q < n - 1 && nums[q] == nums[q + 1]) {
            --q;
            continue;
          }
          int t = nums[i] + nums[j] + nums[p] + nums[q];
          if (t == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
            ++p;
            --q;
          } else if (t < target) {
            ++p;
          } else {
            --q;
          }
        }
      }
    }
    return res;
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0, n = nums.length; i < n; ++i) {
      int num = target - nums[i];
      if (map.containsKey(num)) {
        return new int[] {map.get(num), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  private static void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 7, 9, 5, 8};
    bubbleSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
