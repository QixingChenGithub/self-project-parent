package com.qixian.tool.export;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xing
 * @Date 2021/2/8-9:51
 * @Version 1.0
 */
public class ExportEntity {

    private static final Map<Integer, String> USER_EXPORT = new HashMap<Integer, String>(20) {
        {
            put(0, "用户");
            put(1, "用户姓名");
            put(2, "性别");
            put(3, "电话");
            put(4, "邮箱");
        }
    };
}
