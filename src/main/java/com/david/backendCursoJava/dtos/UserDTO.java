package com.david.backendCursoJava.dtos;

import com.david.backendCursoJava.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;
    private String userId;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private List<Post> posts;

}
