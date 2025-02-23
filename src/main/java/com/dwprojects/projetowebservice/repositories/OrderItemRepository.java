package com.dwprojects.projetowebservice.repositories;

import com.dwprojects.projetowebservice.entities.OrderItem;
import com.dwprojects.projetowebservice.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
