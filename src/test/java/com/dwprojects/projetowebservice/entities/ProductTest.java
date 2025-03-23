package com.dwprojects.projetowebservice.entities;

import com.dwprojects.projetowebservice.entities.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class ProductTest {

    private Instant moment;
    private User client;
    private Order order;
    private Product product;

    @BeforeEach
    void setUp() {
        startProduct();
    }

    @Test
    void getOrders() {
        OrderItem orderItem = new OrderItem(order,product,1,10.0);
        Set<Order> orders = new HashSet<>();
        orders.add(order);

        product.getItens().add(orderItem);

        assertEquals(orders.size(), product.getOrders().size());
    }

    void startProduct(){
        OrderStatus orderStatus = OrderStatus.WAITING_PAYMENT;
        moment = java.time.Instant.now();
        client = new User(1L,"NAME", "EMAIL", "PHONE", "PASSWORD");
        order = new Order(1L,moment,orderStatus,client);
        product = new Product(1L, "Produto Teste", "Descrição", 100.0, "URL");
    }
}