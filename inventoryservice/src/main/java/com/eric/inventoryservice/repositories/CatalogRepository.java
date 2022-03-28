package com.eric.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.inventoryservice.models.Catalog;
//CRUD operation
public interface CatalogRepository extends JpaRepository<Catalog,Long>{

}
