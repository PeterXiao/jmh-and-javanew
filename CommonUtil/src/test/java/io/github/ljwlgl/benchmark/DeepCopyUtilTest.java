package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.ljwlgl.util.DeepCopyUtil;

public class DeepCopyUtilTest {

    @Test
    public void testDepthClone() {
        assertEquals("result", DeepCopyUtil.depthClone("srcObj"));
    }

    @Test
    public void testListDepthClone() {}
}
