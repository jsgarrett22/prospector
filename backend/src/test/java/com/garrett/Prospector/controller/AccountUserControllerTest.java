package com.garrett.Prospector.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.garrett.Prospector.model.AccountUser;

@RestController
class AccountUserControllerTest {

	@Test
	public ResponseEntity<AccountUser> registerNewAccountUser(@RequestBody AccountUser requestBody) {
		return null;
	}

}
