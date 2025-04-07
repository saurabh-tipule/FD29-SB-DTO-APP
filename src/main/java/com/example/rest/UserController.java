package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserRequestDto;
import com.example.dto.UserResponseDto;
import com.example.resource.UserResource;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	private UserResource userResource;

	@Autowired
	public void setUserResource(UserResource userResource) {
		this.userResource = userResource;
	}

	@PostMapping(value = "/users")
	public ResponseEntity<String> addUser(@RequestBody UserRequestDto userRequestDto) {
		String msg = userResource.addUser(userRequestDto);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserResponseDto> getUserInfo(@PathVariable Integer id) {

		UserResponseDto userResponseDto = userResource.getUserInfo(id);
		return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.OK);
	}

}
