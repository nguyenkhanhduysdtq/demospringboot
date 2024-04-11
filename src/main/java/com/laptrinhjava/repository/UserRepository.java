package com.laptrinhjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjava.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndPassword(String userName,String password);

	UserEntity findOneByUserName(String userName);

}
