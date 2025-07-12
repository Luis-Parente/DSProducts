package com.devsuperior.DSProducts.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DSProducts.model.dto.ProductDTO;
import com.devsuperior.DSProducts.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
		ProductDTO result = service.findById(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findByDepartment(@RequestParam(defaultValue = "") String department) {
		List<ProductDTO> result = service.findByDepartment(department);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/description")
	public ResponseEntity<List<ProductDTO>> findByDescription(@RequestParam(defaultValue = "") String text) {
		List<ProductDTO> result = service.findByDescription(text);
		return ResponseEntity.ok(result);
	}
}
