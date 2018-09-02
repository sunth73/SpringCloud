package com.sunth.serviceImpl;

import com.sunth.service.ticketService;
import org.springframework.stereotype.Service;

/**
 * @author Sunth
 * @DateTime 2018-08-26 22:43
 * 描述
 */
@Service
public class ticketServiceImpl implements ticketService {
    @Override
    public String SaleTicket() {
        return "《2B常老师第二部》";
    }
}
