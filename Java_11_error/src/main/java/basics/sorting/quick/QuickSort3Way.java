package basics.sorting.quick;

import static basics.sorting.utils.SortUtils.exchange;
import static basics.sorting.utils.SortUtils.less;

public class QuickSort3Way {

    public void sort(final int[] input) {
	// input=shuffle(input);
	sort(input, 0, input.length - 1);
    }

    public void sort(final int[] input, final int lowIndex, final int highIndex) {

	if (highIndex <= lowIndex) {
	    return;
	}

	int lt = lowIndex;
	int gt = highIndex;
	int i = lowIndex + 1;

	final int pivotIndex = lowIndex;
	final int pivotValue = input[pivotIndex];

	while (i <= gt) {

	    if (less(input[i], pivotValue)) {
		exchange(input, i++, lt++);
	    } else if (less(pivotValue, input[i])) {
		exchange(input, i, gt--);
	    } else {
		i++;
	    }

	}

	sort(input, lowIndex, lt - 1);
	sort(input, gt + 1, highIndex);

    }

}
