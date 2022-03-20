package com.gzh.springbootswagger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GZH
 * @date 2021-12-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord {

    private int id;
    private String name;
    private String password;
}
