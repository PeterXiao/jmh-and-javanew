    /**
	 * Project Name:java11_in_action
	 * File Name:RecordMixinsTest.java
	 * Package Name:luozix.start.records
	 * Date:2021年3月5日下午8:49:55
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
	 * 
	*/
	/**
* @Title: RecordMixinsTest.java
* @Package luozix.start.records
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com
* @date 2021年3月5日 下午8:49:55
* @version V1.0
*/
	  
	package luozix.start.records;
	/**
	 * ClassName:RecordMixinsTest <br/>
	 * Function: TODO ADD FUNCTION. <br/>
	 * Reason:   TODO ADD REASON. <br/>
	 * Date:     2021年3月5日 下午8:49:55 <br/>
	 * @author   xiaoy
	 * @version
	 * @since    JDK 1.8
	 * @see
	 */

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class RecordMixinsTest {

    private static final List<String> example = List.of("one", "two", "three", "four", "five");

    @Test
    public void map() {
        var mappable = new EnhancedList<>(example);

        assertEquals(
            List.of("oneone", "twotwo", "threethree", "fourfour", "fivefive"),
            mappable.map(s -> s + s)
        );
    }


    @Test
    public void filter() {
        var filterable = new EnhancedList<>(example);

        assertEquals(
            List.of("one", "two"),
            filterable.where(s -> s.length() < 4)
        );
    }

    @Test
    public void group() {
        var groupable = new EnhancedList<>(example);

        assertEquals(
            Map.of(
                3, List.of("one", "two"),
                4, List.of("four", "five"),
                5, List.of("three")
            ),
            groupable.groupBy(String::length)
        );
    }

    @Test
    public void chain_filter() {
        var filterable = new EnhancedList<>(example);

        assertEquals(
            List.of("one"),
            filterable
                .where(s -> s.length() < 4)
                .where(s -> s.endsWith("e"))
        );
    }


    public record EnhancedList<T>(List<T> inner) implements
            ForwardingList<T>,
            Mappable<T>,
            Filterable<T, EnhancedList<T>>,
            Groupable<T> {}

    public interface Mappable<T> extends Forwarding<List<T>> {
        default <R> List<R> map(Function<T, R> f) {
            return inner().stream().map(f).collect(toList());
        }
    }

    public interface Filterable<T, R extends Collection<T>> extends ForwardingAllTheWayDown<List<T>, R> {
        default R where(Predicate<T> p) {
            return forwarding(inner().stream().filter(p).collect(toList()));
        }
    }

    public interface Groupable<T> extends Forwarding<List<T>> {
        default <R> Map<R, List<T>> groupBy(Function<T, R> keyExtractor) {
            return inner().stream().collect(Collectors.groupingBy(keyExtractor));
        }
    }


    interface Forwarding<T> {
        T inner();
    }

    interface ForwardingAllTheWayDown<T, R> extends Forwarding<T> {
        default R forwarding(T t) {
            try {
                return (R) compatibleConstructor(getClass().getConstructors(), t)
                        .newInstance(t);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        default Constructor<?> compatibleConstructor(Constructor<?>[] constructors, T t) {
            return Stream.of(constructors)
                    .filter(ctor -> ctor.getParameterCount() == 1)
                    .filter(ctor -> ctor.getParameters()[0].getType().isAssignableFrom(t.getClass()))
                    .findAny().orElseThrow(IllegalStateException::new);
        }
    }

    interface ForwardingList<T> extends List<T>, Forwarding<List<T>> {
        @Override
    List<T> inner();

        @Override
    default int size() {
            return inner().size();
        }

        @Override
    default boolean isEmpty() {
            return inner().isEmpty();
        }

        @Override
    default boolean contains(Object o) {
            return inner().contains(o);
        }

        @Override
    default Iterator<T> iterator() {
            return inner().iterator();
        }

        @Override
    default Object[] toArray() {
            return inner().toArray();
        }

        @Override
    default <T1> T1[] toArray(T1[] a) {
            return inner().toArray(a);
        }

        @Override
    default boolean add(T t) {
            return inner().add(t);
        }

        @Override
    default boolean remove(Object o) {
            return inner().remove(o);
        }

        @Override
    default boolean containsAll(Collection<?> c) {
            return inner().containsAll(c);
        }

        @Override
    default boolean addAll(Collection<? extends T> c) {
            return inner().addAll(c);
        }

        @Override
    default boolean addAll(int index, Collection<? extends T> c) {
            return inner().addAll(index, c);
        }

        @Override
    default boolean removeAll(Collection<?> c) {
            return inner().removeAll(c);
        }

        @Override
    default boolean retainAll(Collection<?> c) {
            return inner().retainAll(c);
        }

        @Override
    default void replaceAll(UnaryOperator<T> operator) {
            inner().replaceAll(operator);
        }

        @Override
    default void sort(Comparator<? super T> c) {
            inner().sort(c);
        }

        @Override
    default void clear() {
            inner().clear();
        }

        @Override
    default T get(int index) {
            return inner().get(index);
        }

        @Override
    default T set(int index, T element) {
            return inner().set(index, element);
        }

        @Override
    default void add(int index, T element) {
            inner().add(index, element);
        }

        @Override
    default T remove(int index) {
            return inner().remove(index);
        }

        @Override
    default int indexOf(Object o) {
            return inner().indexOf(o);
        }

        @Override
    default int lastIndexOf(Object o) {
            return inner().lastIndexOf(o);
        }

        @Override
    default ListIterator<T> listIterator() {
            return inner().listIterator();
        }

        @Override
    default ListIterator<T> listIterator(int index) {
            return inner().listIterator(index);
        }

        @Override
    default List<T> subList(int fromIndex, int toIndex) {
            return inner().subList(fromIndex, toIndex);
        }

        @Override
    default Spliterator<T> spliterator() {
            return inner().spliterator();
        }


        @Override
    default <T1> T1[] toArray(IntFunction<T1[]> generator) {
            return inner().toArray(generator);
        }

        @Override
    default boolean removeIf(Predicate<? super T> filter) {
            return inner().removeIf(filter);
        }

        @Override
    default Stream<T> stream() {
            return inner().stream();
        }

        @Override
    default Stream<T> parallelStream() {
            return inner().parallelStream();
        }

        @Override
    default void forEach(Consumer<? super T> action) {
            inner().forEach(action);
        }
    }


}
