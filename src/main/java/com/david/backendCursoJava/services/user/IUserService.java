package com.david.backendCursoJava.services.user;

import com.david.backendCursoJava.dtos.UserDTO;
import com.david.backendCursoJava.dtos.requests.UserDetailsRequestsModel;
import com.david.backendCursoJava.dtos.responses.UserRest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    UserRest createUser(UserDetailsRequestsModel userDetails);
    UserDTO getUser(String email);
}
