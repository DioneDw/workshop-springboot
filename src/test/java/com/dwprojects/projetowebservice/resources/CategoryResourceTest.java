package com.dwprojects.projetowebservice.resources;

import com.dwprojects.projetowebservice.entities.Category;
import com.dwprojects.projetowebservice.services.CategoryService;
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
class CategoryResourceTest {
    public static final long ID = 1L;
    public static final String NAME = "Name";
    public static final int INDEX = 0;
    @InjectMocks
    private CategoryResource resource;
    @Mock
    private CategoryService service;

    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCategory();
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(List.of(category));

        ResponseEntity<List<Category>> response = resource.findAll();

        verify(service, times(1)).findAll();
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(1, response.getBody().size());
        assertEquals(Category.class, response.getBody().get(INDEX).getClass());
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());

    }

    @Test
    void findById() {
        when(service.findById(anyLong())).thenReturn(category);

        ResponseEntity<Category> response = resource.findById(ID);

        verify(service, times(1)).findById(ID);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Category.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
    }

    void startCategory(){
        category = new Category(ID, NAME);
    }
}