package com.eric.inventoryservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.inventoryservice.models.Catalog;
import com.eric.inventoryservice.repositories.CatalogRepository;

@Service
public class CatalogService {
    @Autowired 
	private CatalogRepository catalogRepository;
	//insert
	public Catalog addCatalog(Catalog catalog) {
		return this.catalogRepository.save(catalog);
	}
	
	//select all
	public List<Catalog> getAllCatalogs(){
		return this.catalogRepository.findAll();
	}
	
	
	//select where
	public Catalog getCatalogById(long catalogId) {
		return this.catalogRepository.findById(catalogId).orElse(null);
	}
	
	//delete 
	
	public boolean deleteCatalog(long catalogId) {
		boolean status=false;
		this.catalogRepository.deleteById(catalogId);
		if(this.getCatalogById(catalogId)==null)
			status=true;
		return status;
		
	}
	
}
