package com.david.backendCursoJava.config.Security;

import com.david.backendCursoJava.SpringApplicationContext;
import com.david.backendCursoJava.dtos.UserDTO;
import com.david.backendCursoJava.dtos.requests.UserLogin;
import com.david.backendCursoJava.services.user.IUserService;
import com.david.backendCursoJava.services.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            UserLogin userModel = new ObjectMapper().readValue(request.getInputStream(), UserLogin.class);
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userModel.getEmail(),
                            userModel.getPassword(),
                            new ArrayList<>()
                    ));
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override

    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
//        String username = ((User) attemptAuthentication(request,response).getPrincipal()).getUsername();
        String username = ((User) authResult.getPrincipal()).getUsername();
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS256,SecurityConstants.getTokenSecret()).compact();


        IUserService userService = (IUserService) SpringApplicationContext.getBean("userService");
        UserDTO user = userService.getUser(username);

        response.addHeader("userId",user.getUserId());
        response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX.concat(token));
//        super.successfulAuthentication(request, response, chain, authResult);
    }
}
