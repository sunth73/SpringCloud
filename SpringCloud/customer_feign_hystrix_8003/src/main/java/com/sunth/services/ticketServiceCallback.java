package com.sunth.services;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Sunth
 * @DateTime 2018-08-29 21:39
 * 描述
 */
@Component
public class ticketServiceCallback implements FallbackFactory<ticketService>{
    @Override
    public ticketService create(Throwable throwable) {
        return new ticketService(){
            @Override
            public String SaleTicket() {
                return "该电影已经下线，请使用爱奇艺观看";
            }
        };
    }
}
