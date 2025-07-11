package com.devsuperior.DSProducts.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.devsuperior.DSProducts.model.entities.Product;

public interface ProductRepository extends CassandraRepository<Product, UUID>{

}
