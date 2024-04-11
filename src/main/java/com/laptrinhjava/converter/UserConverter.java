package com.laptrinhjava.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjava.dto.UserDTO;
import com.laptrinhjava.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDto(UserEntity entity) {
		
		UserDTO dto =new UserDTO();
		dto.setFullName(entity.getFullName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
}
