package com.sunth;

import com.netflix.zuul.ZuulFilter;
import com.sunth.ZuulFilter.TestPostFilter;
import com.sunth.callBack.CallBackforZuul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class Zuul9527Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul9527Application.class, args);
    }
    @Bean
    public ZuulFilter myZuulFilter(){
        return new TestPostFilter();
    }

}
