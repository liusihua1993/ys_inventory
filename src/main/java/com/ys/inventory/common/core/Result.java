package com.ys.inventory.common.core;

import lombok.Data;

/**
 * @param <T> 请求响应结构体
 * @author wyh
 */
@Data
public final class Result<T> {

    /**
     * 响应状态码
     * <p>
     * 0表示成功
     */
    private int code;

    /**
     * 响应提示信息
     */
    private String msg;

    /**
     * 开发者友好的异常信息
     */
    private String dev;

    /**
     * 响应时间戳
     */
    private long time = System.currentTimeMillis();

    /**
     * 响应内容
     */
    private T data;

    /**
     * 私有构造方法
     */
    private Result() {
    }

    /**
     * 成功的响应结果
     *
     * @param <T>     响应的内容类型
     * @param content 响应内容
     * @return 响应结果
     */
    public static <T> Result ok(T content) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(content);
        return result;
    }

    /**
     * 创建无内容的正常的响应
     *
     * @return 响应结果
     */
    public static Result ok() {
        Result result = new Result<>();
        result.setCode(0);
        return result;
    }

    public static <T>Result ok(int code, T content){
        Result result = new Result<>();
        result.setCode(code);
        result.setData(content);
        result.setMsg("SUCCESS");
        return result;
    }

    public static Result ok(int code){
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg("SUCCESS");
        return result;
    }

    /**
     * 错误的响应结果
     *
     * @param msg 错误消息
     * @return 响应结果
     */
    public static Result error(int code, String msg) {
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(int code, String msg, Throwable ex) {
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setDev(ex.getMessage());
        return result;
    }
}
