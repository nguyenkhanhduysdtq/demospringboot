package com.laptrinhjava.mapper;

import org.mapstruct.Mapper;

import com.laptrinhjava.dto.UserDTO;
import com.laptrinhjava.entity.UserEntity;

@Mapper(componentModel = "spring" ,uses = {RolesMapper.class,})
public interface UserMapper {

	
	UserEntity toEntity(UserDTO dto);
	
	UserDTO toDTO(UserEntity entity);
}
