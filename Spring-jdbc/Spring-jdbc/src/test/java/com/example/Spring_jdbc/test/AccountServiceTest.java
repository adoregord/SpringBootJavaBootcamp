package com.example.Spring_jdbc.test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Spring_jdbc.model.Account;
import com.example.Spring_jdbc.repository.AccountRepository;
import com.example.Spring_jdbc.service.AccountService;
import com.example.Spring_jdbc.service.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
	@Mock
	AccountRepository accountRepo;
	
	@InjectMocks
	AccountService accountService = new AccountServiceImpl();
	
	@BeforeEach
	void setMockOutput() {
		List<Account> accountList = new ArrayList<>();
		accountList.add(new Account("1982094121",10000));
		accountList.add(new Account("1982094122",10000));
		accountList.add(new Account("1982094123",10000));
		accountList.add(new Account("1982094124",10000));
		accountList.add(new Account("1982094125",10000));
		
		lenient().when(accountRepo.findAll()).thenReturn(accountList);
		lenient().when(accountRepo.existsById(anyInt())).thenReturn(Boolean.TRUE);
		lenient().when(accountRepo.findById(anyInt())).thenReturn((new Account("11111",1000)));
	}
	
	@Test
	void testFindAll() {
		List<Account> accountList = accountService.listAll();
		
		try {
			assertEquals(5, accountList.size());
		} catch (Exception e) {
			System.out.println("Status Expected: 5\nStatus Actual: " + accountList.size());
		}
		verify(accountRepo, times(1)).findAll();
	}

	@Test
	void testCreateAccount() {
		Account account = new Account("1982094125",10000);
		
		accountService.save(account);
		
		verify(accountRepo, times(1)).save(account);
	}

	@Test
	void testDeleteId(){
		int id = 1;
		accountService.delete(id);
		verify(accountRepo, times(1)).deleteById(id);
	}
}
