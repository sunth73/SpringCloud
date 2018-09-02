package com.sunth.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sunth
 * @DateTime 2018-08-26 22:40
 * 描述
 */
@FeignClient(value = "PROVIDER",fallbackFactory = ticketServiceCallback.class)
public interface ticketService {
    @RequestMapping("/sale")
    public String SaleTicket();
}
