/*
 *
 *
 *
 *
 *
 */
package edu.buet.main;

public class Main {

    static final double BLOOM_FILTER_FALSE_POSITIVE_RATE = 0.01;

    public static void main(final String[] args) {

	runTest(1);
	runTest(10);
	runTest(100);
	runTest(1000);
    // runTest(10000);

    }

    private static void runTest(final int noOfLogs) {
	System.out.println("Bloom filter false positive rate: " + BLOOM_FILTER_FALSE_POSITIVE_RATE + "\n");

	System.out.println("Test for " + noOfLogs + "K logs...");

	final Test test = new Test("data" + noOfLogs + "K.txt");

	test.testFilterInsertion(test.bloomFilter);
	test.testFilterInsertion(test.cuckooFilter);

	System.out.println();

	test.testFilterContainment(test.bloomFilter);
	test.testFilterContainment(test.cuckooFilter);

	System.out.println();
    }
}
