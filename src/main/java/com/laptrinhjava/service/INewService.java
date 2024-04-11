package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO dto);
	NewDTO update(NewDTO dto);
	List<NewDTO> getAll();
	NewDTO findOne(int id);
	List<NewDTO> findByContent(String content);
	List<NewDTO> newFilter(String content,String thumbnail,String title);
	
	void deleteNew(long id);
}
