package com.gzh.springbootmybatisdruid.entity;

/**
 * @author GZH
 * @date 2021-12-07
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String permit;

    public User() {
    }

    public User(int id, String name, String password, String email, String perimt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.permit = perimt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", permit='" + permit + '\'' +
                '}';
    }
}
