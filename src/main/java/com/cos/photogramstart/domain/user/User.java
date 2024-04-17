package com.cos.photogramstart.domain.user;

import com.cos.photogramstart.domain.image.Image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String name;

    private String website;

    private String bio;

    private String email;

    private String phone;

    private String gender;

    private String profileImageUrl;

    private String role;

    private LocalDateTime createDate;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"user"})
    private List<Image> images;

    @Override
    public String toString() {
        return "User [bio=" + bio + ", createDate=" + createDate + ", email=" + email + ", gender=" + gender + ", id="
                + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", profileImageUrl="
                + profileImageUrl + ", role=" + role + ", username=" + username + ", website=" + website + "]";
    }
}
