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

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
	
    @InjectMocks
    AuthController authController;
     
    @Mock
    AccountDAO dao;
	
	@Test
	void testAddAccountOK() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(account.getEmail())).thenReturn(null);
         
        ResponseEntity<?> responseEntity = authController.addAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/" + account.getEmail());
        
	}
	
	@Test
	void testAddAccountKOEmptyValue() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "");
        
        ResponseEntity<?> responseEntity = authController.addAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        
        account = new Account("", "azerty");
        responseEntity = authController.addAccount(account);
        
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	void testAddAccountKOEmailAlreadyExist() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(account.getEmail())).thenReturn(new Account());
        
        ResponseEntity<?> responseEntity = authController.addAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
	}
	
	@Test
	void testUpdateAccountOK() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "azerty");
         
        when(dao.findByEmail(account.getEmail())).thenReturn(new Account());
         
        ResponseEntity<?> responseEntity = authController.updateAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	
	@Test
	void testUpdateAccountKOEmptyValue() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "");
        
        ResponseEntity<?> responseEntity = authController.updateAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        
        account = new Account("", "azerty");
        responseEntity = authController.updateAccount(account);
        
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	void testUpdateAccountKOEmailNotFound() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(account.getEmail())).thenReturn(null);
        
        ResponseEntity<?> responseEntity = authController.updateAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	void testDeleteAccountOK() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "azerty");
         
        when(dao.findByEmail(account.getEmail())).thenReturn(new Account());
         
        ResponseEntity<?> responseEntity = authController.deleteAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void testDeleteAccountKOEmailNotFound() {
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account("test.test@alten.com", "azerty");
        
        when(dao.findByEmail(account.getEmail())).thenReturn(null);
        
        ResponseEntity<?> responseEntity = authController.deleteAccount(account);
         
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
}
