package com.yuri.shoppingsite.domain.shop;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String category;
    @Column(unique = true)
    private String productname;
    private String productcontent;
    private Long price;
    private Integer quantity;
    private String etc;

    private String uuid;
    private String filename;

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;


}
