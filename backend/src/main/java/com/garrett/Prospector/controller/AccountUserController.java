package com.garrett.Prospector.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garrett.Prospector.model.AccountUser;
import com.garrett.Prospector.service.AccountUserService;

@RestController
@RequestMapping("/api")
public class AccountUserController {
	
	private AccountUserService service;
	
	public AccountUserController(AccountUserService service) {
		this.service = service;
	}
	
	// get all users 
	@GetMapping(path = "/users")
	public List<AccountUser> getAllusers() {
		return service.getAllUsers();
	}
	
	// get user by id
	// create user
	// update user
	// delete user
}
