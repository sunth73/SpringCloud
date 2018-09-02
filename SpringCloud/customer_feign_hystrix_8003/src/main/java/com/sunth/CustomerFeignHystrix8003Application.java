package com.sunth;

import com.sunth.services.ticketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient
//@EnableFeignClients(basePackages = "com.sunth.services")
@EnableFeignClients(basePackageClasses = ticketService.class)
@SpringBootApplication
public class CustomerFeignHystrix8003Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFeignHystrix8003Application.class, args);
    }
}
