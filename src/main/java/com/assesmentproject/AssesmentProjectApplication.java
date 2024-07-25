package com.assesmentproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AssesmentProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssesmentProjectApplication.class, args);
    }
}
