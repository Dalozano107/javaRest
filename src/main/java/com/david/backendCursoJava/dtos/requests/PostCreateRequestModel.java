package com.david.backendCursoJava.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostCreateRequestModel {
    private String title;
    private String content;
    private Long exposureId;
    private Integer expirationTime;
}
