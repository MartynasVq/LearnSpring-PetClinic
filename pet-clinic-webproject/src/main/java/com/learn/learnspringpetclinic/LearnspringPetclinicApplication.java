package com.learn.learnspringpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LearnspringPetclinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnspringPetclinicApplication.class, args);
    }

}
