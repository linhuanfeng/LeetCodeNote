package com.example.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }

    @Bean
    public HelloServer helloServer(){
        return new HelloServer();
    }

    @Bean
    public HelloClient helloClient() throws InterruptedException {
        return new HelloClient();
    }
}
