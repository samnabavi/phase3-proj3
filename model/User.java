package com.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
	
	private String userName;
	
	private String password;
	
	private String role;

}
