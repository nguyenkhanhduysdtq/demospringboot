package com.laptrinhjava.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO extends BaseDTO<UserDTO> {

	 String userName;

	 String password;

	 String fullName;

	 Integer status;
	 
	 List<RolesDTO> roleCode;


	
	
}
