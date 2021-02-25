package com.qixian.business.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author Xing
 * @Date 2021/2/8-15:11
 * @Version 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "data.export")
public class NacosConfig {

    Map<String, String> userMap;

    Map<String, String> deptMap;
}
