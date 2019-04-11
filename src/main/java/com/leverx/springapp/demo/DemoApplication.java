package com.leverx.springapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@PropertySource("classpath:application.properties")
public class DemoApplication {
    @Value("${keyword.first}")
    private String KEYWORD_ONE;
    @Value("${keyword.second}")
    private String KEYWORD_TWO;

    @RequestMapping("/")
    public String home(){
      return KEYWORD_ONE+KEYWORD_TWO;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
