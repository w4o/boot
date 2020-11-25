package com.github.w4o.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author frank
 * @date 2020/4/22
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String version;
}
