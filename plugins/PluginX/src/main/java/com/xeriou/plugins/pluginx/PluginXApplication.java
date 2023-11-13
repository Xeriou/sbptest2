package com.xeriou.plugins.pluginx;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.xeriou.plugins.pluginx"})
public class PluginXApplication {
    public static void main(String[] args) {
        SpringApplication.run(PluginXApplication.class, args);
    }
}
