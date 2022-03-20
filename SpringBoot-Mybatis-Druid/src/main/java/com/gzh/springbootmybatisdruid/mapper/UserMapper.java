package com.gzh.springbootmybatisdruid.mapper;

import com.gzh.springbootmybatisdruid.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GZH
 * @date 2021-12-07
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
