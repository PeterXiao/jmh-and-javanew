/**
 *
 */
package basics.collection.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Office
 *
 */
public class StreamTest {

    /**
	 * @param args
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		final List<String> l = new ArrayList(Arrays.asList("one", "two"));
		final Stream<String> sl = l.stream();
		l.add("three");
		sl.forEach(System.out::println);

	  	final Function<Long, Long>[] funs = newArray(Function.class, 1);
	  	funs[0] = x -> {if (x ==1 || x == 2) {
		    return 1L;
		} else {
		    return funs[0].apply(x -1) + x;
		}
	};
	  	System.out.println(funs[0].apply(10L));
//		List<String> ls = new CopyOnWriteArrayList<>(Arrays.asList("one", "two"));
//		Stream<String> sl = ls.stream();
//		sl.forEach(s -> sl.add("three"));
	  	final String s = "smallnest";
	  	final Runnable r = () -> System.out.println("hello " + s);
	  	r.run();
//	  	Sample s = new Sample();
//	  	s.setStr("smallnest");
//	  	Runnable r = () -> System.out.println("hello " + s.getStr());
//	  	s.setStr("colobu");
//	  	r.run();
	}

    @SuppressWarnings("unchecked")
    private static <E> E[] newArray(final Class clazz, final int size) {
	return (E[]) Array.newInstance(clazz, size);
    }
//	  public static void main(String[] args) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException {
//	  	//Function<Long, Long> fib = x -> {if (x ==1 || x == 2) return 1L; else return fib.apply(x -1) + x;};
//
//	  	Function<Long, Long>[] funs = newArray(Function.class, 1);
//	  	funs[0] = x -> {if (x ==1 || x == 2) return 1L; else return funs[0].apply(x -1) + x;};
//	  	System.out.println(funs[0].apply(10L));
//	  }
//	  BiFunction<BiFunction, Long, Long> factHelper = (f, x) -> {if (x ==1 || x == 2) return 1L; else return x + (long)f.apply(f,x-1);};
//	  Function<Long, Long> fib = x -> factHelper.apply(factHelper, x);
}
