package com.yuri.shoppingsite.domain.userFunction;

import com.yuri.shoppingsite.domain.user.SiteUser;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@Table(name="cart")
@ToString
public class Cart {

    @Id
    @Column(name="cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne //회원 엔티티와 일대일로 매핑
    @JoinColumn(name="id") //매핑할 외래키를 지정, name 속에는 매핑할 외래키의 이름을 설정
    private SiteUser siteUser;


}
