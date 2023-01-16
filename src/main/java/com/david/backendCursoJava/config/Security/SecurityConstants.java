package com.david.backendCursoJava.config.Security;

import com.david.backendCursoJava.SpringApplicationContext;

public class SecurityConstants {

    public static final Long EXPIRATION_DATE = 86400000000L; //10 dias
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGH_UP_URL = "/users";

    public static String getTokenSecret(){
        AppProperties appProperties = (AppProperties)SpringApplicationContext.getBean("AppProperties");
        return  appProperties.getTokenSecret();
    }

}
