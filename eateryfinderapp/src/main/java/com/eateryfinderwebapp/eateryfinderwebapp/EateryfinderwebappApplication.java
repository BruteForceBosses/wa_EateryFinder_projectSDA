package com.eateryfinderwebapp.eateryfinderwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EateryfinderwebappApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(EateryfinderwebappApplication.class, args);
    }

}
