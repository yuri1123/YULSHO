package com.yuri.shoppingsite.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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


}
