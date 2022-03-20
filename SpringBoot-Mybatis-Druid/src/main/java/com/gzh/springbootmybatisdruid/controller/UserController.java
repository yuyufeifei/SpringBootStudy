package com.gzh.springbootmybatisdruid.controller;

import com.gzh.springbootmybatisdruid.entity.User;
import com.gzh.springbootmybatisdruid.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GZH
 * @date 2021-12-07
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        System.out.println(userList);
        return userList;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = userMapper.getUserById(id);
        System.out.println(user);
        return user;
    }

    //仅供测试
    @GetMapping("/addUser")
    public Integer addUser() {
        int result = userMapper.addUser(new User(0, "测试增加", "123", "123@qq.com", ""));
        System.out.println(result);
        return result;
    }

    //仅供测试
    @GetMapping("/updateUser")
    public Integer updateUser() {
        int result = userMapper.updateUser(new User(8, "士大夫2", "323r", "4234@163.com", ""));
        System.out.println(result);
        return result;
    }

    //仅供测试
    @GetMapping("/deleteUser")
    public Integer deleteUser() {
        int result = userMapper.deleteUser(9);
        System.out.println(result);
        return result;
    }

}
