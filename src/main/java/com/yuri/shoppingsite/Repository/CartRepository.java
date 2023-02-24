package com.yuri.shoppingsite.Repository;

import com.yuri.shoppingsite.domain.shop.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart,Long> {


}

