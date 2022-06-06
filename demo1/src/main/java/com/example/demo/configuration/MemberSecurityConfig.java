package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MemberSecurityConfig extends WebSecurityConfigurerAdapter { //BCrypt 해시함수 사용
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
            httpSecurity.cors().disable()
                    .csrf().disable()
                    .formLogin().disable()
                    .headers().frameOptions().disable();

            /*
            *   form에서 /logout으로 post 보냈지만, /login?logout으로 보내는 문제가 있었음.
            *   security logout 기능(logout default값 때문에 문제 발생)을 disable()해서 잡음
            *   https://cjh5414.github.io/spring-security-login-logout/
            */
            httpSecurity.logout().disable();

    }
}
