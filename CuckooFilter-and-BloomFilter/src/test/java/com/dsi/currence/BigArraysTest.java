package com.dsi.currence;

import static it.unimi.dsi.fastutil.BigArrays.get;
import static it.unimi.dsi.fastutil.BigArrays.length;
import static it.unimi.dsi.fastutil.BigArrays.swap;
import static it.unimi.dsi.fastutil.BigArrays.wrap;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import it.unimi.dsi.fastutil.BigArrays;
import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;

public class BigArraysTest {

	@Test
	public void testMergeSort() {
		final int[] s = new int[] { 2, 1, 5, 2, 1, 0, 9, 1, 4, 2, 4, 6, 8, 9, 10, 12, 1, 7 };
		final int[][] a = wrap(s.clone());

		Arrays.sort(s);
		final int[][] sorted = wrap(s.clone());
		BigArrays.mergeSort(0, length(a), (k1, k2) -> get(a, k1) - get(a, k2), (k1, k2) -> swap(a, k1, k2));
		assertArrayEquals(sorted, a);

		BigArrays.mergeSort(0, length(a), (k1, k2) -> get(a, k1) - get(a, k2), (k1, k2) -> swap(a, k1, k2));
		assertArrayEquals(sorted, a);

	}

	@Test
	public void testQuickSort() {
		final int[] s = new int[] { 2, 1, 5, 2, 1, 0, 9, 1, 4, 2, 4, 6, 8, 9, 10, 12, 1, 7 };

		Arrays.sort(s);
		final int[][] sorted = wrap(s.clone());

		final int[][] a = wrap(s.clone());
		BigArrays.quickSort(0, length(a), (k1, k2) -> get(a, k1) - get(a, k2), (k1, k2) -> swap(a, k1, k2));
		assertArrayEquals(sorted, a);

		BigArrays.quickSort(0, length(a), (k1, k2) -> get(a, k1) - get(a, k2), (k1, k2) -> swap(a, k1, k2));
		assertArrayEquals(sorted, a);
	}

	@Test
	public void testEnsureCapacity() {
		final LongBigArrayBigList longList = new LongBigArrayBigList();
		longList.size(4096);
		// Never completes!
		longList.ensureCapacity(2);
	}
}
