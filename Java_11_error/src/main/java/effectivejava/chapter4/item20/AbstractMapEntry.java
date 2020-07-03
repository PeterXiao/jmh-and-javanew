package effectivejava.chapter4.item20;

import java.util.Map;
import java.util.Objects;

// Skeletal implementation class (Pages 102-3)
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    // Entries in a modifiable map must override this method
    @Override
    public V setValue(final V value) {
	throw new UnsupportedOperationException();
    }

    // Implements the general contract of Map.Entry.equals
    @Override
    public boolean equals(final Object o) {
	if (o == this) {
	    return true;
	}
	if (!(o instanceof Map.Entry)) {
	    return false;
	}
	final Map.Entry<?, ?> e = (Map.Entry) o;
	return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
    }

    // Implements the general contract of Map.Entry.hashCode
    @Override
    public int hashCode() {
	return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
	return getKey() + "=" + getValue();
    }
}
