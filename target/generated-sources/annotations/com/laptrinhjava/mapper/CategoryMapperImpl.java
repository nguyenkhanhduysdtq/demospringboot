package com.laptrinhjava.mapper;

import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.entity.CategoryEntity;
import com.laptrinhjava.entity.NewEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T21:41:29+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Autowired
    private NewMapper newMapper;

    @Override
    public CategoryDTO toDTO(CategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDTO.CategoryDTOBuilder categoryDTO = CategoryDTO.builder();

        categoryDTO.code( entity.getCode() );
        categoryDTO.name( entity.getName() );
        categoryDTO.news( newEntityListToNewDTOList( entity.getNews() ) );

        return categoryDTO.build();
    }

    @Override
    public CategoryEntity toEntity(CategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.code( dto.getCode() );
        categoryEntity.name( dto.getName() );
        categoryEntity.news( newDTOListToNewEntityList( dto.getNews() ) );

        return categoryEntity.build();
    }

    protected List<NewDTO> newEntityListToNewDTOList(List<NewEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<NewDTO> list1 = new ArrayList<NewDTO>( list.size() );
        for ( NewEntity newEntity : list ) {
            list1.add( newMapper.toDTO( newEntity ) );
        }

        return list1;
    }

    protected List<NewEntity> newDTOListToNewEntityList(List<NewDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<NewEntity> list1 = new ArrayList<NewEntity>( list.size() );
        for ( NewDTO newDTO : list ) {
            list1.add( newMapper.toEntity( newDTO ) );
        }

        return list1;
    }
}
