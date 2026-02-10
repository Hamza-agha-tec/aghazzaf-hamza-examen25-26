package com.aghatec.route_service.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.prams")
public class GlobalConfig {
    private int c1;
    private int c2;
}