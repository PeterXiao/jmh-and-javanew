/**
 *
 */
package basics.validator;

/**
 * @author Office
 *
 */

/**
 * A simple bean to use with the Validator Example.
 *
 * @version $Revision$
 */
public class ValidateBean {

	String lastName, firstName, street1, street2, city, state, postalCode, age;

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getStreet1() {
		return street1;
	}

	public String getStreet2() {
		return street2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "{lastname=" + lastName + ", firstname=" + firstName + ", street1=" + street1 + ",\n street2=" + street2
				+ ", " + "city=" + city + ", state=" + state + ",\n postalcode=" + postalCode + ", age=" + age + "}";
	}

}
