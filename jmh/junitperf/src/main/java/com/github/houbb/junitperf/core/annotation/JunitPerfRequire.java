package com.github.houbb.junitperf.core.annotation;

import com.github.houbb.junitperf.constant.VersionConstant;
import org.apiguardian.api.API;

import java.lang.annotation.*;

/**
 * 对于性能测试来说，所有的要求都应该是消耗时间越低越好。
 * 这里基本是一些数学的统计概念：最大值、最小值、平均数等等。
 * 这些东西都是一个阈值的概念，可以进行抽象吗？
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Documented
@API(status = API.Status.MAINTAINED, since = VersionConstant.V2_0_0)
public @interface JunitPerfRequire {

    /**
     * 最佳的运行耗时(单位：毫秒)
     * 1. 最快的运行耗时如果高于这个值，则视为失败
     * @return 最佳的运行耗时
     */
    float min() default -1L;

    /**
     * 最坏的运行耗时(单位：毫秒)
     * 1. 最坏的运行耗时如果高于这个值，则视为失败
     * @return 最坏的运行耗时
     */
    float max() default -1L;

    /**
     * 平均的运行耗时(单位：毫秒)
     * 1. 平均的运行耗时如果高于这个值，则视为失败
     * @return 平均的运行耗时
     */
    float average() default -1L;

    /**
     * 对于执行耗时的限定
     *
     * percentiles={"20:220", "30:250"}
     * 20% 的数据执行耗时不得超过 220ms;
     * 30% 的数据执行耗时不得超过 250ms;
     * @return 执行耗时界定的数组
     */
    String[] percentiles() default {};

    /**
     * 每秒的最小执行次数
     * 1. 如果低于这个最小执行次数，则视为失败
     * @return 每秒的最小执行次数
     */
    int timesPerSecond() default 0;

}
