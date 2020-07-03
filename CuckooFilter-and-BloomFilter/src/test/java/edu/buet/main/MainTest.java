package edu.buet.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.DoubleStream;

import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.map.primitive.MutableIntIntMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.IntIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.junit.Test;

import com.romix.scala.collection.concurrent.TrieMap;

import it.unimi.dsi.fastutil.doubles.Double2DoubleMap;
import it.unimi.dsi.fastutil.doubles.Double2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntBigArrays;

public class MainTest {

    @Test
    public void testMain() {
        fail("Not yet implemented");

        Map myMap = new TrieMap<Object, Object>();
        myMap.put("key", "value");

        Double2DoubleMap d2dMap = new Double2DoubleOpenHashMap();

        d2dMap.put(2.0, 5.5);
        d2dMap.put(3.0, 6.6);

        assertEquals(5.5, d2dMap.get(2.0));

    }

    @Test
    public void givenValidAray_whenWrapped_checkAccessFromIntBigArraysMethodsCorrect() {
        int[] oneDArray = new int[] {2, 1, 5, 2, 1, 7};
        int[][] twoDArray = IntBigArrays.wrap(oneDArray.clone());

        int firstIndex = IntBigArrays.get(twoDArray, 0);
        int lastIndex = IntBigArrays.get(twoDArray, IntBigArrays.length(twoDArray) - 1);

        assertEquals(2, firstIndex);
        assertEquals(7, lastIndex);

    }

    @Test
    public void whenListOfLongHasOneTwoThree_thenSumIsSix() {
        MutableLongList longList = LongLists.mutable.of(1L, 2L, 3L);
        assertEquals(6, longList.sum());
    }

    @Test
    public void whenListOfIntHasOneTwoThree_thenMaxIsThree() {
        ImmutableIntList intList = IntLists.immutable.of(1, 2, 3);
        assertEquals(3, intList.max());
    }

    @Test
    public void whenConvertFromIterableToPrimitive_thenValuesAreEquals() {
        Iterable<Integer> iterable = Interval.oneTo(3);
        MutableIntSet intSet = IntSets.mutable.withAll(iterable);
        IntInterval intInterval = IntInterval.oneTo(3);
        assertEquals(intInterval.toSet(), intSet);
    }

    @Test
    public void testOperationsOnIntIntMap() {
        MutableIntIntMap map = new IntIntHashMap();
        assertEquals(5, map.addToValue(0, 5));
        assertEquals(5, map.get(0));
        assertEquals(3, map.getIfAbsentPut(1, 3));
    }

    @Test
    public void whenCreateDoubleStream_thenAverageIsThree() {
        DoubleStream doubleStream = DoubleLists.mutable.with(1.0, 2.0, 3.0, 4.0, 5.0).primitiveStream();
        assertEquals(3, doubleStream.average().getAsDouble(), 0.001);
    }

    @Test
    public void whenCreateMapFromStream_thenValuesMustMatch() {
        Iterable<Integer> integers = Interval.oneTo(3);
        MutableIntIntMap map = IntIntMaps.mutable.from(integers, key -> key, value -> value * value);
        MutableIntIntMap expected = IntIntMaps.mutable.empty().withKeyValue(1, 1).withKeyValue(2, 4).withKeyValue(3, 9);
        assertEquals(expected, map);
        System.out.println();
        if (1 == 1) {

        } else {

        }
    }

    /*
     * @Param({ "100", "1000", "10000", "100000" }) public int setSize;
     * 
     * @Benchmark public IntSet
     * givenFastUtilsIntSetWithInitialSizeSet_whenPopulated_checkTimeTaken() {
     * IntSet intSet = new IntOpenHashSet(setSize); for (int i = 0; i < setSize;
     * i++) { intSet.add(i); } return intSet; }
     * 
     * @Benchmark public Set<Integer>
     * givenCollectionsHashSetWithInitialSizeSet_whenPopulated_checkTimeTaken() {
     * Set<Integer> intSet = new HashSet<>(setSize); for (int i = 0; i < setSize;
     * i++) { intSet.add(i); } return intSet; }
     */

    public static void main(String[] args) {

        Random random = random = new Random();

        while (true) {

            int count = 1000000;

            int times = 10;

            int existsStart = random.nextInt(count);
            int notExistsStart = existsStart + count;

            String[] exists = getStrings(existsStart, existsStart + count);
            String[] notExists = getStrings(notExistsStart, notExistsStart + count);
            HashMap<String, String> map = new HashMap();

            long begin = System.currentTimeMillis();

            for (int i = 0; i < exists.length; i++) {
                String item = exists[i];
                map.put(item, item);
            }

            System.out.println("add:" + (System.currentTimeMillis() - begin));

            begin = System.currentTimeMillis();

            for (int t = 0; t < times; t++) {
                for (int i = 0; i < exists.length; i++) {
                    String item = exists[i];
                    map.containsKey(item);
                }
            }

            System.out.println("exists:" + (System.currentTimeMillis() - begin));

            begin = System.currentTimeMillis();

            for (int t = 0; t < times; t++) {
                for (int i = 0; i < notExists.length; i++) {
                    String item = notExists[i];
                    map.containsKey(item);
                }
            }

            System.out.println("not exists:" + (System.currentTimeMillis() - begin));

            begin = System.currentTimeMillis();

            for (int i = 0; i < exists.length; i++) {
                String item = exists[i];
                map.remove(item);
            }

            System.out.println("remove:" + (System.currentTimeMillis() - begin));

            System.out.println("=====================end======================");
        }
    }

    public static String[] getStrings(int start, int end) {
        int length = end - start;

        String[] ret = new String[length];

        for (int i = 0; i < length; i++) {
            ret[i] = "0x" + Integer.toString(start + i, 16);
        }

        return ret;
    }
}
