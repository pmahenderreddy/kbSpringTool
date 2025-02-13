package com.mahi.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		return username.equals("user") && password.equals("mahy");
	}
}
