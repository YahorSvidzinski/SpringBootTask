package com.leverx.springapp.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    @Value("${keyword.first}")
    private String keywordOne;

    @Value("${keyword.second}")
    private String keywordTwo;

    @RequestMapping("/")
    public String home() { 
        return keywordOne + keywordTwo;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
