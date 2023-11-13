package com.xeriou.plugins.pluginm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.xeriou.plugins.pluginm"})
public class PluginMApplication {
    public static void main(String[] args) {
        SpringApplication.run(PluginMApplication.class, args);
    }
}
