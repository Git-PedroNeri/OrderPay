package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	CategoryService categoryService;//Bussiness

	/**
	 * Retorna todas as categorias cadastradas no banco de dados
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categorias = categoryService.findAll();
		return ResponseEntity.ok().body(categorias);
	}

	/**
	 * Retorna Category passando o id como parametro
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);

	}

}
