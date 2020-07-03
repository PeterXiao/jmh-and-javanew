package effectivejava.chapter3.item10;

// Class with a typical equals method (Page 48)
public final class PhoneNumber {
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

    // Remainder omitted - note that hashCode is REQUIRED (Item 11)!
}
