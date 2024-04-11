package com.laptrinhjava.service.impl;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjava.dto.UserDTO;
import com.laptrinhjava.entity.RoleEntity;
import com.laptrinhjava.entity.UserEntity;
import com.laptrinhjava.mapper.UserMapper;
import com.laptrinhjava.repository.UserRepository;
import com.laptrinhjava.service.IUserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor // lấy các biến có define trong đây để tạo thành constructor 
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService {
	
	UserRepository repository;
	
	UserMapper mapper ;

	@Override 
	public String checkLogin(String username, String password) {
		
		UserEntity user = repository.findOneByUserNameAndPassword(username,password);
		
		List<RoleEntity> role = user.getRoles();
		
		if(user != null) {
			for(RoleEntity x : role) {
				if(x.getCode().equalsIgnoreCase("ADMIN")) {
					return "ADMIN";
				}
			}
		}
		
		return  "USER";
	}
	@Override
	@Transactional
	public UserDTO createUsers(UserDTO userRequest) {
		
		UserEntity entity = repository.findOneByUserName(userRequest.getUserName());
		
		if(entity == null) {
			 
			return mapper.toDTO(repository.save(mapper.toEntity(userRequest)));
		}
		
		throw new EntityExistsException("Tài khoản đã tồn tại");
		
	}

}
