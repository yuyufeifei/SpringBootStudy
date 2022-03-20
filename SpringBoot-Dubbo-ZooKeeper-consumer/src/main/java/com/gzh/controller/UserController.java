package com.gzh.controller;

import com.gzh.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GZH
 * @date 2021-12-14
 */
@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getTicket")
    public Object getTicket() {
        userService.bugTicket();
        return "OK";
    }
}
