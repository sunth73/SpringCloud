package com.sunth.Config;

import com.netflix.loadbalancer.IRule;
import com.sunth.RIbbonRule.myRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sunth
 * @DateTime 2018-08-26 22:59
 * 描述
 */
@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
      return new RestTemplate();
  }
    @Bean
  public IRule myRules(){
        return new myRule();
  }
}
