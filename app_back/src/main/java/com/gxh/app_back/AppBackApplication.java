package com.gxh.app_back;

import com.gxh.app_back.intercept.LoginIntercept;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@MapperScan(basePackages = "com.gxh.app_back.mapper")
public class AppBackApplication  extends SpringBootServletInitializer implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AppBackApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppBackApplication.class);
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginIntercept())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/*.jpg") // 排除.jpg文件
//                .excludePathPatterns("/*.jpeg") // 排除.jpeg文件
//                .excludePathPatterns("/*.png") // 排除.png文件
//                .excludePathPatterns("/*.gif") // 排除.gif文件
//                .excludePathPatterns("/*.apk"); // 排除.gif文件
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }
}
