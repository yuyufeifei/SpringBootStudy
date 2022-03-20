package com.gzh.springbootsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author GZH
 * @date 2021-12-08
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2");
        // ”/login“是security的默认地址，”/toLogin“是自定义的地址
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password");
        // 设置退出登录成功之后的页面为”/“；默认的退出登录为“/logout”，也可设置自定义的：logoutUrl("/logout")
        http.logout().logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies();
        // 关闭csrf，退出登录失败的原因。个人感觉退出登录时用post方式较好。
        http.csrf().disable();
        // 设置显示记住我功能，提交表单时此name为“remember”
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("gzh").password(new BCryptPasswordEncoder().encode("gzh123")).roles("vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("root123")).roles("vip1", "vip2");
    }
}
