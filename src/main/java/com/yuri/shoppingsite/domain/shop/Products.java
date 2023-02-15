package com.yuri.shoppingsite.domain.shop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String category;
    @Column(unique = true)
    private String productname;
    private String productcontent;
    private String price;
    private String etc;
    private String regdate;



}
