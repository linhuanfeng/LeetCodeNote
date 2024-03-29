package com.lhf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching //启动缓存
@EnableSwagger2
public class springbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(springbootApplication.class, args);
    }
}
