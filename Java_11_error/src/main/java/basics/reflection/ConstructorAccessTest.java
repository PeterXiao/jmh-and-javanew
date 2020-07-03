/**
 *
 */
package basics.reflection;

import com.esotericsoftware.reflectasm.ConstructorAccess;

import junit.framework.TestCase;

public class ConstructorAccessTest extends TestCase {
	public void testNewInstance() {
		final ConstructorAccess<SomeClass> access = ConstructorAccess.get(SomeClass.class);
		final SomeClass someObject = new SomeClass();
		assertEquals(someObject, access.newInstance());
		assertEquals(someObject, access.newInstance());
		assertEquals(someObject, access.newInstance());
	}

	public void testPackagePrivateNewInstance() {
		final ConstructorAccess<PackagePrivateClass> access = ConstructorAccess.get(PackagePrivateClass.class);
		final PackagePrivateClass someObject = new PackagePrivateClass();
		assertEquals(someObject, access.newInstance());
		assertEquals(someObject, access.newInstance());
		assertEquals(someObject, access.newInstance());
	}

	public void testHasArgumentConstructor() {
		try {
			ConstructorAccess.get(HasArgumentConstructor.class);
			assertTrue(false);
		} catch (final RuntimeException re) {
			System.out.println("Expected exception happened: " + re);
		} catch (final Throwable t) {
			System.out.println("Unexpected exception happened: " + t);
			assertTrue(false);
		}
	}

	public void testHasPrivateConstructor() {
		try {
			ConstructorAccess.get(HasPrivateConstructor.class);
			assertTrue(false);
		} catch (final RuntimeException re) {
			System.out.println("Expected exception happened: " + re);
		} catch (final Throwable t) {
			System.out.println("Unexpected exception happened: " + t);
			assertTrue(false);
		}
	}

	public void testHasProtectedConstructor() {
		try {
			final ConstructorAccess<HasProtectedConstructor> access = ConstructorAccess
					.get(HasProtectedConstructor.class);
			final HasProtectedConstructor newInstance = access.newInstance();
			assertEquals("cow", newInstance.getMoo());
		} catch (final Throwable t) {
			System.out.println("Unexpected exception happened: " + t);
			assertTrue(false);
		}
	}

	public void testHasPackageProtectedConstructor() {
		try {
			final ConstructorAccess<HasPackageProtectedConstructor> access = ConstructorAccess
					.get(HasPackageProtectedConstructor.class);
			final HasPackageProtectedConstructor newInstance = access.newInstance();
			assertEquals("cow", newInstance.getMoo());
		} catch (final Throwable t) {
			System.out.println("Unexpected exception happened: " + t);
			assertTrue(false);
		}
	}

	public void testHasPublicConstructor() {
		try {
			final ConstructorAccess<HasPublicConstructor> access = ConstructorAccess.get(HasPublicConstructor.class);
			final HasPublicConstructor newInstance = access.newInstance();
			assertEquals("cow", newInstance.getMoo());
		} catch (final Throwable t) {
			System.out.println("Unexpected exception happened: " + t);
			assertTrue(false);
		}
	}

	static class PackagePrivateClass {
		public String name;
		public int intValue;
		protected float test1;
		Float test2;
		private String test3;

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final PackagePrivateClass other = (PackagePrivateClass) obj;
			if (intValue != other.intValue) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			if (Float.floatToIntBits(test1) != Float.floatToIntBits(other.test1)) {
				return false;
			}
			if (test2 == null) {
				if (other.test2 != null) {
					return false;
				}
			} else if (!test2.equals(other.test2)) {
				return false;
			}
			if (test3 == null) {
				if (other.test3 != null) {
					return false;
				}
			} else if (!test3.equals(other.test3)) {
				return false;
			}
			return true;
		}
	}

	static public class SomeClass {
		public String name;
		public int intValue;
		protected float test1;
		Float test2;
		private String test3;

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final SomeClass other = (SomeClass) obj;
			if (intValue != other.intValue) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			if (Float.floatToIntBits(test1) != Float.floatToIntBits(other.test1)) {
				return false;
			}
			if (test2 == null) {
				if (other.test2 != null) {
					return false;
				}
			} else if (!test2.equals(other.test2)) {
				return false;
			}
			if (test3 == null) {
				if (other.test3 != null) {
					return false;
				}
			} else if (!test3.equals(other.test3)) {
				return false;
			}
			return true;
		}
	}

	static public class HasArgumentConstructor {
		public String moo;

		public HasArgumentConstructor(String moo) {
			this.moo = moo;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final HasArgumentConstructor other = (HasArgumentConstructor) obj;
			if (moo == null) {
				if (other.moo != null) {
					return false;
				}
			} else if (!moo.equals(other.moo)) {
				return false;
			}
			return true;
		}

		public String getMoo() {
			return moo;
		}
	}

	static public class HasPrivateConstructor extends HasArgumentConstructor {
		private HasPrivateConstructor() {
			super("cow");
		}
	}

	static public class HasProtectedConstructor extends HasPrivateConstructor {
		@SuppressWarnings("synthetic-access")
		protected HasProtectedConstructor() {
			super();
		}
	}

	static public class HasPackageProtectedConstructor extends HasProtectedConstructor {
		HasPackageProtectedConstructor() {
			super();
		}
	}

	static public class HasPublicConstructor extends HasPackageProtectedConstructor {
		HasPublicConstructor() {
			super();
		}
	}
}
