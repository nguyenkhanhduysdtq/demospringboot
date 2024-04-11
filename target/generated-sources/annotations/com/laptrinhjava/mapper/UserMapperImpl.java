package com.laptrinhjava.mapper;

import com.laptrinhjava.dto.UserDTO;
import com.laptrinhjava.entity.UserEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T21:43:32+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.fullName( dto.getFullName() );
        userEntity.password( dto.getPassword() );
        userEntity.status( dto.getStatus() );
        userEntity.userName( dto.getUserName() );

        return userEntity.build();
    }

    @Override
    public UserDTO toDTO(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.fullName( entity.getFullName() );
        userDTO.password( entity.getPassword() );
        userDTO.status( entity.getStatus() );
        userDTO.userName( entity.getUserName() );

        return userDTO.build();
    }
}
