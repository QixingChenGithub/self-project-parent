package com.qixian.tool.exception;

import com.qixian.tool.entity.IError;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Xing
 * @Date 2021/2/4-9:19
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IllegalParamException extends RuntimeException {

    private int code;

    private String msg;

    public IllegalParamException(IError error) {
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public IllegalParamException(IError error, String msg) {
        this.code = error.getCode();
        this.msg = msg;
    }
}
