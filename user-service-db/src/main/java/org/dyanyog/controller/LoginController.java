package org.dyanyog.controller;

import org.dyanyog.dto.LoginRequest;
import org.dyanyog.dto.LoginResponse;
import org.dyanyog.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
	LoginServices loginService;
	
	@GetMapping(
			path="/auth/validate",consumes= {"application/json","application/xml"},produces = {"application/json","application/xml"})
			
			public LoginResponse validate(@RequestBody LoginRequest loginRequest) {
		return loginService.validate(loginRequest);
		
	}
	

}
