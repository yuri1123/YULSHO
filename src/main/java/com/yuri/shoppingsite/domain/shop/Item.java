package com.yuri.shoppingsite.domain.shop;

import com.yuri.shoppingsite.constant.ItemSellStatus;
import com.yuri.shoppingsite.domain.common.BaseEntity;
import com.yuri.shoppingsite.exception.OutOfStockException;
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
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;       //상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm; //상품명

    @Column(name="price", nullable = false)
    private int price; //가격

    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    public void removeStock(int stockNumber){
        //상품의 재고 수량에서 주문 후 남은 재고 수량을 구한다.
        int restStock = this.stockNumber - stockNumber;
        //상품의 재고가 주문 수량보다 작을 경우 재고 부족 예외를 발생시킨다.
        if(restStock <0){
            throw new OutOfStockException("상품의 재고가 부족합니다.(현재 재고 수량 : "+
                    this.stockNumber + ")");
        }
        //주문 후 남은 재고 수량을 상품의 현재 재고 값으로 할당한다.
        this.stockNumber = restStock;
    }
}
