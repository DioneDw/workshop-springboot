package com.dwprojects.projetowebservice.services;

import com.dwprojects.projetowebservice.entities.User;
import com.dwprojects.projetowebservice.repositories.UserRepository;
import com.dwprojects.projetowebservice.services.exceptions.DatabaseException;
import com.dwprojects.projetowebservice.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    public static final long ID = 1L;
    public static final String RESOURCE_NOT_FOUND_MESSAGE = "Resource not found. Id: " + ID;
    public static final String NAME = "UserTest";
    public static final String EMAIL = "test@test.com";
    public static final String PHONE = "99999999";
    public static final String PASSWORD = "123465";
    public static final String MESSAGE_EXCEPTION = "Test message exception";

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
    void whenFindByIdThenReturnUser() {
        when(repository.findById(anyLong())).thenReturn(optionalUser);

        User response = service.findById(ID);

        verify(repository, times(1)).findById(anyLong());
        assertNotNull(response);
        assertEquals(User.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PHONE, response.getPhone());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenFindByIdThrowException(){
        when(repository.findById(anyLong())).thenThrow(new ResourceNotFoundException(ID));

        ResourceNotFoundException response = assertThrows(ResourceNotFoundException.class, ()-> {
            service.findById(ID);
        });
        assertNotNull(response.getMessage());
        assertEquals(RESOURCE_NOT_FOUND_MESSAGE, response.getMessage());
    }

    @Test
    void whenInsertThenReturnSucess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.insert(user);

        verify(repository, times(1)).save(any());

        assertNotNull(response);
        assertEquals(User.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PHONE, response.getPhone());
        assertEquals(PASSWORD, response.getPassword());

    }

    @Test
    void whenDeleteThenReturnSucess() {
        when(repository.existsById(anyLong())).thenReturn(true);
        service.delete(ID);
        verify(repository, times(1)).deleteById(ID);
    }

    @Test
    void whenDeleteThrowResourceNotFoundException() {
        when(repository.existsById(anyLong())).thenThrow(new ResourceNotFoundException(ID));

        ResourceNotFoundException response = assertThrows(ResourceNotFoundException.class, ()-> {
            service.delete(ID);
        });
        assertNotNull(response.getMessage());
        assertEquals(RESOURCE_NOT_FOUND_MESSAGE, response.getMessage());
    }

    @Test
    void whenDeleteThrowDataIntegrityViolationException() {
        when(repository.existsById(anyLong())).thenReturn(true);

        doThrow(new DatabaseException(MESSAGE_EXCEPTION)).when(repository).deleteById(ID);

        DatabaseException response = assertThrows(DatabaseException.class, () -> repository.deleteById(ID));
        assertEquals(MESSAGE_EXCEPTION, response.getMessage());
        verify(repository, times(1)).deleteById(ID);

    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(repository.getReferenceById(anyLong())).thenReturn(user);
        when(repository.save(any())).thenReturn(user);

        User response = service.update(ID,user);

        verify(repository, times(1)).getReferenceById(ID);
        verify(repository, times(1)).save(user);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PHONE, response.getPhone());
        assertEquals(PASSWORD, response.getPassword());

    }

    void startUsers(){
        user = new User(ID, NAME, EMAIL, PHONE, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PHONE, PASSWORD));
    }
}