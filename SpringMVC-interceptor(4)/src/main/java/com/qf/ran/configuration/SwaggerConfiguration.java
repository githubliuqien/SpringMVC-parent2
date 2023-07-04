package com.qf.ran.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 */
@Configuration
//扫描包，支持 swagger 注解
@Component("com.qf.ran")
@EnableSwagger2
public class SwaggerConfiguration {
    //创建 api初始化对象的方法
    private ApiInfo apiInfo(){
        //存放作者信息对象
        Contact contact = new Contact("Ran",
                "http://www.baidu.com(作者联系地址)", "j_daran@qq.com(作者的email)");
        //进行接口文档的初始化
        ApiInfo apiInfo = new ApiInfoBuilder()
                .license("swagger(小标题)")
                .title("SpringMVC(大标题)")
                .description("用户模块的测试(说明)")
                .contact(contact)
                .version("版本号").build();
        return apiInfo;
    }

    @Bean
    public Docket createAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
