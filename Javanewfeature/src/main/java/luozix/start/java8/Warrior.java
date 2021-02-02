/**
 * 
 */
package luozix.start.java8;

/**
 * @author xiaoy
 *
 */
public class Warrior {
	private Person person;
	private String type;

	public Warrior(Person person) {
		this.person = person;
		type = "Warrior " + person.getAge();
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return type;
	}

}
