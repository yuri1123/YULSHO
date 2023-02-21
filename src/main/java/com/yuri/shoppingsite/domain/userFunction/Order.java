package com.yuri.shoppingsite.domain.userFunction;


import com.yuri.shoppingsite.constant.OrderStatus;
import com.yuri.shoppingsite.domain.user.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="orders") //정렬시에도 order를 사용하므로 orders로 표시하였음
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    //한명의 회원은 여러번 주문할 수 있으므로 주문 엔티티 기준에서 다대일 단방향 매핑을 한다.
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; //주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; //주문 상태

    //부모엔티티의 영속성 상태 변화를 자식 엔티티에 모두 전이하는 CascadeTypeAll옵션을 설정하겠다
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    //하나의 주문이 여러개의 주문 상품을 갖으므로 List 자료형을 사용해서 매핑한다.
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime regDTime;
    private LocalDateTime updateTime;

}
