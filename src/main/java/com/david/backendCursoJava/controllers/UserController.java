package com.david.backendCursoJava.controllers;

import com.david.backendCursoJava.dtos.UserDTO;
import com.david.backendCursoJava.dtos.requests.UserDetailsRequestsModel;
import com.david.backendCursoJava.dtos.responses.UserRest;
import com.david.backendCursoJava.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users") //localhost:8080/users
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDTO> getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(userService.getUser(authentication.getPrincipal().toString()),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestsModel userDetails){
        return new ResponseEntity<>(userService.createUser(userDetails), HttpStatus.CREATED);
    }

}
