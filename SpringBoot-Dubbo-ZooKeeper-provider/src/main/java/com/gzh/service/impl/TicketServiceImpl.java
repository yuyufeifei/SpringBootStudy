package com.gzh.service.impl;

import com.gzh.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author GZH
 * @date 2021-12-14
 * 注解@DubboService会在项目启动后自动注册到注册中心
 */
@DubboService
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "GZH的ticket";
    }
}
