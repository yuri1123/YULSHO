package com.yuri.shoppingsite.domain.userFunction;

import com.yuri.shoppingsite.domain.common.BaseEntity;
import com.yuri.shoppingsite.domain.shop.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity {


    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    //하나의 상품은 여러 주문 상품으로 들어갈 수 있으므로 주문 상품 기준으로 단방향 매핑을 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;


    //한번의 주문에는 여러 개의 상품을 주문할 수 있으므로 주문 상품 엔티티와 주문 엔티티를 다대일 단방향 매핑을 먼저 설정한다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    private int orderPrice; //주문가격
    private int count; //수량

//    private LocalDateTime regTime;
//    private LocalDateTime updateTime;

}
