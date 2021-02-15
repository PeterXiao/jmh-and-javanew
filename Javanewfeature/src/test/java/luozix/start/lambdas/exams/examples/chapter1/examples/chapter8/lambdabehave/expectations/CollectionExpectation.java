package luozix.start.lambdas.exams.examples.chapter1.examples.chapter8.lambdabehave.expectations;

import static junit.framework.Assert.assertTrue;

import java.util.Collection;

public class CollectionExpectation extends BoundExpectation {

    private final Collection<?> objectUnderTest;

    public CollectionExpectation(Collection<?> objectUnderTest) {
        super(objectUnderTest);
        this.objectUnderTest = objectUnderTest;
    }

    public void isEmpty() {
        assertTrue(objectUnderTest.isEmpty());
    }

}
