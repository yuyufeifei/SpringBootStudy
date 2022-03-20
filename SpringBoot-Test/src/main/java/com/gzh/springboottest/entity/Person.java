package com.gzh.springboottest.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GZH
 * @date 2021-12-01
 * 1. 在字段上使用@Value()
 * 2. 在类上使用@ConfigurationProperties(prefix = "xxx")，具体值在application.yml里指定
 * 3. 指定其他配置文件@PropertySource(value = "classpath:xxx.properties")，然后使用@Value("${xx}")
 */
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {

    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    @Email(message = "必须为email格式")
    private String email;
    private Map<String, Object> maps;
    //松散绑定
    private List<Object> hobbyList;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Object> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", maps=" + maps +
                ", hobbyList=" + hobbyList +
                ", dog=" + dog +
                '}';
    }
}
