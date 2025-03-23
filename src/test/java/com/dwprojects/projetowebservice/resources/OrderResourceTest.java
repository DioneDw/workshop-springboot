package com.dwprojects.projetowebservice.resources;

import com.dwprojects.projetowebservice.entities.Order;
import com.dwprojects.projetowebservice.entities.User;
import com.dwprojects.projetowebservice.entities.enums.OrderStatus;
import com.dwprojects.projetowebservice.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderResourceTest {

    public static final int INDEX = 0;
    public static final long ID = 1L;
    public static final String NAME = "teste";
    public static final String EMAIL = "teste@teste.com";
    public static final String PHONE = "99999999";
    public static final String PASSWORD = "123465";

    @InjectMocks
    private OrderResource resource;
    @Mock
    private OrderService service;

    private Order order;
    private Instant moment;
    private User client;
    private OrderStatus orderStatus;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startOrder();
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(List.of(order));

        ResponseEntity<List<Order>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(Order.class, response.getBody().get(INDEX).getClass());
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(moment, response.getBody().get(INDEX).getMoment());
        assertEquals(orderStatus, response.getBody().get(INDEX).getOrderStatus());
        assertEquals(client, response.getBody().get(INDEX).getClient());

        verify(service,times(1)).findAll();
    }

    @Test
    void findById() {
        when(service.findById(anyLong())).thenReturn(order);

        ResponseEntity<Order> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(Order.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(moment, response.getBody().getMoment());
        assertEquals(orderStatus, response.getBody().getOrderStatus());
        assertEquals(client, response.getBody().getClient());

        verify(service,times(1)).findById(ID);

    }

    void startOrder(){
        moment = java.time.Instant.now();
        orderStatus = OrderStatus.PAID;
        client = new User(ID,NAME, EMAIL, PHONE, PASSWORD);
        order = new Order(1L,moment,orderStatus,client);
    }
}
