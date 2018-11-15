package com.lr.cloudadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@MapperScan("com.lr.cloudadmin.dao")
@SpringBootApplication
public class CloudAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAdminApplication.class, args);
    }
}
