package com.eric.inventoryservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.inventoryservice.models.Catalog;
import com.eric.inventoryservice.services.CatalogService;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {
    @Autowired
	private CatalogService catalogService;
    
    //add category
    //http://localhost:7070/catalogs/v1.0
    @PostMapping({"/v1.0"})
    public ResponseEntity<?> saveCatalog(@RequestBody Catalog catalog){
    	Catalog catalogObj=this.catalogService.addCatalog(catalog);
    	if(catalogObj!=null) 
    		return ResponseEntity.status(HttpStatus.CREATED).body(catalogObj);
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Catalog not created");	
    	}
    
    
    //select all
    @GetMapping({"/v1.0"})
    public List<Catalog> getAllCatalogs(){
    	return this.catalogService.getAllCatalogs();
    }
    
    
    //select by id
    @GetMapping({"/v1.0/{catalogId}"})
    public ResponseEntity<?> getCatalogById(@PathVariable("catalogId") long catalogId) {
    	 
    	Catalog catalogObj=this.catalogService.getCatalogById(catalogId);
    	if(catalogObj!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED).body(catalogObj);
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Catalog not found");	
    	}
    }
    
    
    
    }


   
    
	
	

