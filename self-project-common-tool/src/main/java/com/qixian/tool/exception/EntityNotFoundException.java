package com.qixian.tool.exception;

import com.qixian.tool.entity.IError;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Xing
 * @Date 2021/2/3-17:37
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EntityNotFoundException extends RuntimeException {

    private int code;

    private String msg;

    public EntityNotFoundException(IError error) {
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public EntityNotFoundException(IError error, String msg) {
        this.code = error.getCode();
        this.msg = msg;
    }

}
