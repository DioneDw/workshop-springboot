package com.dwprojects.projetowebservice.services;

import com.dwprojects.projetowebservice.entities.Order;
import com.dwprojects.projetowebservice.entities.User;
import com.dwprojects.projetowebservice.entities.enums.OrderStatus;
import com.dwprojects.projetowebservice.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceTest {
    public static final long ID = 1L;
    public static final String NAME = "UserTest";
    public static final String EMAIL = "test@test.com";
    public static final String PHONE = "99999999";
    public static final String PASSWORD = "123465";
    public static final long ID_PRODUCT = 2L;

    @InjectMocks
    private OrderService service;

    @Mock
    private OrderRepository repository;

    private Order order;
    private Optional<Order> optionalOrder;
    private OrderStatus orderStatus;
    private Instant instant;
    private User user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startOrder();
    }

    @Test
    void whenFindAllThenReturnListOrders() {
        when(repository.findAll()).thenReturn(List.of(order));

        List<Order> response = service.findAll();

        verify(repository,times(1)).findAll();
        assertNotNull(response);
        assertEquals(1, response.size());

        assertEquals(Order.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(instant, response.get(0).getMoment());
        assertEquals(orderStatus, response.get(0).getOrderStatus());
        assertEquals(user, response.get(0).getClient());
    }

    @Test
    void findById() {
        when(repository.findById(anyLong())).thenReturn(optionalOrder);

        Order response = service.findById(ID);

        verify(repository, times(1)).findById(ID);
        assertNotNull(response);
        assertEquals(Order.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(instant, response.getMoment());
        assertEquals(orderStatus, response.getOrderStatus());
        assertEquals(user, response.getClient());
    }

    void startOrder(){
        instant = Instant.now();
        orderStatus = OrderStatus.DELIVERED;
        user = new User(ID,NAME,EMAIL,PHONE,PASSWORD);
        order = new Order(ID, instant, orderStatus,user);
        optionalOrder = Optional.of(new Order(ID, instant, orderStatus,user));
    }

}