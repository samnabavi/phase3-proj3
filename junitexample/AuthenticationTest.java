package com.example.junitexample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.User;
import com.security.Authentication;

public class AuthenticationTest {
	
	@BeforeEach
	public void setup() {
		Authentication.userList.add(User.builder().userName("userA").password("passA").role("roleA").build());
		Authentication.userList.add(User.builder().userName("userB").password("passB").role("roleB").build());
		
	}
	
	@Test
	public void testLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("userA", "passA"));
	}
	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(false, authentication.login("NEWUSER", "NEWPASSWORD"));
	}

	@Test
	public void testUserAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("userA", "passA"));
		
		assertEquals("userA", authentication.getUserName());
	}
	
	@Test
	public void testRoleAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("userA", "passA"));
		
		assertEquals("roleA", authentication.getRole());
	}

	@Test
	public void testLogout() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("userA", "passA"));
		
		authentication.logout();
		
		assertEquals(null, authentication.getRole());
	}

}
