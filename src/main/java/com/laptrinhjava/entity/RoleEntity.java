package com.laptrinhjava.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name ="role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends BaseEntity {
	
	@Column
	 String code;
	
	@Column
	 String name;
	
	@ManyToMany(mappedBy = "roles")
	@Builder.Default
	List<UserEntity> users = new ArrayList<UserEntity>(); 

	

	
}
