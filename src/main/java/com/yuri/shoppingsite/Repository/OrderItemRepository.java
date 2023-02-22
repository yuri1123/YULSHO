package com.yuri.shoppingsite.Repository;

import com.yuri.shoppingsite.domain.userFunction.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
