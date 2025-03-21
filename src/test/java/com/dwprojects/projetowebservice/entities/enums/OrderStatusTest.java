package com.dwprojects.projetowebservice.entities.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderStatusTest {

    public static final int CODE = 1;
    public static final String MESSAGE_EXCEPTION = "Invalid OrderStatus Code";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenValueOfReturnOrderStatus() {
        OrderStatus response = OrderStatus.valueOf(CODE);

        assertNotNull(response);
        assertEquals(OrderStatus.class, response.getClass());
        assertEquals(CODE, response.getCode());
    }

}