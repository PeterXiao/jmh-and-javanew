package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.ljwlgl.util.ProtobufUtil;
import io.github.ljwlgl.util.CaptchaUtil;

public class ProtobufUtilTest {

    @Test
    public void testSerialize() {
        // Setup
        // final T obj = null;

        // Run the test
        // final byte[] result = ProtobufUtil.serialize(obj);

        // Verify the results
        // assertArrayEquals("content".getBytes(), result);
    }

    @Test
    public void testSerializeList() {
        // Setup
        // final List<T> objList = Arrays.asList();

        // Run the test
        // final byte[] result = ProtobufUtil.serializeList(objList);

        // Verify the results
        // assertArrayEquals("content".getBytes(), result);
    }

    @Test
    public void testUnSerialize() {
        // Setup

        // Run the test
        // final T result = ProtobufUtil.unSerialize("content".getBytes(), Object.class);

        // Verify the results
    }

    @Test
    public void testUnSerializeSet() {
        // Setup

        // Run the test
        // final Set<T> result = ProtobufUtil.unSerializeSet("content".getBytes(), Object.class);

        // Verify the results
    }

    @Test
    public void testUnSerializeList() {
        // Setup

        // Run the test
        // final List<T> result = ProtobufUtil.unSerializeList("content".getBytes(), Object.class);

        // Verify the results
    }

    @Test
    public void testIsNullOrEmpty() {
        assertTrue(ProtobufUtil.isNullOrEmpty("obj"));
    }

    class UserInfo {

        private String userName;
        private Integer uid;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getUid() {
            return uid;
        }

        public void setUid(Integer uid) {
            this.uid = uid;
        }
    }
}
