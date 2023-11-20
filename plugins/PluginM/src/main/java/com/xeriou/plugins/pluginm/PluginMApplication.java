package com.xeriou.plugins.pluginm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(WebProperties.class)
public class PluginMApplication {
    public static void main(String[] args) {
        SpringApplication.run(PluginMApplication.class, args);
    }
}
