package com.dwprojects.projetowebservice.resources;

import com.dwprojects.projetowebservice.entities.Product;
import com.dwprojects.projetowebservice.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductResourceTest {

    public static final long ID = 1L;
    public static final String NAME = "Name";
    public static final String DESCRIPTION = "Description";
    public static final double PRICE = 999.9;
    public static final String IMG_URL = "URL_IMG";
    public static final int INDEX = 0;
    @InjectMocks
    private ProductResource resource;
    @Mock
    private ProductService service;

    private Product product;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startProduct();
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(List.of(product));

        ResponseEntity<List<Product>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        verify(service, times(1)).findAll();
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(1, response.getBody().size());
        assertEquals(Product.class, response.getBody().get(INDEX).getClass());
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(DESCRIPTION, response.getBody().get(INDEX).getDescription());
        assertEquals(PRICE, response.getBody().get(INDEX).getPrice());
        assertEquals(IMG_URL, response.getBody().get(INDEX).getImgUrl());

    }

    @Test
    void findById() {
        when(service.findById(anyLong())).thenReturn(product);

        ResponseEntity<Product> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        verify(service, times(1)).findById(ID);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Product.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(DESCRIPTION, response.getBody().getDescription());
        assertEquals(PRICE, response.getBody().getPrice());
        assertEquals(IMG_URL, response.getBody().getImgUrl());
    }

    void startProduct(){
        product = new Product(ID, NAME, DESCRIPTION, PRICE, IMG_URL);
    }
}
