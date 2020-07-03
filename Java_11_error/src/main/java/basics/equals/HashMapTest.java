/**
 *
 */
package basics.equals;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Office
 *
 */
public class HashMapTest {
	private Integer a;

	public HashMapTest(int a) {
		this.a = a;
	}

	public static void main(String[] args) {

		final Map<HashMapTest, Integer> map = new HashMap<>();
		final HashMapTest instance = new HashMapTest(1);
		System.out.println("instance.hashcode:" + instance.hashCode());
		final HashMapTest newInstance = new HashMapTest(1);
		System.out.println("newInstance.hashcode:" + newInstance.hashCode());
		map.put(instance, 1);
		map.put(newInstance, 2);
		final Integer value = map.get(instance);
		System.out.println("instance value:" + value);
		final Integer value1 = map.get(newInstance);
		System.out.println("newInstance value:" + value1);

	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof HashMapTest)) {
			return false;
		} else {
			final HashMapTest other = (HashMapTest) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				final Integer this$data = getA();
				final Integer other$data = other.getA();
				if (this$data == null) {
					if (other$data != null) {
						return false;
					}
				} else if (!this$data.equals(other$data)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof HashMapTest;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getA() {
		return a;
	}

	@Override
	public int hashCode() {
		final boolean PRIME = true;
		final byte result = 1;
		final Integer $data = getA();
		final int result1 = result * 59 + ($data == null ? 43 : $data.hashCode());
		return result1;
	}
}
