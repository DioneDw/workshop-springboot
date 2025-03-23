package com.dwprojects.projetowebservice.entities;

import com.dwprojects.projetowebservice.entities.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderTest {

    private Order order;
    private OrderStatus orderStatus;
    private Instant moment;
    private User client;

    @BeforeEach
    void beforeEach(){
        startOrder();
    }

    @Test
    void setOrderStatusWithValidParam() {
        OrderStatus orderStatusBefore = order.getOrderStatus();
        OrderStatus orderNewAfter = OrderStatus.PAID;

        order.setOrderStatus(orderNewAfter);

        assertNotNull(orderStatusBefore);
        assertNotNull(orderNewAfter);

        assertEquals(orderNewAfter,order.getOrderStatus());
        assertNotEquals(orderStatusBefore, order.getOrderStatus());
    }
    @Test
    void setOrderStatusWithInvalidParam() {
        OrderStatus orderStatusBefore = order.getOrderStatus();
        OrderStatus orderNewAfter = null;

        order.setOrderStatus(orderNewAfter);

        assertNotNull(order.getOrderStatus());
        assertEquals(orderStatusBefore, order.getOrderStatus());
    }


    @Test
    void getTotal() {
        Product product1 = new Product(1L, "Produto Teste", "Descrição", 100.0, "URL");
        Product product2 = new Product(2L, "Produto Teste", "Descrição", 100.0, "URL");
        OrderItem o1 = new OrderItem(order,product1,1,10.0);
        OrderItem o2 = new OrderItem(order,product2,2,20.0);

        order.getItems().add(o1);
        order.getItems().add(o2);

        double sumOrderItens = o1.subTotal() + o2.subTotal();

        assertEquals(2, order.getItems().size());
        assertEquals(sumOrderItens, order.getTotal());
    }

    @Test
    void getOrderStatus(){
        int code = orderStatus.getCode();

        assertEquals(code, order.getOrderStatus().getCode());
        assertEquals(OrderStatus.valueOf(code),order.getOrderStatus());

    }

    void startOrder(){
        orderStatus = OrderStatus.WAITING_PAYMENT;
        moment = java.time.Instant.now();
        client = new User(1L,"NAME", "EMAIL", "PHONE", "PASSWORD");
        order = new Order(1L,moment,orderStatus,client);
    }
}
