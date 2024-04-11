package com.laptrinhjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjava.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	List<NewEntity> findByContentLike(String content);
	NewEntity findById(long id);
	
}
