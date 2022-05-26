package com.example.workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WorkspaceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WorkspaceApplication.class, args);
        System.out.println(context.getClass() == org.springframework.context.annotation.AnnotationConfigApplicationContext.class);
    }

}
