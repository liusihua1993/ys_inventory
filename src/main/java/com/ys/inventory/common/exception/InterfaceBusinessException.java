package com.ys.inventory.common.exception;

/**
 * 接口调用业务异常
 * @author wyh
 */
public class InterfaceBusinessException extends RuntimeException {
    private String code;

    public InterfaceBusinessException(String message) {
        super(message);
    }

    public InterfaceBusinessException(String code,String message) {
        super(message);
        this.code = code;
    }

    public InterfaceBusinessException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
