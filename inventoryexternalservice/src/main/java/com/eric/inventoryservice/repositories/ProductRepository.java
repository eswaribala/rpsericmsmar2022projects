package com.eric.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.inventoryservice.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
