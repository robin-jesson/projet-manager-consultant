package com.alten.hercules.auth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alten.hercules.auth.controller.UserController;
import com.alten.hercules.auth.dao.UserDAO;
import com.alten.hercules.auth.model.AppUser;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
    @InjectMocks
    UserController authController;
     
    @Mock
    UserDAO dao;
	
	/*@Test
	void testRegistrationOK() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(user.getEmail())).thenReturn(null);
         
        ResponseEntity<?> responseEntity = authController.registration(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/" + user.getEmail());
        
	}
	
	@Test
	void testRegistrationKOEmptyValue() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "");
        
        ResponseEntity<?> responseEntity = authController.registration(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        
        user = new User("", "azerty");
        responseEntity = authController.registration(user);
        
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	void testRegistrationKOEmailAlreadyExist() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(user.getEmail())).thenReturn(new User());
        
        ResponseEntity<?> responseEntity = authController.registration(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
	}
	
	@Test
	void testUpdateAccountOK() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "azerty");
         
        when(dao.findByEmail(user.getEmail())).thenReturn(new User());
         
        ResponseEntity<?> responseEntity = authController.updateUser(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	
	@Test
	void testUpdateAccountKOEmptyValue() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "");
        
        ResponseEntity<?> responseEntity = authController.updateUser(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        
        user = new User("", "azerty");
        responseEntity = authController.updateUser(user);
        
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	void testUpdateAccountKOEmailNotFound() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(user.getEmail())).thenReturn(null);
        
        ResponseEntity<?> responseEntity = authController.updateUser(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	void testDeleteAccountOK() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "azerty");
         
        when(dao.findByEmail(user.getEmail())).thenReturn(new User());
         
        ResponseEntity<?> responseEntity = authController.deleteUser(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void testDeleteAccountKOEmailNotFound() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(user.getEmail())).thenReturn(null);
        
        ResponseEntity<?> responseEntity = authController.deleteUser(user);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}*/
	
}
