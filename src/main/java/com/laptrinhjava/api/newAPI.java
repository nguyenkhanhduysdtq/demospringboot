package com.laptrinhjava.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.service.impl.NewService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class newAPI {

	NewService service;
	

	@PostMapping("/news")
	@CrossOrigin
	public NewDTO test(@RequestBody NewDTO model) {
		return service.save(model);
	}

	@PutMapping("/test/{id}")
	public NewDTO update(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return service.update(model);
	}

	@GetMapping("/api/news")
	@CrossOrigin
	public List<NewDTO> getAll() {
		return service.getAll();
	}

	@GetMapping("/newbyid/{id}")
	public NewDTO findOne(@PathVariable("id") int id) {
		return service.findOne(id);
	}

	@GetMapping("/newbycontent/{content}")
	public List<NewDTO> findbyContent(@PathVariable("content") String content) {
		return service.findByContent(content); 

	}

	@GetMapping("/api/test")

	public List<NewDTO> newFilter(@RequestParam(required = false) String content,
			@RequestParam(required = false) String thumbnail, @RequestParam(required = false) String title) {

		return service.newFilter(content, thumbnail, title);

	}

	@DeleteMapping("/api/delete/{id}")
	@CrossOrigin // cho bên ngoài có thể truy cập vào API ( error CORS)
	public void deleteNew(@PathVariable("id") long id) {

		service.deleteNew(id);
	}

}
