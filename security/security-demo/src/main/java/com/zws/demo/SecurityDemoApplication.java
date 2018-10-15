package com.zws.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zws
 * @email 2848392861@qq.com
 * date 2018/9/28
 */
@SpringBootApplication
@MapperScan("com.zws.demo.mapper")
@EnableSwagger2
public class SecurityDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class,args);
    }
}