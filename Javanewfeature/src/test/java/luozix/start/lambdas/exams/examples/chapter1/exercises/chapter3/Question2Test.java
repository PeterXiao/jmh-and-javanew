package luozix.start.lambdas.exams.examples.chapter1.exercises.chapter3;

import static luozix.start.lambdas.exams.exercises.chapter3.Question2.countBandMembersInternal;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.SampleData;

public class Question2Test {

    @Test
    public void internal() {
        assertEquals(4, countBandMembersInternal(Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }

}
