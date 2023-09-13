package br.com.almeidatiago.api.resources.exceptions;

import br.com.almeidatiago.api.services.exceptions.DataIntegrityViolationException;
import br.com.almeidatiago.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ResourceExceptionHandlerTest {

    public static final String OBJECT_NOT_FOUND = "Object not found !";
    public static final String E_MAIL_ALREADY_REGISTERED_IN_THE_SYSTEM = "E-mail already registered in the system";
    @InjectMocks
    private ResourceExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler
            .objectNotFound(
                new ObjectNotFoundException(OBJECT_NOT_FOUND),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(OBJECT_NOT_FOUND, response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());
    }

    @Test
    void whendataIntegrityViolationThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler
            .dataIntegrityViolation(
                new DataIntegrityViolationException(E_MAIL_ALREADY_REGISTERED_IN_THE_SYSTEM),
                new MockHttpServletRequest());

        String path = response.getBody().getPath();
        LocalDateTime timestamp = response.getBody().getTimestamp();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(E_MAIL_ALREADY_REGISTERED_IN_THE_SYSTEM, response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());
        assertNotEquals("user/2", path);
        assertNotEquals(LocalDateTime.now(), timestamp);
    }
}