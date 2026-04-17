package com.garrett.Prospector.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.garrett.Prospector.model.AccountUser;

@Service
public class AccountUserService {
	public List<AccountUser> getAllUsers() {
		List<AccountUser> users = new ArrayList<>();
		return users;
	}
} 
