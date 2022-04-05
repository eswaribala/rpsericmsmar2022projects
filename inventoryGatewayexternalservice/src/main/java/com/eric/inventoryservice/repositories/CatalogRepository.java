package com.eric.inventoryservice.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eric.inventoryservice.models.Catalog;
//CRUD operation
public interface CatalogRepository extends JpaRepository<Catalog,Long>{

	//jpql query
	//JPA refers class and fields not table
	@Modifying
	@Transactional
	@Query("delete from Catalog catalog where catalog.catalogName=:catalogName")
	public void deleteByCatalogName(@Param("catalogName") String catalogName);

	@Query("select catalog from Catalog catalog where catalog.catalogName=:catalogName")
	public List<Catalog> findByCatalogName(@Param("catalogName") String catalogName);
}
