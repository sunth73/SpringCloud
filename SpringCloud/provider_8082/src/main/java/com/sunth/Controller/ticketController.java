package com.sunth.Controller;

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
    @RequestMapping("/sale")
    public String SaleTicket(){
      return   ticketservice.SaleTicket();
    }
}
