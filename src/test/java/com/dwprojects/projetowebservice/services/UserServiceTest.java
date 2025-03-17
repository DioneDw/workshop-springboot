package com.dwprojects.projetowebservice.services;

import com.dwprojects.projetowebservice.entities.User;
import com.dwprojects.projetowebservice.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    public static final long ID = 1L;
    public static final String NAME = "UserTest";
    public static final String EMAIL = "test@test.com";
    public static final String PHONE = "99999999";
    public static final String PASSWORD = "123465";

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    private User user;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsers();
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();

        verify(repository, times(1)).findAll();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(0).getClass());

        assertEquals(ID, response.get(0).getId());
        assertEquals(NAME, response.get(0).getName());
        assertEquals(EMAIL, response.get(0).getEmail());
        assertEquals(PHONE, response.get(0).getPhone());
        assertEquals(PASSWORD, response.get(0).getPassword());
    }

    @Test
    void findById() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    void startUsers(){
        user = new User(ID, NAME, EMAIL, PHONE, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PHONE, PASSWORD));
    }
}