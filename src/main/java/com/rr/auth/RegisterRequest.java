package com.rr.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	String username;
	String password;
	
	
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
}

