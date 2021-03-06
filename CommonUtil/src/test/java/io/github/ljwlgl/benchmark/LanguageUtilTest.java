package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.ljwlgl.util.LanguageUtil;

public class LanguageUtilTest {

    @Test
    public void testIsOnlyLetter() {
        assertTrue(LanguageUtil.isOnlyLetter("str"));
    }

    @Test
    public void testIsLetter() {
        assertTrue(LanguageUtil.isLetter("str"));
    }

    @Test
    public void testIsChinese() {
        assertTrue(LanguageUtil.isChinese("str"));
    }

    @Test
    public void testIsLetterAndNumber() {
        assertTrue(LanguageUtil.isLetterAndNumber("str"));
    }

    @Test
    public void testIsChineseAndNumber() {
        assertTrue(LanguageUtil.isChineseAndNumber("str"));
    }

    @Test
    public void testIsKoreanAndNumber() {
        assertTrue(LanguageUtil.isKoreanAndNumber("str"));
    }

    @Test
    public void testIsJapanAndNumber() {
        assertTrue(LanguageUtil.isJapanAndNumber("str"));
    }
}
