package com.laptrinhjava.mapper;

import com.laptrinhjava.dto.RolesDTO;
import com.laptrinhjava.entity.RoleEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:04:17+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class RolesMapperImpl implements RolesMapper {

    @Override
    public RolesDTO toDTO(RoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RolesDTO.RolesDTOBuilder rolesDTO = RolesDTO.builder();

        rolesDTO.code( entity.getCode() );
        rolesDTO.name( entity.getName() );

        return rolesDTO.build();
    }

    @Override
    public RoleEntity toEntity(RolesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RoleEntity.RoleEntityBuilder roleEntity = RoleEntity.builder();

        roleEntity.code( dto.getCode() );
        roleEntity.name( dto.getName() );

        return roleEntity.build();
    }
}
