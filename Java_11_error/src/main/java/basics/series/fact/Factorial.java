package basics.series.fact;

public class Factorial {

    public int factRecur(final int input) {

	if (input < 2) {
	    return 1;
	}

	return input * factRecur(input - 1);

    }

    public int factIter(final int input) {

	int factSum = 1;

	for (int tempValue = 1; tempValue <= input; tempValue++) {
	    factSum *= tempValue;
	}

	return factSum;

    }

}
