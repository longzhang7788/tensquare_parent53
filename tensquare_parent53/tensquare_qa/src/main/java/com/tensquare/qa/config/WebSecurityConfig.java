package com.tensquare.qa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限
         * 需要权限部分分向部分:第一部分是拦截的路径，第二部分是访问该路径需要的权限。
         * antMatchers表示拦截什么路径，/**表示所有，permitAll表示任何权限都可以访问。
         * anyRequest表示任何的请求，authenticated认证后才能访问
         * .and().csrf().disable();固定写法，表示使csrf拦截失效。
         * csrf是一种网络攻击技术，也就是springsecurity安全级别设置的有点偏高，使用这个后，
         * springsecurity会认为除了所有我自己内部请求外，都被认为是在攻击我
         */
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
