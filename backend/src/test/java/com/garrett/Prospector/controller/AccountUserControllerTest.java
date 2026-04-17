package com.garrett.Prospector.controller;

import org.apache.tomcat.util.file.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.garrett.Prospector.model.AccountUser;
import com.garrett.Prospector.service.AccountUserService;

@WebMvcTest(AccountUserController.class)
@AutoConfigureMockMvc(addFilters = false)
class AccountUserControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@MockitoBean
	private AccountUserService service;
	
	private List<AccountUser> list;
	
	@BeforeEach
	void setUp() {
		list = new ArrayList<>();
		list.add(new AccountUser(0L, "John Doe", "@123", "jd@email.com"));
		list.add(new AccountUser(1L, "Jane Doe", "@123", "janedoe@email.com"));
	}
	
	@Test
	void testGetAllUsers() throws Exception {
		
		// mock service by returning dummy list
		Mockito.when(service.getAllUsers()).thenReturn(list);
		
		// set up get request for all AccountUser endpoint
		mock.perform(get("/api/users"))
		
		// expect status is 200 OK
		.andExpect(status().isOk())
		
		// expect it will be APPLICATION_JSON type
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		
		// expect there will be 2 entries
		.andExpect(jsonPath("$", hasSize(2)))
		
		// expect first entry with username
		.andExpect(jsonPath("$[0].username").value("John Doe"))
		
		// expect first entry with passwordHash
		.andExpect(jsonPath("$[0].passwordHash").value("@123"))
		
		// expect first entry with email
		.andExpect(jsonPath("$[0].email").value("jd@email.com"))
		
		// expect second entry with username
		.andExpect(jsonPath("$[1].username").value("Jane Doe"))
				
		// expect second entry with passwordHash
		.andExpect(jsonPath("$[1].passwordHash").value("@123"))
				
		// expect second entry with email
		.andExpect(jsonPath("$[1].email").value("janedoe@email.com"));
	}
}
