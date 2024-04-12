package com.cos.photogramstart.domain.comment;

import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false, length = 100)
    private String content;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @JoinColumn(name = "imageId")
    @ManyToOne
    private Image image;

    private LocalDateTime createDate;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
