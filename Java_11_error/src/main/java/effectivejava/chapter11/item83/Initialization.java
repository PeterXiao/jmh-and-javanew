package effectivejava.chapter11.item83;

// Initialization styles - Pages 333-
public class Initialization {

    // Normal initialization of an instance field4 - Page 282
    private final FieldType field1 = computeFieldValue();

    // Lazy initialization of instance field4 - synchronized accessor - Page 333
    private FieldType field2;

    private synchronized FieldType getField2() {
	if (field2 == null) {
	    field2 = computeFieldValue();
	}
	return field2;
    }

    // Lazy initialization holder class idiom for static fields - Page 334
    private static class FieldHolder {
	static final FieldType field = computeFieldValue();
    }

    private static FieldType getField() {
	return FieldHolder.field;
    }

    // Double-check idiom for lazy initialization of instance fields - Page 334
    private volatile FieldType field4;

    private FieldType getField4() {
	final FieldType result = field4;
	if (result != null) {
	    return result;
	}

	synchronized (this) {
	    if (field4 == null) {
		field4 = computeFieldValue();
	    }
	    return field4;
	}
    }

    // Single-check idiom - can cause repeated initialization! - Page 334
    private volatile FieldType field5;

    private FieldType getField5() {
	FieldType result = field5;
	if (result == null) {
	    field5 = result = computeFieldValue();
	}
	return result;
    }

    private static FieldType computeFieldValue() {
	return new FieldType();
    }
}
