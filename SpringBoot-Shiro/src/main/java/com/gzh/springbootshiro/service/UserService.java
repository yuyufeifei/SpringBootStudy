package com.gzh.springbootshiro.service;

import com.gzh.springbootshiro.entity.User;

/**
 * @author GZH
 * @date 2021-12-10
 */
public interface UserService {


    User getUserByName(String name);

}
