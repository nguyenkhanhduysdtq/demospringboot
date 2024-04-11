package com.laptrinhjava.mapper;

import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.entity.CategoryEntity;
import com.laptrinhjava.entity.NewEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T21:45:58+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class NewMapperImpl implements NewMapper {

    @Override
    public NewEntity toEntity(NewDTO dto) {
        if ( dto == null ) {
            return null;
        }

        NewEntity.NewEntityBuilder newEntity = NewEntity.builder();

        newEntity.category( categoryDTOToCategoryEntity( dto.getCategory() ) );
        newEntity.content( dto.getContent() );
        newEntity.shortDescription( dto.getShortDescription() );
        newEntity.thumbnail( dto.getThumbnail() );
        newEntity.title( dto.getTitle() );

        return newEntity.build();
    }

    @Override
    public NewDTO toDTO(NewEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NewDTO.NewDTOBuilder newDTO = NewDTO.builder();

        newDTO.category( categoryEntityToCategoryDTO( entity.getCategory() ) );
        newDTO.content( entity.getContent() );
        newDTO.shortDescription( entity.getShortDescription() );
        newDTO.thumbnail( entity.getThumbnail() );
        newDTO.title( entity.getTitle() );

        return newDTO.build();
    }

    protected List<NewEntity> newDTOListToNewEntityList(List<NewDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<NewEntity> list1 = new ArrayList<NewEntity>( list.size() );
        for ( NewDTO newDTO : list ) {
            list1.add( toEntity( newDTO ) );
        }

        return list1;
    }

    protected CategoryEntity categoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.code( categoryDTO.getCode() );
        categoryEntity.name( categoryDTO.getName() );
        categoryEntity.news( newDTOListToNewEntityList( categoryDTO.getNews() ) );

        return categoryEntity.build();
    }

    protected List<NewDTO> newEntityListToNewDTOList(List<NewEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<NewDTO> list1 = new ArrayList<NewDTO>( list.size() );
        for ( NewEntity newEntity : list ) {
            list1.add( toDTO( newEntity ) );
        }

        return list1;
    }

    protected CategoryDTO categoryEntityToCategoryDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDTO.CategoryDTOBuilder categoryDTO = CategoryDTO.builder();

        categoryDTO.code( categoryEntity.getCode() );
        categoryDTO.name( categoryEntity.getName() );
        categoryDTO.news( newEntityListToNewDTOList( categoryEntity.getNews() ) );

        return categoryDTO.build();
    }
}
