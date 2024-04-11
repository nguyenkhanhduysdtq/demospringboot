package com.laptrinhjava.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjava.converter.NewConverter;
import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.entity.CategoryEntity;
import com.laptrinhjava.entity.NewEntity;
import com.laptrinhjava.mapper.NewMapper;
import com.laptrinhjava.repository.CategoryRepository;
import com.laptrinhjava.repository.NewRepository;
import com.laptrinhjava.service.INewService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NewService implements INewService {

	
	NewRepository resRepository;

	
	CategoryRepository caRepository;

	
	NewConverter converter;

	NewMapper mapper;

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		NewEntity eNewEntity = mapper.toEntity(dto);
		CategoryEntity categoryEntity = caRepository.findOneByCode(dto.getCategory().getCode());

		eNewEntity.setCategory(categoryEntity);
		return mapper.toDTO(resRepository.save(eNewEntity));
	}

	@Override
	@Transactional
	public NewDTO update(NewDTO dto) {

		NewEntity oldNew = resRepository.findOne(dto.getId());
		NewEntity newEntity = converter.toEntity(dto, oldNew);

		CategoryEntity categoryEntity = caRepository.findOneByCode(dto.getCategory().getCode());

		newEntity.setCategory(categoryEntity);

		return mapper.toDTO(resRepository.save(newEntity));
	}

	@Override
	public List<NewDTO> getAll() {

		List<NewEntity> listEntities = resRepository.findAll();

		List<NewDTO> listDTO = listEntities.stream().map(entity -> mapper.toDTO(entity)).collect(Collectors.toList());

		return listDTO;
	}

	@Override
	public NewDTO findOne(int id) {
		NewEntity entity = resRepository.findById((long) id);
		if (entity != null) {
			return mapper.toDTO(entity);
		}

		throw new RuntimeException("lấy dữ liệu không thành công");
	}

	@Override
	public List<NewDTO> findByContent(String content) {

		List<NewEntity> listNewEntity = resRepository.findByContentLike("%" + content + "%");

		// sử dụng stream java
		List<NewDTO> result = listNewEntity.stream().map(Entity -> mapper.toDTO(Entity)).collect(Collectors.toList());

		return result;
	}

	@Override
	public List<NewDTO> newFilter(String content, String thumbnail, String title) {
		List<NewEntity> list = resRepository.findAll();

		List<NewDTO> result = list.stream().map(entity -> mapper.toDTO(entity)).collect(Collectors.toList());

		if (content != null) {
			result.removeIf(newDTO -> !newDTO.getContent().equalsIgnoreCase(content));
		}

		if (thumbnail != null) {
			result.removeIf(newDTO -> !newDTO.getThumbnail().equalsIgnoreCase(thumbnail));
		}

		if (title != null) {
			result.removeIf(newDTO -> !newDTO.getTitle().equalsIgnoreCase(title));
		}

		return result;
	}

	@Override
	@Transactional
	public void deleteNew(long id) {

		resRepository.delete(id);

	}

}
