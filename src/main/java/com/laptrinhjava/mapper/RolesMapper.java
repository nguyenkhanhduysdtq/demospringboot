package com.laptrinhjava.mapper;

import org.mapstruct.Mapper;

import com.laptrinhjava.dto.RolesDTO;
import com.laptrinhjava.entity.RoleEntity;

@Mapper(componentModel = "spring" ,uses = UserMapper.class)
public interface RolesMapper {

	RolesDTO toDTO(RoleEntity entity);
	RoleEntity toEntity(RolesDTO dto);

}
