package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.RequestDto;
import com.example.demo.model.ResponseDto;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/test")
	public String check() {
		return "Welcome";
	}
	
	@PostMapping("/createUser")
	public ResponseDto addUser(@RequestBody RequestDto requestDto) {
		ResponseDto response = userService.addData(requestDto);
		return response;
		
	}
	@GetMapping("/getAllData")
	public List<UserEntity> getData(){
		List<UserEntity> entity = userService.getUserData();
		return entity;
		
	}
	
	@PostMapping("/updateUserDetails")
	public ResponseDto updateData(@RequestBody RequestDto requestDto) {
		ResponseDto responseDto = userService.updateUserData(requestDto);
		return responseDto;
		
	}
	
	@DeleteMapping("/deleteSingleData")
	public ResponseDto deleteData(@RequestBody RequestDto requestDto) {
		ResponseDto responseDto = userService.deleteUserData(requestDto);
		return responseDto;
		
	}

}