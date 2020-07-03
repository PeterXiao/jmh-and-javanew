package effectivejava.chapter3.item13;

import java.util.HashMap;
import java.util.Map;

// Adding a clone method to PhoneNumber (page 59)
public final class PhoneNumber implements Cloneable {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(final int areaCode, final int prefix, final int lineNum) {
	this.areaCode = rangeCheck(areaCode, 999, "area code");
	this.prefix = rangeCheck(prefix, 999, "prefix");
	this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(final int val, final int max, final String arg) {
	if (val < 0 || val > max) {
	    throw new IllegalArgumentException(arg + ": " + val);
	}
	return (short) val;
    }

    @Override
    public boolean equals(final Object o) {
	if (o == this) {
	    return true;
	}
	if (!(o instanceof PhoneNumber)) {
	    return false;
	}
	final PhoneNumber pn = (PhoneNumber) o;
	return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
	int result = Short.hashCode(areaCode);
	result = 31 * result + Short.hashCode(prefix);
	result = 31 * result + Short.hashCode(lineNum);
	return result;
    }

    /**
     * Returns the string representation of this phone number. The string consists
     * of twelve characters whose format is "XXX-YYY-ZZZZ", where XXX is the area
     * code, YYY is the prefix, and ZZZZ is the line number. Each of the capital
     * letters represents a single decimal digit.
     *
     * If any of the three parts of this phone number is too small to fill up its
     * field, the field is padded with leading zeros. For example, if the value of
     * the line number is 123, the last four characters of the string representation
     * will be "0123".
     */
    @Override
    public String toString() {
	return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    // Clone method for class with no references to mutable state (Page 59)
    @Override
    public PhoneNumber clone() {
	try {
	    return (PhoneNumber) super.clone();
	} catch (final CloneNotSupportedException e) {
	    throw new AssertionError(); // Can't happen
	}
    }

    public static void main(final String[] args) {
	final PhoneNumber pn = new PhoneNumber(707, 867, 5309);
	final Map<PhoneNumber, String> m = new HashMap<>();
	m.put(pn, "Jenny");
	System.out.println(m.get(pn.clone()));
    }
}
