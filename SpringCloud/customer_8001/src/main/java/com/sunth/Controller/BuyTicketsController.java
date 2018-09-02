package com.sunth.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sunth
 * @DateTime 2018-08-26 23:00
 * 描述
 */
@RestController
public class BuyTicketsController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/buy")
    @HystrixCommand(fallbackMethod = "findError") //如果请求失败或超时
    public String buyTicket(){
        return restTemplate.getForObject("http://PROVIDER/sale",String.class);
    }
    public String findError(){
        return "哎呀，请求超时";
    }
}
