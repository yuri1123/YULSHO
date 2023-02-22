package com.yuri.shoppingsite.Repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yuri.shoppingsite.domain.shop.Item;
import com.yuri.shoppingsite.domain.shop.ItemSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    private JPAQueryFactory queryFactory;
    public ItemRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

//    private BooleanExpression searchSellStatusEq(ItemSellStatus searchSellStatus){
//        return searchSellStatus == null? null : QItem.item.itemSellStatus.eq(searchSellStatus);
//    }

    @Override
    public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {

        return null;
    }
}
