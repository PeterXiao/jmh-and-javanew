package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;

import org.junit.Test;

import io.github.ljwlgl.util.NetworkUtil;

public class NetworkUtilTest {

    @Test
    public void testGetLocalInetAddress() throws Exception {
        // Setup
        final InetAddress expectedResult = InetAddress.getByName("host");

        // Run the test
        final InetAddress result = NetworkUtil.getLocalInetAddress();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetLocalHostAddress() {
        assertEquals("result", NetworkUtil.getLocalHostAddress());
    }

    @Test
    public void testGetLocalHostName() {
        assertEquals("result", NetworkUtil.getLocalHostName());
    }
}
