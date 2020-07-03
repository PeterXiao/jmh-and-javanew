package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.ljwlgl.util.GZIPUtil;

public class GZIPUtilTest {

    @Test
    public void testCompress() {
        assertArrayEquals("content".getBytes(), GZIPUtil.compress("str"));
    }

    @Test
    public void testCompress1() {
        assertArrayEquals("content".getBytes(), GZIPUtil.compress("str", "encoding"));
    }

    @Test
    public void testCompress2() {
        assertArrayEquals("content".getBytes(), GZIPUtil.compress("content".getBytes()));
    }

    @Test
    public void testUncompress() {
        assertArrayEquals("content".getBytes(), GZIPUtil.uncompress("content".getBytes()));
    }

    @Test
    public void testUncompress2Str() {
        assertEquals("result", GZIPUtil.uncompress2Str("content".getBytes()));
    }

    @Test
    public void testUncompress2Str1() {
        assertEquals("result", GZIPUtil.uncompress2Str("content".getBytes(), "encoding"));
    }
}
