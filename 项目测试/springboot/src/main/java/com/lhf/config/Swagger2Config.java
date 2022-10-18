package com.lhf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
public class Swagger2Config {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 指定扫描的包路径来定义指定要建立API的目录。
     * @return
     */
//    @Bean
//    public Docket coreApiConfig(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(adminApiInfo())
//                .groupName("adminApi")
//                .select()
//                //只显示admin下面的路径
//                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
//                .build();
//    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("尚融宝后台管理系统--api文档")
                .description("尚融宝后台管理系统接口描述")
                .version("1.0")
                .contact(new Contact("李燕茹","http://baidu.com","728831102@qq.com"))
                .build();
    }
}
