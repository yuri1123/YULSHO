package com.yuri.shoppingsite.domain.shop;

import com.yuri.shoppingsite.constant.ItemSellStatus;
import com.yuri.shoppingsite.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @Id
    @Column(name="item_id") //어떤 테이블과 매핑될지 지정
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 상품 코드
    @Column(nullable = false, length = 50)
    private String itemNm; //상품명
    @Column(nullable = false, name = "price")
    private int price; //가격
    @Column(nullable = false)
    private int stockNumber; //재고수량
    @Lob
    @Column(nullable = false)
    private String itemDetail; //제품 상세 설명
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품판매상태
//    private LocalDateTime regTime; //등록시간
//    private LocalDateTime updateTime; //수정시간

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this. itemSellStatus = itemFormDto.getItemSellStatus();
    }
}
