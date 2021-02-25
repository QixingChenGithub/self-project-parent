package com.qixian.tool.util;

import com.qixian.tool.entity.IError;
import lombok.Data;

/**
 * @Author Xing
 * @Date 2021/2/4-9:37
 * @Version 1.0
 */
@Data
public class BaseResult<T> {

    private Integer code;

    private String msg;

    private T data;

    private BaseResult() {

    }

    private BaseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private BaseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static BaseResult<?> success() {
        return success(null);
    }

    public static <T> BaseResult<T> success(String msg, T data) {
        return new BaseResult<>(200, msg, data);
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(200, "调用成功", data);
    }

    /**
     * @descr: 调用失败，返回Error信息
     */
    public static <T> BaseResult<T> failed(IError error) {
        return failed(error, error.getMsg());
    }

    /**
     * @descr: 调用失败，返回自定义信息
     */
    public static <T> BaseResult<T> failed(IError error, String msg) {
        return failed(error, msg, null);
    }

    /**
     * @descr: 调用失败，返回自定义信息
     */
    public static <T> BaseResult<T> failed(IError error, String msg, T data) {
        return new BaseResult<>(error.getCode(), msg, data);
    }
}
