package com.cos.photogramstart.domain.image;

import com.cos.photogramstart.domain.user.User;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Getter
//@Setter
public class Image {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String caption;

    private String postImageUrl;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    private LocalDateTime createDate;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", postImageUrl='" + postImageUrl + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
