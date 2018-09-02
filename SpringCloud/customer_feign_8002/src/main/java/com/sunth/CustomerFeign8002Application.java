package com.sunth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.sunth.services")
//@ComponentScan(basePackageClasses = CustomerFeign8002Application.class)
//@ComponentScan("com.sunth")
public class CustomerFeign8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFeign8002Application.class, args);
    }
}
