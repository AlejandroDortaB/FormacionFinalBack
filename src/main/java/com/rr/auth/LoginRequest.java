package com.rr.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	String username;
	String password;
	public String getUsername() {
	
		return username;
	}
	public String getPassword() {
		
		return password;
	}
}
