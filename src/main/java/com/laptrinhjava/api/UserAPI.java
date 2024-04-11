package com.laptrinhjava.api;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjava.dto.UserDTO;
import com.laptrinhjava.service.impl.UserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserAPI {

	UserService service;
	
	@GetMapping("/api/check")
	@CrossOrigin
	public String authenUser(@RequestParam("username") String username , @RequestParam("password") String password) {
		
		return service.checkLogin(username, password);
		
	}
	
	@PostMapping("/api/users")
	public UserDTO postMethodName(@RequestBody UserDTO userRequest) {
		
		return service.createUsers(userRequest) ;
	}
	
	
}
