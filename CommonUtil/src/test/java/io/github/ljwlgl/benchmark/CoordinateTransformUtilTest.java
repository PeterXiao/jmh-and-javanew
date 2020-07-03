package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.ljwlgl.util.CoordinateTransformUtil;

public class CoordinateTransformUtilTest {

    @Test
    public void testTransformlat() {
        assertEquals(0.0, CoordinateTransformUtil.transformlat(0.0, 0.0), 0.0001);
    }

    @Test
    public void testTransformlng() {
        assertEquals(0.0, CoordinateTransformUtil.transformlng(0.0, 0.0), 0.0001);
    }

    @Test
    public void testOut_of_china() {
        assertTrue(CoordinateTransformUtil.out_of_china(0.0, 0.0));
    }
}
