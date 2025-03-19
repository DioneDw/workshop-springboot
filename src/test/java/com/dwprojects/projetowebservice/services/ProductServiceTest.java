package com.dwprojects.projetowebservice.services;

import com.dwprojects.projetowebservice.entities.Product;
import com.dwprojects.projetowebservice.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductServiceTest {
    public static final long ID = 1L;
    public static final String NAME_PRODUCT = "Name Product";
    public static final String DESCRIPTION_PRODUCT = "Description Product";
    public static final double PRICE = 9.9;
    public static final String IMG_URL = "http://url_img.com";
    @InjectMocks
    private ProductService service;
    @Mock
    private ProductRepository repository;

    private Product product;
    private Optional<Product> optionalProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startProduct();
    }

    @Test
    void whenFindAllThenReturnListProducts() {
        when(repository.findAll()).thenReturn(List.of(product));

        List<Product> response = service.findAll();

        verify(repository,times(1)).findAll();
        assertNotNull(response);
        assertEquals(1,response.size());

        assertEquals(Product.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(NAME_PRODUCT, response.get(0).getName());
        assertEquals(DESCRIPTION_PRODUCT, response.get(0).getDescription());
        assertEquals(PRICE, response.get(0).getPrice());
        assertEquals(IMG_URL, response.get(0).getImgUrl());
    }

    @Test
    void findById() {
        when(repository.findById(anyLong())).thenReturn(optionalProduct);

        Product response = service.findById(ID);

        verify(repository,times(1)).findById(ID);
        assertNotNull(response);
        assertEquals(Product.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(NAME_PRODUCT, response.getName());
        assertEquals(DESCRIPTION_PRODUCT, response.getDescription());
        assertEquals(PRICE, response.getPrice());
        assertEquals(IMG_URL, response.getImgUrl());

    }

    void startProduct(){
        product = new Product(ID, NAME_PRODUCT, DESCRIPTION_PRODUCT, PRICE, IMG_URL);
        optionalProduct = Optional.of(new Product(ID, NAME_PRODUCT, DESCRIPTION_PRODUCT, PRICE, IMG_URL));
    }


}