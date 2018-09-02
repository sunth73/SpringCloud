package com.sunth.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunth.service.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunth
 * @DateTime 2018-08-26 22:44
 * 描述
 */
@RestController
public class ticketController {
    @Autowired
    private ticketService ticketservice;

    int num=5;
    int sum=0;
    @RequestMapping("/sale")
    @HystrixCommand(fallbackMethod = "callback")
    public String SaleTicket(){
        String trick=ticketservice.SaleTicket();
        if(num>=sum){
            sum++;
        }else{
            throw new NullPointerException();
        }
        return   trick;
    }

    public String callback(){
        return ticketservice.SaleTicket()+"已经告罄，请明日在买";
    }
}
