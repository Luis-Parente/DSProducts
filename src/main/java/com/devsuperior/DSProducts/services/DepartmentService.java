package com.devsuperior.DSProducts.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.DSProducts.model.dto.DepartmentDTO;
import com.devsuperior.DSProducts.model.entities.Department;
import com.devsuperior.DSProducts.repositories.DepartmentRepository;
import com.devsuperior.DSProducts.services.exceptions.ResourceNotFoundException;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public List<DepartmentDTO> findAll() {
		List<Department> result = repository.findAll();
		return result.stream().map(x -> new DepartmentDTO(x)).toList();
	}

	public DepartmentDTO findById(UUID id) {
		Department result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		return new DepartmentDTO(result);
	}

	public DepartmentDTO insert(DepartmentDTO dto) {
		Department entity = new Department();
		entity.setId(UUID.randomUUID());
		entity.setName(dto.getName());

		entity = repository.save(entity);

		return new DepartmentDTO(entity);
	}

	public DepartmentDTO update(DepartmentDTO dto, UUID id) {
		Department entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		entity.setName(dto.getName());

		entity = repository.save(entity);

		return new DepartmentDTO(entity);
	}

	public void delete(UUID id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Object not found");
		}
		repository.deleteById(id);

	}

}
