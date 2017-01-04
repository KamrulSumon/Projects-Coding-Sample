package com.newconstructs.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@ComponentScan(basePackages = {
        "com.newconstructs.controller",        //
        "com.newconstructs.service",           //
        "com.newconstructs.repository"
})
@EnableAutoConfiguration
@Import(WebMvcConfig.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
