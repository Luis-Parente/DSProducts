package com.devsuperior.DSProducts.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.DSProducts.model.dto.ProductDTO;
import com.devsuperior.DSProducts.model.entities.Product;
import com.devsuperior.DSProducts.repositories.ProductRepository;
import com.devsuperior.DSProducts.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public ProductDTO findById(UUID id) {
		Product result = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		return new ProductDTO(result);
	}

	public List<ProductDTO> findByDepartment(String department) {
		List<Product> result;
		if ("".equals(department)) {
			result = repository.findAll();
		} else {
			result = repository.findByDepartment(department);
		}

		return result.stream().map(x -> new ProductDTO(x)).toList();
	}

	public List<ProductDTO> findByDescription(String text) {
		List<Product> result;
		if ("".equals(text)) {
			result = repository.findAll();
		} else {
			result = repository.findByDescription("%" + text + "%");
		}

		return result.stream().map(x -> new ProductDTO(x)).toList();
	}
}
