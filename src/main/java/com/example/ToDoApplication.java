package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication {

    public static void main(String[] args) {
        System.out.println("DATABASE_URL=" + System.getenv("DATABASE_URL1"));
        System.out.println("DATABASE_USERNAME=" + System.getenv("DATABASE_USERNAME1"));
		System.out.println("DATABASE_PASSWORD=" + System.getenv("DATABASE_PASSWORD1"));
        SpringApplication.run(ToDoApplication.class, args);
    }
}

