package com.training.client;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientMain {
    public static void main(String argv[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClientConfig.class);
        Runnable runnable = context.getBean(Runnable.class);
        runnable.run();
    }
}
