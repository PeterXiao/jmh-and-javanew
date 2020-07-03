package basics.sorting.heap;

import static basics.sorting.utils.SortUtils.arrayToString;
import static basics.sorting.utils.SortUtils.exchange;
import static basics.sorting.utils.SortUtils.less;

public class HeapSort {

    public void sort(final int[] input) {

	constructHeapFromInput(input);

	int N = input.length - 1;
	while (N >= 0) {

	    exchange(input, 0, N--);
	    sink(input, 0, N);

	}

    }

    private void constructHeapFromInput(final int[] input) {

	final int lastIndex = input.length - 1; // input array is 0 based

	for (int counter = lastIndex / 2; counter >= 0; counter--) {
	    sink(input, counter, lastIndex);
	}

	System.out.println("Heap as array : " + arrayToString(input));

    }

    private void sink(final int[] input, int currentNode, final int topIndex) {

	while (2 * currentNode + 1 <= topIndex) {

	    // System.out.println("Current node : "+input[currentNode]);
	    int childNode = 2 * currentNode + 1;

	    // System.out.println("Child node 1 : "+input[childNode]);

	    if (childNode + 1 <= topIndex) {
		// System.out.println("Child node 2 : "+input[childNode+1]);
		if (less(input[childNode], input[childNode + 1])) {
		    childNode++;
		}
	    }

	    if (!less(input[currentNode], input[childNode])) {
		break;
	    }

	    exchange(input, currentNode, childNode);

	    currentNode = childNode;

	}
    }

}
