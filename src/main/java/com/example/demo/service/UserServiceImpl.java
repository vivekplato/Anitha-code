package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.RequestDto;
import com.example.demo.model.ResponseDto;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseDto addData(RequestDto requestDto) {
		ResponseDto response = new ResponseDto();
		try {
			UserEntity userentity = new UserEntity();
			userentity.setUsername(requestDto.getUsername());
			userentity.setPassword(requestDto.getPassword());
			userentity.setEmail(requestDto.getEmail());
			userRepository.save(userentity);
			response.setMessage("UserData created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public List<UserEntity> getUserData() {
		List<UserEntity> userEntity = userRepository.findAll();
		
		return userEntity;
	}

	@Override
	public ResponseDto updateUserData(RequestDto requestDto) {
		ResponseDto response = new ResponseDto();
		try {
			UserEntity userEntity = new UserEntity();
			userEntity = userRepository.getOne(requestDto.getId());
			if(userEntity!=null) {
				userEntity.setUsername(requestDto.getUsername());
				userEntity.setPassword(requestDto.getPassword());
				userEntity.setEmail(requestDto.getEmail());
				if(null!=userRepository.saveAndFlush(userEntity)) {
					response.setMessage("Data Updated Successfully");
				}else {
					response.setMessage("Failed to Update");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ResponseDto deleteUserData(RequestDto requestDto) {
		ResponseDto responseDto = new ResponseDto();
		try {
			userRepository.deleteById(requestDto.getId());
			responseDto.setMessage("Data deleted successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseDto;
	}

}
