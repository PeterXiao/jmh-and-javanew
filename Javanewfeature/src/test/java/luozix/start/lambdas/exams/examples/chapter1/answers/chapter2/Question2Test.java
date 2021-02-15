package luozix.start.lambdas.exams.examples.chapter1.answers.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter2.Question2;

public class Question2Test {

    @Test
    public void exampleInB() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String formatted = Question2.formatter.get().getFormat().format(cal.getTime());
        assertEquals("01-Jan-1970", formatted);
    }

}
