package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.RequestDto;
import com.example.demo.model.ResponseDto;


public interface UserService {
	
	public ResponseDto addData(RequestDto requestDto);
	
	public List<UserEntity> getUserData();
	
	
	public ResponseDto updateUserData(RequestDto requestDto);
	
	public ResponseDto deleteUserData(RequestDto requestDto);
	
	
	
}