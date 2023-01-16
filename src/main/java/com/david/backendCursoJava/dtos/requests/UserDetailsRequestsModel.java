package com.david.backendCursoJava.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsRequestsModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
