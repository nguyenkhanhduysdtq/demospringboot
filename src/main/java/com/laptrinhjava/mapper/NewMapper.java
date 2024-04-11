package com.laptrinhjava.mapper;

import org.mapstruct.Mapper;

import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.entity.NewEntity;

@Mapper(componentModel = "spring")
public interface NewMapper {
	
	
    NewEntity toEntity(NewDTO dto);

    NewDTO toDTO(NewEntity entity);
}
