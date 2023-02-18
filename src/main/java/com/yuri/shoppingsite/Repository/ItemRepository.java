package com.yuri.shoppingsite.Repository;

import com.yuri.shoppingsite.domain.shop.Item;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository는 2개의 제네릭 타입을 사용하는데
//첫번째는 엔티티 타입 클래스를 넣어주고
//두번째는 기본키 타입을 넣음

public interface ItemRepository extends JpaRepository<Item, Long>{



}
