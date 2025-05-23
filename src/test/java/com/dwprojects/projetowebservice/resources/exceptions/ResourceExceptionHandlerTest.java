package com.dwprojects.projetowebservice.resources.exceptions;

import com.dwprojects.projetowebservice.services.exceptions.DatabaseException;
import com.dwprojects.projetowebservice.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ResourceExceptionHandlerTest {

    public static final long ID = 1L;
    public static final String EXPECTED = "Resource not found. Id: " + ID;
    public static final String DATABASE_ERROR = "Database error";
    @InjectMocks
    private ResourceExceptionHandler exceptionHandler;

    @Mock
    private StandardError standardError;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenResourceNotFoundExceptionIsThrow() {
        ResponseEntity<StandardError> response = exceptionHandler.resourceNotFound(new ResourceNotFoundException(ID),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(standardError.getClass(), response.getBody().getClass());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(EXPECTED, response.getBody().getMessage());
    }

    @Test
    void whenDatabaseExceptionIsThrow() {
        ResponseEntity<StandardError> response = exceptionHandler.database(new DatabaseException(DATABASE_ERROR),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(standardError.getClass(), response.getBody().getClass());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(DATABASE_ERROR, response.getBody().getMessage());
    }
}