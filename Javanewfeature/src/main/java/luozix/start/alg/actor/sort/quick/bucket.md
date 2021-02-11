# 桶排序
是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。为了使桶排序更加高效，我们需要做到这两点：

在额外空间充足的情况下，尽量增大桶的数量
使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。

1. 什么时候最快
当输入的数据可以均匀的分配到每一个桶中。

2. 什么时候最慢
当输入的数据被分配到了同一个桶中。

# 基数排序

基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。

1. 基数排序 vs 计数排序 vs 桶排序
基数排序有两种方法：

这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：

基数排序：根据键值的每位数字来分配桶；
计数排序：每个桶只存储单一键值；
桶排序：每个桶存储一定范围的数值；

# Benchmarking Sorting Algorithms
Benchmarking the performance of different sorting algorithms implemented in Java

The following sorting algorithms are included in the class Benchmarking:

| Algorithm | Best Case | Average Case | Worst Case | 
| --------- | --------- | -----------  | ---------- | 
| **bubblesort** | O(n) | O(n²) |O(n²) | 
| **selectionsort** | O(n^2) | O(n²) | O(n²) | 
| **insertionsort** | O(n) | O(n²) | O(n²) |
| **quicksort** | O(n log(n)) | O(n log(n)) | O(n²) |
| **mergesort** | O(n log(n)) | O(n log(n)) | O(n log(n)) |


The following metrics have been conducted on a 2.4 GHz Intel Core i7:

| Algorithm | 10000 Entries | 100000 Entries | 1000000 Entries |
| --------- | --------- | ----------- | ---------- | 
| bubblesort | 241 ms | 29.2 s | 48.5 mins | 
| selectionsort | 33 ms | 1.9 s | 2.9 mins | 
| insertionsort | 1 ms | 4 ms | 12 ms |
| quicksort | 2 ms | 23 ms | 34 ms |
| mergesort | 5 ms | 26 ms | 137 ms |

排序算法衍生问题



（1）归并排序和快速排序都使用了分治算法。
顾名思义，就是将原问题分割查能同等结构的子问题，之后将子问题逐一解决后，原问题也就得到了解决。

（2）逆序对的定义
如果存在正整数 i, j 使得 1 ≤ i < j ≤ n 而且 A[i] > A[j]，则 <A[i], A[j]> 这个有序对称为 A 的一个逆序对。我们可以使用本教程的归并思想求逆序对的数量。

（3）取数组中第 n 大的元素
并不需要对整个数组进行排序，使用快速排序的思路求数组中第 n 大元素算法复杂度为 O(n)。