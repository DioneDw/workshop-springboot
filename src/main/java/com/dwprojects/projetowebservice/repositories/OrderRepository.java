package com.dwprojects.projetowebservice.repositories;

import com.dwprojects.projetowebservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
