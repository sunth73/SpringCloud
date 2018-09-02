package com.sunth;

import com.sunth.Config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import javax.naming.Name;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
//@RibbonClient(name="PROVIDER",configuration = MyConfig.class)
public class Customer8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Customer8001Application.class, args);
    }
}
