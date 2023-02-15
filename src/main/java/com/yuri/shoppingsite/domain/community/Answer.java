package com.yuri.shoppingsite.domain.community;

import com.yuri.shoppingsite.domain.user.SiteUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Answer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(columnDefinition = "TEXT")
        private String content;
        @CreatedDate
        private LocalDateTime createDate;
        @ManyToOne
        private Question question;
        @ManyToOne
        private SiteUser author;
        private LocalDateTime modifyDate;
        @ManyToMany
        Set<SiteUser> voter;

}
