package com.david.backendCursoJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BCryptPasswordConfig {


    @Bean
    public BCryptPasswordEncoder getBryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
