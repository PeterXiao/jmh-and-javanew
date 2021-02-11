/**  
* @Title: ProblemJava.java
* @Package com.jvmproblems
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 上午11:22:08
* @version V1.0  
*/
package com.jvmproblems;
/**
* @ClassName: ProblemJava
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 上午11:22:08
*
*/
public class ProblemJava {
	public static void main(String[] args) {
		int[] A = { 4, 5, 10, 11, 6 };

		int n;
		n = A.length;

		int i, j;
		for (i = 0; i < n; i++)
			for (j = i + 1; j < n; j++) {
				if (A[i] - A[j] == -1)
					System.out.println(i + "-" + j);
				else if (A[i] - A[j] == 1)
					System.out.println(j + "-" + i);
			}
	}
}
