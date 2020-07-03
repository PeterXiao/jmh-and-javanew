package io.github.ljwlgl.benchmark;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;

import org.junit.Test;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import io.github.ljwlgl.util.CaptchaUtil;

@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 1)
@State(Scope.Thread)
public class CaptchaUtilTest {

    @Test
    public void testGenCaptcha() {
        assertEquals("result", CaptchaUtil.genCaptcha(0));
    }

    @Test
    public void testGenCaptchaImg() {
        // Setup

        // Run the test
        final BufferedImage result = CaptchaUtil.genCaptchaImg("captcha");

        // Verify the results
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(CaptchaUtilTest.class.getSimpleName()).build();

        new Runner(opt).run();
    }
}
