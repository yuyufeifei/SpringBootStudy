package com.gzh.springbootshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author GZH
 * @date 2021-12-10
 */
@Configuration
public class ShiroConfig {

    //3. ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        // anon：无需认证
        // authc：必须认证才能访问
        // user；必须拥有“记住我”功能才能用
        // perms：拥有对某个资源的权限才能访问
        // role：拥有某个角色权限才能访问
        Map<String, String> filterMap = new LinkedHashMap<>();
        //授权
        filterMap.put("/level1/1", "perms[user:level1-1]");
        filterMap.put("/level2/1", "perms[user:level2-1]");
        //拦截
        filterMap.put("/level1/*", "authc");
        filterMap.put("/level2/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    //2. DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getUserRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //1. 创建realm对象，需要自定义类
    @Bean
    public UserRealm getUserRealm() {
        return new UserRealm();
    }

    //整合
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
