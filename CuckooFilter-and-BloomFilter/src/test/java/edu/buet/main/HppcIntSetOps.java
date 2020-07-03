package edu.buet.main;

import com.carrotsearch.hppc.IntHashSet;

public class HppcIntSetOps implements IntSetOps {
	private final IntHashSet delegate;

	public HppcIntSetOps(int expectedElements, double loadFactor) {
		this.delegate = new IntHashSet(expectedElements, loadFactor);
	}

	@Override
	public void add(int key) {
		delegate.add(key);
	}

	@Override
	public void bulkAdd(int[] keys) {
		for (int key : keys) {
			delegate.add(key);
		}
	}

	@Override
	public int bulkContains(int[] keys) {
		int v = 0;
		for (int key : keys) {
			if (delegate.contains(key)) {
				v++;
			}
		}
		return v;
	}

	@Override
	public int[] iterationOrderArray() {
		return delegate.toArray();
	}
}