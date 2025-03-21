package com.dwprojects.projetowebservice.resources;

import com.dwprojects.projetowebservice.entities.User;
import com.dwprojects.projetowebservice.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class UserResourceTest {

    public static final int INDEX = 0;
    public static final long ID = 1L;
    public static final String NAME = "teste";
    public static final String EMAIL = "teste@teste.com";
    public static final String PHONE = "99999999";
    public static final String PASSWORD = "123465";
    @InjectMocks
    private UserResource resource;

    @Mock
    private UserService service;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindAllReturnListUsers() {
        when(service.findAll()).thenReturn(List.of(user));

        ResponseEntity<List<User>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(User.class, response.getBody().get(INDEX).getClass());
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        assertEquals(PASSWORD, response.getBody().get(INDEX).getPassword());

        verify(service,times(1)).findAll();

    }

    @Test
    void insert() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    void startUser(){
        user = new User(ID,NAME, EMAIL, PHONE, PASSWORD);
    }
}