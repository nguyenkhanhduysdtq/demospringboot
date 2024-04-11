package com.laptrinhjava.mapper;

import org.mapstruct.Mapper;

import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.entity.CategoryEntity;

@Mapper(componentModel = "spring" ,uses = NewMapper.class )
public interface CategoryMapper {

	CategoryDTO toDTO(CategoryEntity entity);
	CategoryEntity toEntity(CategoryDTO dto);
}
