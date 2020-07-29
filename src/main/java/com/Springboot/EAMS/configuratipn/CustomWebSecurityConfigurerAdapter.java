package com.Springboot.EAMS.configuratipn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    //@Autowired
    // private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("HR")
                .password("{noop}HRpassword")
                .roles("HR").and()
                .withUser("HRManager")
                .password("{noop}HRMpassword")
                .roles("HRMANAGER").and()
                .withUser("CEO")
                .password("{noop}CEOpassword")
                .roles("CEO");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               .csrf().disable()
                .authorizeRequests()
                .antMatchers("/department/**").hasAnyRole("HRMANAGER","HR")
                .antMatchers("/employee/**").hasRole("HR")
                .antMatchers("/organisation/**").hasAnyRole("CEO","HRMANAGER","HR")
                .and()
                .httpBasic();
    }

}
