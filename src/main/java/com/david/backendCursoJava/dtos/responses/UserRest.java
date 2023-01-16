package com.david.backendCursoJava.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRest {
    private String userId;
    private String firstName;
    private String LastName;
    private String email;
}
