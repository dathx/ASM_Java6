package com.j6.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.j6.dao.CategoryDAO;
import com.j6.entity.Category;

import lombok.Data;



@CrossOrigin("*")
@RestController
public class CategoryRestController {
	@Autowired
	CategoryDAO cdao;
	
	@GetMapping("/rest/categories")
	public ResponseEntity<List<Category>> getAll(Model model){
		return ResponseEntity.ok(cdao.findAll()); 
	}
	
	@GetMapping("/rest/categories/{id}")
	public ResponseEntity<Category> getOne(@PathVariable("id") String id){
		if (!cdao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cdao.findById(id).get());
	}
	
	@PostMapping("/rest/categories")
	public ResponseEntity<Category> post(@RequestBody Category category){
		if (cdao.existsById(category.getId())) {
			return ResponseEntity.badRequest().build();
		}
		cdao.save(category);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping("/rest/categories/{id}")
	public ResponseEntity<Category> put(@PathVariable("id") String id, @RequestBody Category category){
		if (!cdao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cdao.save(category);
		return ResponseEntity.ok(category);
	}


	@DeleteMapping("/rest/categories/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		if (!cdao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cdao.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
