package com.cos.photogramstart.domain.subscribe;

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
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "subscribe_uk",
                        columnNames = {
                                "fromUserId",
                                "toUserId"
                        }
                )
        }
)
public class Subscribe {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @JoinColumn(name = "fromUserId")
    @ManyToOne
    private User fromUser;  //구독자

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser;    //비구독자


    private LocalDateTime createDate;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

}
