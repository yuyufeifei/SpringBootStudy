package com.gzh.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author GZH
 * @date 2021-12-14
 */
@Service
public class UserService {

    //需将provider打包成jar，通过pom方式引入

    @DubboReference
    TicketService ticketService;

    public void bugTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心买到"+ticket);
    }

}
