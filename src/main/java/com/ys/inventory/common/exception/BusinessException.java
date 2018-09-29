package com.ys.inventory.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 * @author wyh
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private String code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
