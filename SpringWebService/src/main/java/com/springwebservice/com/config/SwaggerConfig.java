//package com.springwebservice.com.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig extends WebMvcConfigurationSupport {
//
//    @Bean
//    public Docket productionApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select().apis(RequestHandlerSelectors.basePackage("com"))
//                .paths(PathSelectors.regex("/.*"))
//                .build().apiInfo(metaData());
//    }
//
////    @Override
////    protected void addResourceHandlers(ResourceHandlerRegistry registry){
////        registry.addResourceHandler("swagger-ui.html")
////                .addResourceLocations("classpath:/META-INF/resources");
////        registry.addResourceHandler("/webjars/**")
////                .addResourceLocations("classpath:/META-INF/resources/webjars/");
////    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry
//                .addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    private ApiInfo metaData(){
//        return new ApiInfoBuilder()
//                .title("Spring Boot PERSON REST API")
//                .description("\"Spring Boot REST API ABCD Application")
//                .version("1.0.0")
//                .license("Apache License Version 2.0")
//                .license("https://apache.org/license/LICENSE-2.0\"")
//                .contact(new Contact("Tanzania GOV", "https://tanzania.go.tz", "tanzania@gmail.com"))
//                .build();
//    }
//
//}
