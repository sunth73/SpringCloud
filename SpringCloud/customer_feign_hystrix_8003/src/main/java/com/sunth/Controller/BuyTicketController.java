package com.sunth.Controller;

import com.sunth.services.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunth
 * @DateTime 2018-08-27 21:22
 * 描述
 */
@RestController
public class BuyTicketController {
    @Autowired
    private ticketService service;
    @RequestMapping("/feign")
    public String BuyTicket(){
        return service.SaleTicket()+"购买成功";
    }
}
