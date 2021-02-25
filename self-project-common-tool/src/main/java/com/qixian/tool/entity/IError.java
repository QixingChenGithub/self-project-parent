package com.qixian.tool.entity;


import com.qixian.tool.exception.EntityNotFoundException;
import com.qixian.tool.exception.IllegalParamException;

import java.util.Collection;

/**
 * @Author Xing
 * @Date 2021/2/4-11:40
 * @Version 1.0
 */
public interface IError {

    /***
     *
     * @return 状态码
     */
    int getCode();

    /***
     *
     * @return 返回信息
     */
    String getMsg();

    /**
     * @descr: 判断对象是否为null
     */
    default void ifNull(Object object, String msg) {
        if (null == object) {
            throw new EntityNotFoundException(this, msg);
        }
    }

    /**
     * @descr: 判断对象是否为null
     */
    default void ifNull(Object object) {
        ifNull(object, this.getMsg());
    }

    /**
     * @descr: 判断字符串是否为空
     */
    default void ifEmpty(String str, String msg) {
        if(null == str || "".equals(str.trim())) {
            throw new IllegalParamException(this, msg);
        }
    }

    /**
     * @descr: 判断字符串是否为空
     */
    default void ifEmpty(String str) {
        ifEmpty(str, this.getMsg());
    }

    /**
     * @descr: 判断集合是否为null或者空
     */
    default void ifEmpty(Collection<?> collection, String msg) {
        if(null==collection || collection.size()==0) {
            throw new EntityNotFoundException(this, msg);
        }
    }

    /**
     * @descr: 判断集合是否为null或者空
     */
    default void ifEmpty(Collection<?> collection) {
        ifEmpty(collection, this.getMsg());
    }
}