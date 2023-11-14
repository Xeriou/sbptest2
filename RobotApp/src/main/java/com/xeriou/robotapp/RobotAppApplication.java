package com.xeriou.robotapp;

import org.laxture.spring.util.ApplicationContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.xeriou")
public class RobotAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotAppApplication.class, args);
    }

    @Bean
    public ApplicationContextAware multiApplicationContextProviderRegister() {
        System.out.println("Registering ApplicationContextProvider ? ...");
        return ApplicationContextProvider::registerApplicationContext;
    }

}
