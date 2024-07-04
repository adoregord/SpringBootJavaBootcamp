package com.example.authDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.Auth;
import com.example.repository.AuthRepository;
import com.example.service.AuthService;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
	@Mock
	AuthRepository authRepository;
	
	@InjectMocks
	AuthService authService;
	
	@BeforeEach
	void setMockOutput() {
		List<Auth> accountList = new ArrayList<Auth>();
		accountList.add(new Auth("1982094121",10000));
		accountList.add(new Auth("1982094122",10000));
		accountList.add(new Auth("1982094123",10000));
		accountList.add(new Auth("1982094124",10000));
		accountList.add(new Auth("1982094125",10000));
		
		lenient().when(authRepository.findAll()).thenReturn(accountList);
		lenient().when(authRepository.existsById(anyInt())).thenReturn(Boolean.TRUE);
		lenient().when(authRepository.findById(anyInt())).thenReturn(Optional.of(new Auth("11111",1000)));
	}
	
	@Test
	void testFindAll() {
		List<Auth> accountList = authService.listAll();
		
		assertEquals(5, accountList.size());
		verify(authRepository, times(1)).findAll();
	}
	
	@Test
	void testCreateAccount() {
		Auth auth = new Auth("1982094125",10000);
		
		accountService.save(auth);
		
		verify(authRepository, times(1)).save(accouauthnt);
	}
	
	@Test
	void testWithdraw() {
		float amount = 1000;
		Integer id = 1;
		accountService.withdraw(amount, id);
		verify(accountRepo, times(1)).withdraw(amount, id);
	}
}