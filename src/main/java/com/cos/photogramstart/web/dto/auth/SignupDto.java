package com.cos.photogramstart.web.dto.auth;


import lombok.Data;

@Data //Getter, Setter, toString 자동 생성 어노테이션
public class SignupDto {
    private String username;
    private String password;
    private String email;
    private String name;
}
