package com.cos.photogramstart.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String website;

    private String bio;

    private String email;

    private String phone;

    private String gender;

    private String profileImageUrl;

    private String role;

    private LocalDateTime createData;

    @PrePersist
    public void createDate(){
        this.createData = LocalDateTime.now();
    }
}
