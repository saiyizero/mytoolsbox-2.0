package com.virugan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class GetrTestApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GetrTestApplication.class, args);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
