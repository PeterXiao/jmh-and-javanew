/**
 *
 */
package basics.equals;

/**
 * @author Office
 *
 */
public class Coder {
	private String name;
	private int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + name.hashCode();
		result = result * 31 + age;

		return result;
	}

	@Override
	public boolean equals(Object object) {
		final Coder o = (Coder) object;
		if (object == this) {
			return true;
		}

		if (!(object instanceof Coder)) {
			return false;
		}

		return o.name.equals(name) && o.age == age;
		// return(this == object);
	}

}
