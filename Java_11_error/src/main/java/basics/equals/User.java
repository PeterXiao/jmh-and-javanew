/**
 *
 */
package basics.equals;

/**
 * @author Office
 *
 */

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class User {
    private String name;
    private int age;
    private String passport;
    // getters and setters, constructor

    @Override
    public boolean equals(final Object o) {

	if (o == this) {
	    return true;
	}
	if (!(o instanceof User)) {
	    return false;
	}
	final User user = (User) o;

	return new EqualsBuilder().append(age, user.age).append(name, user.name).append(passport, user.passport)
		.isEquals();
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(17, 37).append(name).append(age).append(passport).toHashCode();
    }
}
/*
 * 
 * 
 * 
 * import java.util.Objects;
 * 
 * public class User { private String name; private int age; private String
 * passport;
 * 
 * //getters and setters, constructor
 * 
 * @Override public boolean equals(Object o) { if (o == this) return true; if
 * (!(o instanceof User)) { return false; } User user = (User) o; return age ==
 * user.age && Objects.equals(name, user.name) && Objects.equals(passport,
 * user.passport); }
 * 
 * @Override public int hashCode() { return Objects.hash(name, age, passport); }
 * 
 * }
 */