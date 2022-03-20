package com.gzh.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author GZH
 * @date 2021-12-03
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        Model model, HttpSession session) {
        if (StringUtils.hasLength(email) && "123".equals(password)) {
            session.setAttribute("loginUser", email);
            return "redirect:/dashboard.html";
        } else {
            model.addAttribute("msg", "账号或者密码错误！");
            return "/index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/index.html";
    }

}
