package com.java_spring_tut.javademo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class JavademoApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(JavademoApplication.class, args);
// 	}

// }
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavademoApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavademoController.class, args);
    }
}
