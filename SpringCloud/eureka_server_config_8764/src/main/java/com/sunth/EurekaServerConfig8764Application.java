package com.sunth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerConfig8764Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerConfig8764Application.class, args);
    }
}
