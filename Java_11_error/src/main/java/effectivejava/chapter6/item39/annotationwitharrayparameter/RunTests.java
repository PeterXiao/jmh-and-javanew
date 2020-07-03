package effectivejava.chapter6.item39.annotationwitharrayparameter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import effectivejava.chapter6.item39.markerannotation.Test;

// Program to process marker annotations and annotations with array parameter (Page 185)
public class RunTests {
    public static void main(final String[] args) throws Exception {
	int tests = 0;
	int passed = 0;
	final Class<?> testClass = Class.forName(args[0]);
	for (final Method m : testClass.getDeclaredMethods()) {
	    if (m.isAnnotationPresent(Test.class)) {
		tests++;
		try {
		    m.invoke(null);
		    passed++;
		} catch (final InvocationTargetException wrappedExc) {
		    final Throwable exc = wrappedExc.getCause();
		    System.out.println(m + " failed: " + exc);
		} catch (final Exception exc) {
		    System.out.println("Invalid @Test: " + m);
		}
	    }

	    // Code to process annotations with array parameter (Page 185)
	    if (m.isAnnotationPresent(ExceptionTest.class)) {
		tests++;
		try {
		    m.invoke(null);
		    System.out.printf("Test %s failed: no exception%n", m);
		} catch (final Throwable wrappedExc) {
		    final Throwable exc = wrappedExc.getCause();
		    final int oldPassed = passed;
		    final Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
		    for (final Class<? extends Throwable> excType : excTypes) {
			if (excType.isInstance(exc)) {
			    passed++;
			    break;
			}
		    }
		    if (passed == oldPassed) {
			System.out.printf("Test %s failed: %s %n", m, exc);
		    }
		}
	    }
	}
	System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
