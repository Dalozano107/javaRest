package com.david.backendCursoJava.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {

    private Long id;
    private String post_id;
    private String title;
    private String content;
    private Date expiration_at;
    private Date created_at;
    private UserDTO user;
    private ExposureDTO exposure;
}
