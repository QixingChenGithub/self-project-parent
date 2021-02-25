package com.qixian.tool.entity;

import com.qixian.tool.exception.IllegalParamException;
import lombok.AllArgsConstructor;

/**
 * @Author Xing
 * @Date 2021/2/4-13:41
 * @Version 1.0
 */
@AllArgsConstructor
public enum Errors implements IError {

    /***
     * 服务器异常
     */
    SERVER_ERROR(500, "服务器错误"),

    /***
     * 非法参数
     */
    ILLEGAL_ERROR(400, "参数非法"),

    /***
     * 空指针异常
     */
    NULL_ERROR(500, "空指针异常"),

    /***
     * 找不到对象
     */
    NOT_FOUND_ERROR(404, "对象不存在"),

    /***
     * 认证错误异常
     */
    UNAUTHORIZED_ERROR(401, "认证失败"),

    /***
     * 无权限
     */
    FORBIDDEN_ERROR(403, "无权限拒绝访问服务器"),

    /***
     * 对象已存在
     */
    EXISTS_ERROR(400, "对象已存在")
    ;



    private final int code;

    private final String msg;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    public void illegal(String msg) {
        throw new IllegalParamException(this, msg);
    }
}
