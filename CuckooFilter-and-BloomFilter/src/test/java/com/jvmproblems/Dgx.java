/**
 * 
 */
package com.jvmproblems;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author xiaoy
 *
 */
public class Dgx {

	/**
	 * 
	 */
	public Dgx() {
		// TODO Auto-generated constructor stub
	}
	public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
	       // 得到盘子总数 n
	       int n = A.size();
	       move(n, A, B, C);
	   }

	   public static void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
	       // 当盘子为空时停止递归
	       if (n <= 0) {
	           return;
	       }
	       // 先将A上面的 n-1 个圆盘移到 B,可以借助 C
	       move(n - 1, A, C, B);
	       // 然后将 A 底下的那块最大的圆盘移到 C
	       C.add(A.remove(A.size() - 1));
	       // 最后将 B 上的 n-1 个圆盘移到到 C,可以借助 A
	       move(n - 1, B, A, C);
	   }

	   // main 方法测试
	   public static void main(String[] args) {
	       List<Integer> A = Lists.newArrayList(2, 1, 0);
	       List<Integer> B = Lists.newArrayList();
	       List<Integer> C = Lists.newArrayList();
	       hanota(A, B, C);
	       for (final Integer num : C) {
	           System.out.println(num);
	       }
	   }


}
