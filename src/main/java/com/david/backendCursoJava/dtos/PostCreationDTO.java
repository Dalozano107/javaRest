package com.david.backendCursoJava.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreationDTO implements Serializable {
    private String title;
    private String content;
    private Long exposureId;
    private Integer expirationTime;
    private String userEmail;
}
