package com.xeriou.plugins.pluginx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@SpringBootApplication
//@SpringBootConfiguration
//@Import({DataSourceAutoConfiguration.class})
@SpringBootApplication
public class PluginXApplication {
    public static void main(String[] args) {
        SpringApplication.run(PluginXApplication.class, args);
    }


}
