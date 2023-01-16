package com.david.backendCursoJava.controllers;

import com.david.backendCursoJava.dtos.requests.PostCreateRequestModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    public String createPost(@RequestBody PostCreateRequestModel PostCreateRequestModel){
        return  PostCreateRequestModel.getTitle();
    }

}
