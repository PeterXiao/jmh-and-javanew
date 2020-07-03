package basics.sorting.quick;

import static basics.sorting.utils.SortUtils.exchange;
import static basics.sorting.utils.SortUtils.less;

public class QuickSortBasic {

    public void sort(final int[] input) {

	// KnuthShuffle.shuffle(input);
	sort(input, 0, input.length - 1);
    }

    private void sort(final int[] input, final int lowIndex, final int highIndex) {

	if (highIndex <= lowIndex) {
	    return;
	}

	final int partIndex = partition(input, lowIndex, highIndex);

	sort(input, lowIndex, partIndex - 1);
	sort(input, partIndex + 1, highIndex);
    }

    private int partition(final int[] input, final int lowIndex, final int highIndex) {

	int i = lowIndex;
	final int pivotIndex = lowIndex;
	int j = highIndex + 1;

	while (true) {

	    while (less(input[++i], input[pivotIndex])) {
		if (i == highIndex) {
		    break;
		}
	    }

	    while (less(input[pivotIndex], input[--j])) {
		if (j == lowIndex) {
		    break;
		}
	    }

	    if (i >= j) {
		break;
	    }

	    exchange(input, i, j);

	}

	exchange(input, pivotIndex, j);

	return j;
    }

}
