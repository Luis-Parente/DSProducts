package com.devsuperior.DSProducts.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.devsuperior.DSProducts.model.entities.Product;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

	@AllowFiltering
	public List<Product> findByDepartment(String department);

	@Query("SELECT * FROM products WHERE description LIKE :text")
	public List<Product> findByDescription(String text);

}
