package com.dwprojects.projetowebservice.entities.pk;

import com.dwprojects.projetowebservice.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class OrderItemPKTest {

    private OrderItemPK orderItemPK;
    @Test
    public void testOrderItemPK() {
        Product product = new Product(1L, "Produto Teste", "Descrição", 100.0, "URL");
        orderItemPK = new OrderItemPK();
        orderItemPK.setProduct(product);

        assertNotNull(orderItemPK.getProduct());
    }
}