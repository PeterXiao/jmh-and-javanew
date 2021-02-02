package com.github.houbb.junitperf.support.exception;

import org.apiguardian.api.API;

/**
 * 性能测试运行时异常
 * 要求：本项目中所有运行时异常统一使用本类进行处理
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/01/11
 */
@API(status = API.Status.MAINTAINED)
public class JunitPerfRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 7067503448534895751L;

    public JunitPerfRuntimeException() {
    }

    public JunitPerfRuntimeException(String message) {
        super(message);
    }

    public JunitPerfRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JunitPerfRuntimeException(Throwable cause) {
        super(cause);
    }

    public JunitPerfRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
