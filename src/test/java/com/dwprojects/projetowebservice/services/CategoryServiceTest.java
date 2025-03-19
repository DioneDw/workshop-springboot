package com.dwprojects.projetowebservice.services;

import com.dwprojects.projetowebservice.entities.Category;
import com.dwprojects.projetowebservice.entities.Order;
import com.dwprojects.projetowebservice.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class CategoryServiceTest {

    public static final long ID = 1L;
    public static final String NAME_CATEGORY = "Name Category";
    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository repository;

    private Category category;
    private Optional<Category> optionalCategory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCategory();
    }

    @Test
    void whenFindAllThenReturnCategories() {
        when(repository.findAll()).thenReturn(List.of(category));

        List<Category> response = service.findAll();

        verify(repository,times(1)).findAll();
        assertNotNull(response);
        assertEquals(1, response.size());

        assertEquals(Category.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(NAME_CATEGORY, response.get(0).getName());
    }

    @Test
    void whenFindByIdThenReturnCategory() {
        when(repository.findById(anyLong())).thenReturn(optionalCategory);

        Category response = service.findById(ID);

        verify(repository, times(1)).findById(ID);
        assertNotNull(response);
        assertEquals(Category.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(NAME_CATEGORY, response.getName());

    }

    void startCategory(){
        category = new Category(ID, NAME_CATEGORY);
        optionalCategory = Optional.of(new Category(ID, NAME_CATEGORY));
    }
}