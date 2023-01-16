package com.david.backendCursoJava.config;

import com.david.backendCursoJava.dtos.requests.UserDetailsRequestsModel;
import com.david.backendCursoJava.entities.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }



}
