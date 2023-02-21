package com.yuri.shoppingsite.Repository;


import com.yuri.shoppingsite.domain.userFunction.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
