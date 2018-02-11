/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 *http://www.baeldung.com/spring-security-basic-authentication
 * @author Michel
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private AuthenticationEntryPoint aep;

    @Override
    protected void configure(HttpSecurity auth) throws Exception {
        auth.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(aep);      
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password("123")
                .roles("ADMIN");
    }
    
    
    
    
}
