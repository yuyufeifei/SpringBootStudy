package com.gzh.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GZH
 * @date 2021-12-09
 */
@Controller
public class AdminController {
    @RequestMapping(value = {"/","/index","/relogin"})
    public String index(){
        return "index";
    }
    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") Integer id){
        return "views/level1/"+id;
    }
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") Integer id){
        return "views/level2/"+id;
    }
    @RequestMapping("toLogin")
    public String toLogin(){
        return "views/login";
    }
}
