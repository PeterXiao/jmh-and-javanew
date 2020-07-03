package basics.sorting.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class SortUtils {

    /*
     * public double runWithTimeMeasurement(int timeMillis, TestCase tc, int
     * iterations) throws Exception { long start = System.currentTimeMillis();
     * 
     * double sumTime = 0; int count = 0;
     * System.err.println("test-time "+timeMillis+" iteration "+iterations); while (
     * System.currentTimeMillis()-start < timeMillis ) { double time =
     * tc.run(transformer, serializer, value, iterations); sumTime += time;
     * measurementVals[count] = time; count++; } double avg = sumTime / count;
     * Arrays.sort(measurementVals,0,count); System.err.println(
     * "-----------------------------------------------------------------------------"
     * ); System.err.println(serializer.getName()); System.err.println("min:" +
     * measurementVals[0]); System.err.println("1/4:"+measurementVals[count/4]);
     * System.err.println("1/2:"+measurementVals[count/2]);
     * System.err.println("3/4:"+measurementVals[count/4*3]);
     * System.err.println("max:"+measurementVals[count-1]);
     * System.err.println("average:"+ avg
     * +" deviation:"+(avg-measurementVals[count/2])); System.err.println(
     * "-----------------------------------------------------------------------------"
     * ); return avg; }
     */

    public static boolean less(final Comparable a, final Comparable b) {
	return a.compareTo(b) < 0;
    }

    public static boolean less(final int a, final int b) {
	return a < b;
    }

    public static void exchange(final Comparable array[], final int from, final int to) {

	final Comparable temp = array[from];
	array[from] = array[to];
	array[to] = temp;
    }

    public static void exchange(final int[] input, final int i, final int r) {
	final int temp = input[i];
	input[i] = input[r];
	input[r] = temp;
    }

    public static String arrayToString(final Comparable[] array) {

	if (array == null) {
	    return "NULL ARRAY";
	}

	final StringBuilder builder = new StringBuilder();
	for (final Comparable eachItem : array) {
	    builder.append(eachItem).append(" : ");
	}

	return builder.toString();
    }

    public static String arrayToString(final int[] input) {
	if (input == null) {
	    return "NULL ARRAY";
	}

	final StringBuilder builder = new StringBuilder();
	for (final int eachItem : input) {
	    builder.append(eachItem).append(" : ");
	}

	return builder.toString();

    }

    public static String intArrayToString3Space(final int[] input) {
	if (input == null) {
	    return "NULL ARRAY";
	}

	final StringBuilder builder = new StringBuilder();
	for (final int eachItem : input) {
	    builder.append(eachItem).append("    :    ");
	}

	return builder.toString();

    }

    public static String traceArrayToString3Space(final String[] traceArray) {
	if (traceArray == null) {
	    return "NULL ARRAY";
	}

	final StringBuilder builder = new StringBuilder();
	for (final String eachItem : traceArray) {
	    if (!eachItem.contains("/")) {
		builder.append(eachItem).append("    :    ");
	    } else {
		int countOccurence = 4;
		for (final String eachTerm : eachItem.split("/")) {
		    countOccurence--;
		    builder.append(eachTerm);
		}
		for (int i = 0; i < countOccurence; i++) {
		    builder.append(" ");
		}
		builder.append(" :    ");
	    }
	}

	return builder.toString();

    }

    public static boolean isSorted(final int[] input) {

	for (int count = 0; count < input.length - 1; count++) {
	    // System.out.println("Comparing : " + input[count] + " & " + input[count + 1]);
	    if (input[count] > input[count + 1]) {
		return false;
	    }

	}
	return true;
    }

    public static boolean isSorted(final Comparable[] a, final int lo, final int hi) {
	for (int i = lo + 1; i <= hi; i++) {
	    if (less(a[i], a[i - 1])) {
		return false;
	    }
	}
	return true;
    }

    public static boolean isSorted(final int[] a, final int lo, final int hi) {
	for (int i = lo + 1; i <= hi; i++) {
	    if (less(a[i], a[i - 1])) {
		return false;
	    }
	}
	return true;
    }

    public static int[] generateRandomData(final int count) {

	final int[] randomData = new int[count];
	final Random random = new Random();

	for (int i = 0; i < count; i++) {
	    randomData[i] = random.nextInt(count);
	}

	return randomData;
    }

    public static int[] generateDuplicateData(final int count) {

	final int[] duplicateData = new int[count];
	for (int i = 0; i < count; i++) {
	    duplicateData[i] = 2; // just any number would do. Just bored with the default 0
	}

	return duplicateData;
    }

    public static Integer[] convertIntArrayToIntegerArray(final int[] input) {

	final Integer[] newArray = new Integer[input.length];
	int i = 0;
	for (final int value : input) {
	    newArray[i++] = Integer.valueOf(value);
	}

	return newArray;
    }

    public static void insertBreak(final int inputLength) {
	for (int tmp = 0; tmp < inputLength; tmp++) {
	    System.out.print("-----------");
	}
    }

    public static void addToTracer(final String[] tracer, final int index, final String markerString) {
	if (tracer[index].trim().equals("")) {
	    tracer[index] = markerString;
	} else {
	    tracer[index] = tracer[index] + "/" + markerString;
	}

    }

    public static String[] cleanupArray(final String[] tracer) {

	for (int tmp = 0; tmp < tracer.length; tmp++) {
	    tracer[tmp] = " ";
	}

	return tracer;
    }

    public static boolean isHeap(final int[] input, final int heapRoot) {

	// System.out.println("Heap Root input : :::: "+heapRoot);
	final int lastIndex = input.length - 1;

	if (heapRoot >= lastIndex / 2 + 1) {
	    return true; // leaf nodes
	}

	// System.out.println("condition 1 " +(((heapRoot*2))+2));
	if (heapRoot * 2 + 2 < lastIndex) {

	    // System.out.println("Compare 1 : "+ input[heapRoot] + " vs "+
	    // input[heapRoot*2+1] + " & "+ input[heapRoot*2 +2]);
	    if (input[heapRoot] >= input[heapRoot * 2 + 2] && input[heapRoot] >= input[heapRoot * 2 + 1]) {
		return isHeap(input, heapRoot + 1);
	    } else {
		return false;
	    }

	} else {

	    // System.out.println("Compare 2 : "+ input[heapRoot] + " vs "+ input[heapRoot*2
	    // +1]);

	    if (input[heapRoot] > input[heapRoot * 2 + 1]) {
		// return isHeapOrdered(input, heapRoot+1);
		return true; // True would do. Heap is a complete BT
	    } else {
		return false;
	    }
	}

    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(final Map<K, V> map) {
	final List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
	list.sort(Entry.comparingByValue());

	final Map<K, V> result = new LinkedHashMap<>();
	for (final Entry<K, V> entry : list) {
	    result.put(entry.getKey(), entry.getValue());
	}

	return result;
    }
}