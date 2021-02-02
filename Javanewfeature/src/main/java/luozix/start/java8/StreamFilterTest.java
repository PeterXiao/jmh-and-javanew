/**
 * 
 */
package luozix.start.java8;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author xiaoy
 *
 */
public class StreamFilterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = Person.getList();

		// get the stream (sequential version) to apply the filter operation
		Stream<Person> personsStream = persons.stream();

		// apply the filter
		Stream<Person> personsFilters = personsStream.filter(p -> p.getAge() >= 18);
		System.out.println("Persons filtered:");
		personsFilters.forEach((p) -> System.out.println(p));
	}

}
