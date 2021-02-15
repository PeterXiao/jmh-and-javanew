package luozix.start.lambdas.exams.examples.chapter1.examples.chapter4;


import org.junit.Test;

import junit.framework.Assert;
import luozix.start.lambdas.exams.examples.chapter4.MusicalCarriage;

public class MusicalCarriageTest {

    @Test
    public void rocksLikeACarriage() {
        Assert.assertEquals("... from side to side", new MusicalCarriage().rock());
    }

}
