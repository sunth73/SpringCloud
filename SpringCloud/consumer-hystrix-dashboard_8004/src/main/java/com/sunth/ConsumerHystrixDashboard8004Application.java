package com.sunth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard8004Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard8004Application.class, args);
    }
}
