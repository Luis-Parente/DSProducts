package com.devsuperior.DSProducts.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.devsuperior.DSProducts.model.entities.Department;

public interface DepartmentRepository extends CassandraRepository<Department, UUID>{

}
